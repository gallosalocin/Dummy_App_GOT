package com.example.technicaltest.ui.modules

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
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

            imageView.load(uiEpisodeItem.originalImage)
            episodeTextView.text = uiEpisodeItem.name
            runtimeTextView.text = uiEpisodeItem.runtime.toString()
            airdateTextView.text = uiEpisodeItem.airdate
            airtimeTextView.text = uiEpisodeItem.airtime
            summaryTextView.text = uiEpisodeItem.summary

            toolbarShareActionButton.setOnClickListener {
                Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, uiEpisodeItem.url)
                    type = "text/plain"
                    startActivity(Intent.createChooser(this, null))
                }
            }

            urlButton.setOnClickListener {
                val defaultBrowser = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
                defaultBrowser.data = Uri.parse(uiEpisodeItem.url)
                startActivity(defaultBrowser)
            }
        }
    }

    //region MainDetailsView Callbacks

    //endregion

    companion object {
        const val INTENT_TEST_ITEM_DATA = "intent_test_item_data"
    }
}