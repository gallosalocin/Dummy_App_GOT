package com.example.technicaltest.presentation.ui.episodesListing

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technicaltest.R
import com.example.technicaltest.databinding.ActivityEpisodesListingBinding
import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.presentation.ui.episodeDetails.EpisodeDetailsActivity
import com.example.technicaltest.presentation.ui.episodesListing.adapter.Adapter
import com.example.technicaltest.presentation.ui.episodesListing.adapter.AdapterDelegate
import com.example.technicaltest.presentation.ui.utils.activityViewBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class EpisodesListingActivity : AppCompatActivity(), AdapterDelegate {

    @Inject lateinit var adapter: Adapter

    private val viewModel: EpisodesListingViewModel by viewModels()

    private val binding by activityViewBinding(ActivityEpisodesListingBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupAdapter()
        subscribeToObservables()
    }

    private fun setupAdapter() {
        with(binding.recyclerView) {
            adapter = this@EpisodesListingActivity.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        adapter.delegate = this
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun subscribeToObservables() {
        lifecycleScope.launchWhenStarted {
            viewModel.viewState.collectLatest { state ->
                when (state) {
                    is EpisodesListingState.Loading -> binding.motionLayout.transitionToState(R.id.loading)
                    is EpisodesListingState.Success -> {
                        adapter.submitList(state.list)
                        binding.motionLayout.transitionToState(R.id.success)
                    }
                    is EpisodesListingState.Error -> {
                        Snackbar.make(binding.root, state.errorMessage, Snackbar.LENGTH_SHORT).show()
                        binding.motionLayout.transitionToState(R.id.error)
                    }
                }
            }
        }
    }

    //region TestAdapterDelegate Callbacks
    override fun didSelectItem(domainEpisode: DomainEpisode) {
        Intent(this, EpisodeDetailsActivity::class.java)
            .apply { putExtra(EpisodeDetailsActivity.INTENT_TEST_ITEM_DATA, domainEpisode) }
            .also { intent -> startActivity(intent) }
    }
    //endregion
}