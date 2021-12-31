package com.seoulyanghang.android.presentation.ui.home.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdViewPagerAdapter(private val fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = Int.MAX_VALUE

    override fun createFragment(position: Int): Fragment {
        return when (position % 3) {
            0 -> FirstAdFragment()
            1 -> SecondAdFragment()
            2 -> ThirdAdFragment()
            else -> FirstAdFragment()
        }
    }
}