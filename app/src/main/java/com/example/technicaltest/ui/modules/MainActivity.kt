package com.example.technicaltest.ui.modules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technicaltest.databinding.ActivityMainBinding
import com.example.technicaltest.presenter.models.UITestItem
import com.example.technicaltest.presenter.modules.MainPresenter
import com.example.technicaltest.presenter.modules.MainView
import com.example.technicaltest.ui.modules.adapter.TestAdapter
import com.example.technicaltest.ui.modules.adapter.TestAdapterDelegate
import com.example.technicaltest.ui.utils.activityViewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView, TestAdapterDelegate {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var adapter: TestAdapter

    private val binding by activityViewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.attach(this, lifecycle)
        setupAdapter()
        setupUI()
        presenter.setup()
    }

    private fun setupAdapter() {
        with(binding.recyclerView) {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        adapter.delegate = this
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupUI() {
        with(binding) {
            setSupportActionBar(toolbar)
            supportActionBar?.run {
                setDisplayHomeAsUpEnabled(false)
                setDisplayShowHomeEnabled(false)
                setDisplayShowTitleEnabled(true)
            }
        }
    }

    //region MainView Callbacks
    override fun onReceiveTestItemsList(testItemsList: List<UITestItem>) {
        adapter.submitList(testItemsList) {
            binding.recyclerView.scrollToPosition(0)
        }
    }

    override fun onReceiveError() {
        Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show()
    }

    //endregion

    //region TestAdapterDelegate Callbacks
    override fun didSelectItem(item: UITestItem) {
        Intent(this, MainDetailsActivity::class.java)
            .apply { putExtra(MainDetailsActivity.INTENT_TEST_ITEM_DATA, item) }
            .also { intent -> startActivity(intent) }
    }
    //endregion
}