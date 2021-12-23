package com.seoulyanghang.android.ui.shoppingbasket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulyanghang.android.R
import com.seoulyanghang.android.base.BaseViewUtil
import com.seoulyanghang.android.databinding.FragmentRecentItemBinding
import com.seoulyanghang.android.databinding.FragmentShoppingBasketBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingBasketFragment : BaseViewUtil.BaseFragment<FragmentShoppingBasketBinding>(R.layout.fragment_shopping_basket) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}