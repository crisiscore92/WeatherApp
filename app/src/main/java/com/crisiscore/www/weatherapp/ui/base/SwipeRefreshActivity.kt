package com.crisiscore.www.weatherapp.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.widget.ScrollView
import com.crisiscore.www.weatherapp.R


abstract class SwipeRefreshActivity:
        DrawerActivity(),
        SwipeRefreshLayout.OnRefreshListener {

    protected lateinit var swipeRefreshContainer: ScrollView

    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val contentView = inflater.inflate(R.layout.activity_swipe_refresh, null, false)
        container.addView(contentView, 0)

        initViews()
    }

    private fun initViews() {
        swipeRefreshContainer = findViewById(R.id.swipeRefreshContainer)

        refreshLayout = findViewById(R.id.swipeRefreshLayout)
        refreshLayout.setOnRefreshListener(this)
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_red_dark)
    }

    override fun onRefresh() {
        refreshLayout.isRefreshing = false
    }

    override fun currentActivityName(): String {
        return this::class.java.simpleName
    }
}