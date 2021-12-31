package com.seoulyanghang.android.presentation.ui.home.view

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.seoulyanghang.android.R
import com.seoulyanghang.android.presentation.base.BaseViewUtil
import com.seoulyanghang.android.databinding.FragmentHomeBinding
import com.seoulyanghang.android.databinding.FragmentItemInquiryBinding
import com.seoulyanghang.android.presentation.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.MotionEvent

import androidx.core.content.ContextCompat.getSystemService


@AndroidEntryPoint
class HomeFragment : BaseViewUtil.BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by viewModels()
    private val handler: MyHandler by lazy { MyHandler() }
    private var currentPosition = Int.MAX_VALUE / 2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeViewModel = homeViewModel
        binding.lifecycleOwner = this
        initView()
    }

    private fun initView() {
        initRootClickEvent()
        setViewPagerAdapter(requireActivity())
    }

    //화면 전체 아무곳이나 눌러도 키보드 내려가도록
    private fun initRootClickEvent() {
        binding.clRoot.setOnClickListener {
            ViewCompat.getWindowInsetsController(it)?.hide(WindowInsetsCompat.Type.ime())
        }
    }

    //ViewPager연결
    private fun setViewPagerAdapter(fragmentActivity: FragmentActivity) {
        val viewPagerAdapter = AdViewPagerAdapter(fragmentActivity)
        binding.vpHome.apply {
            adapter = viewPagerAdapter
            setCurrentItem(currentPosition, false)

            // ViewPager2의 현재 위치 표시+좌우 무한 스크롤
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
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
    }

    private fun setUIListener() {
        with(binding) {
            //상품검색 버튼 클릭
            ivHomeSearch.setOnClickListener {
            }


            //리사이클러뷰 아이템 클릭
        }
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
