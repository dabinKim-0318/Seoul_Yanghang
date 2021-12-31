package com.seoulyanghang.android.presentation.ui.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulyanghang.android.R
import com.seoulyanghang.android.presentation.base.BaseViewUtil
import com.seoulyanghang.android.databinding.FragmentFirstAdBinding
import com.seoulyanghang.android.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstAdFragment : BaseViewUtil.BaseFragment<FragmentFirstAdBinding>(R.layout.fragment_first_ad) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}