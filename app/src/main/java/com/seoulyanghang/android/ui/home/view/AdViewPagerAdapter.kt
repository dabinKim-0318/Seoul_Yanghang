package com.seoulyanghang.android.ui.home.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdViewPagerAdapter(private val fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = AD_PAGE_NUM

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstAdFragment()
            1 -> SecondAdFragment()
            2 -> ThirdAdFragment()
            else -> FirstAdFragment()
        }
    }
    companion object {
        const val AD_PAGE_NUM = 3
    }
}