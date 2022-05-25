package com.example.technicaltest.presentation.ui.episodeDetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import coil.load
import com.example.technicaltest.databinding.ActivityEpisodeDetailsBinding
import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.utils.activityViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailsActivity : AppCompatActivity() {

    private val binding by activityViewBinding(ActivityEpisodeDetailsBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val domainEpisodeItem = intent.getParcelableExtra(INTENT_TEST_ITEM_DATA) as? DomainEpisode

        if (domainEpisodeItem != null) {
            setupUI(domainEpisodeItem)
        } else {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupUI(domainEpisodeItem: DomainEpisode) {
        with(binding) {
            setSupportActionBar(toolbar)
            supportActionBar?.run {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                setDisplayShowTitleEnabled(false)
            }

            imageView.load(domainEpisodeItem.originalImage)
            episodeTextView.text = domainEpisodeItem.name
            runtimeTextView.text = domainEpisodeItem.runtime.toString()
            airdateTextView.text = domainEpisodeItem.airdate
            airtimeTextView.text = domainEpisodeItem.airtime
            summaryTextView.text = HtmlCompat.fromHtml(domainEpisodeItem.summary, HtmlCompat.FROM_HTML_MODE_COMPACT)

            toolbarShareActionButton.setOnClickListener {
                Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, domainEpisodeItem.url)
                    type = "text/plain"
                    startActivity(Intent.createChooser(this, null))
                }
            }

            urlButton.setOnClickListener {
                val defaultBrowser = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
                defaultBrowser.data = Uri.parse(domainEpisodeItem.url)
                startActivity(defaultBrowser)
            }
        }
    }

    companion object {
        const val INTENT_TEST_ITEM_DATA = "intent_test_item_data"
    }
}