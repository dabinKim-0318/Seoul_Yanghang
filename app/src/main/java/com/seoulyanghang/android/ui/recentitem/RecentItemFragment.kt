package com.seoulyanghang.android.ui.recentitem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulyanghang.android.R
import com.seoulyanghang.android.base.BaseViewUtil
import com.seoulyanghang.android.databinding.FragmentLoveItemBinding
import com.seoulyanghang.android.databinding.FragmentRecentItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentItemFragment : BaseViewUtil.BaseFragment<FragmentRecentItemBinding>(R.layout.fragment_recent_item) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
