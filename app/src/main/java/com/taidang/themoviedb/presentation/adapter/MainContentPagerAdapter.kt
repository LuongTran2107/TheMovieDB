package com.taidang.themoviedb.presentation.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.taidang.themoviedb.R
import com.taidang.themoviedb.presentation.fragment.NowPlayingMoviesFragment

class MainContentPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    companion object {
        private const val TOTAL_PAGES = 1
        private const val INDEX_NOW_PLAYING = 0
    }

    override fun getItem(position: Int): Fragment = when (position) {
        INDEX_NOW_PLAYING -> NowPlayingMoviesFragment()
        else -> throw IllegalArgumentException()
    }

    override fun getPageTitle(position: Int): String = when (position) {
        INDEX_NOW_PLAYING -> context.getString(R.string.now_playing_movie_tab_name)
        else -> throw IllegalArgumentException()
    }

    override fun getCount() = TOTAL_PAGES
}