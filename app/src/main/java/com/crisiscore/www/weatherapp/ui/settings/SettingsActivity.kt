package com.crisiscore.www.weatherapp.ui.settings

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceFragment
import android.view.LayoutInflater
import com.crisiscore.www.weatherapp.R
import com.crisiscore.www.weatherapp.ui.base.DrawerActivity

class SettingsActivity:
        DrawerActivity() {

    private val presenter = SettingsActivityPresenter(fragmentManager, PrefsFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val contentView = inflater.inflate(R.layout.activity_settings, null, false)
        container.addView(contentView, 0)

        presenter.replaceContentWithSettingsFragment()
    }

    class PrefsFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            addPreferencesFromResource(R.xml.pref)
        }
    }

    override fun currentActivityName(): String = this::class.java.simpleName
}

