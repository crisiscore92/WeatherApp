package com.crisiscore.www.weatherapp.ui.fivedaysforecast

import android.content.Context
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.ui.base.DrawerActivity

import kotlinx.android.synthetic.main.activity_five_days_forecast.*
import com.crisiscore.www.weatherapp.ui.fivedaysforecast.adapters.ViewPagerDaysAdapter


class FiveDaysForecastActivity :
        DrawerActivity(),
        FiveDaysForecastActivityContract.View {

    private val presenter = FiveDaysForecastActivityPresenter(this)

    private lateinit var viewPagerDaysAdapter: ViewPagerDaysAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val contentView = inflater.inflate(R.layout.activity_five_days_forecast, null, false)
        container.addView(contentView, 0)

        initViewPager()
    }

    private fun initViewPager() {
        presenter.getDataForViewPagerDaysAdapter()

        tabLayout.setupWithViewPager(viewPager)
    }

    override fun currentActivityName(): String = this::class.java.simpleName

    override fun setUpViewPagerDaysAdapter(receivedDateList: ArrayList<String>) {
        viewPagerDaysAdapter = ViewPagerDaysAdapter(supportFragmentManager)
        viewPagerDaysAdapter.initList(receivedDateList)

        viewPager.adapter = viewPagerDaysAdapter
        viewPager.offscreenPageLimit = 0
        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {


            }
        })
    }

}
