package com.example.technicaltest.ui.modules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.technicaltest.databinding.ActivityMainDetailsBinding
import com.example.technicaltest.presenter.models.UIEpisodeItem
import com.example.technicaltest.presenter.modules.MainDetailsPresenter
import com.example.technicaltest.presenter.modules.MainDetailsView
import com.example.technicaltest.ui.utils.activityViewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainDetailsActivity : AppCompatActivity(), MainDetailsView {

    @Inject lateinit var presenter: MainDetailsPresenter

    private val binding by activityViewBinding(ActivityMainDetailsBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val uiTestItem = intent.getParcelableExtra(INTENT_TEST_ITEM_DATA) as? UIEpisodeItem

        if (uiTestItem != null) {
            presenter.attach(this, lifecycle)
            setupUI(uiTestItem)
            presenter.setup()
        } else {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupUI(uiEpisodeItem: UIEpisodeItem) {
        with(binding) {
            setSupportActionBar(toolbar)
            supportActionBar?.run {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                setDisplayShowTitleEnabled(false)
            }

            episodeTextView.text = uiEpisodeItem.name
        }
    }

    //region MainDetailsView Callbacks

    //endregion

    companion object {
        const val INTENT_TEST_ITEM_DATA = "intent_test_item_data"
    }
}