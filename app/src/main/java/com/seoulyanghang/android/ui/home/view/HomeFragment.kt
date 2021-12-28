package com.seoulyanghang.android.ui.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.seoulyanghang.android.R
import com.seoulyanghang.android.base.BaseViewUtil
import com.seoulyanghang.android.databinding.FragmentHomeBinding
import com.seoulyanghang.android.databinding.FragmentItemInquiryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseViewUtil.BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPagerAdapter(requireActivity())
    }

    //ViewPager연결
    fun setViewPagerAdapter(fragmentActivity: FragmentActivity) {
        val viewPagerAdapter = AdViewPagerAdapter(fragmentActivity)
        binding.vpHome.apply {
            adapter = viewPagerAdapter
        }
    }
}
