package com.seoulyanghang.android.ui.itemreview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulyanghang.android.R
import com.seoulyanghang.android.base.BaseViewUtil
import com.seoulyanghang.android.databinding.FragmentItemReviewBinding
import com.seoulyanghang.android.databinding.FragmentLoveItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemReviewFragment : BaseViewUtil.BaseFragment<FragmentItemReviewBinding>(R.layout.fragment_item_review) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
