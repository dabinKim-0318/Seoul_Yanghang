package com.seoulyanghang.android.ui.home.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.seoulyanghang.android.R
import com.seoulyanghang.android.base.BaseViewUtil
import com.seoulyanghang.android.databinding.FragmentHomeBinding
import com.seoulyanghang.android.databinding.FragmentItemInquiryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseViewUtil.BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val handler: MyHandler by lazy { MyHandler() }
    private var currentPosition = Int.MAX_VALUE / 2
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPagerAdapter(requireActivity())
        setViewPagerCount()
    }

    //ViewPager연결
    private fun setViewPagerAdapter(fragmentActivity: FragmentActivity) {
        val viewPagerAdapter = AdViewPagerAdapter(fragmentActivity)
        binding.vpHome.apply {
            adapter = viewPagerAdapter
            setCurrentItem(currentPosition, false)
        }
    }

    //ViewPager2의 현재 위치 표시+좌우 무한 스크롤
    private fun setViewPagerCount() {
        binding.vpHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            //선택된 ViewPager의 position을 알려줌
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tvHomeCurrentPage.text = "${position % 3 + 1}"
            }

            //스크롤 상태에 따라 자동 스크롤 처리
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                when (state) {
                    ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(INTERVAL_TIME)
                    ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                }
            }
        })
    }

    //ViewPager 자동 스크롤을 위한 Handler
    private inner class MyHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 0) {
                binding.vpHome.setCurrentItem(++currentPosition, true)
                autoScrollStart(INTERVAL_TIME)
            }
        }
    }

    private fun autoScrollStart(intervalTime: Long) {
        handler.removeMessages(0)
        handler.sendEmptyMessageDelayed(0, INTERVAL_TIME)
    }

    private fun autoScrollStop() {
        handler.removeMessages(0)
    }

    override fun onResume() {
        super.onResume()
        autoScrollStart(INTERVAL_TIME)
    }

    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

    companion object {
        const val INTERVAL_TIME = 4000.toLong()
    }
}
