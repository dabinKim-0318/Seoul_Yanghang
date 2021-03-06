package com.seoulyanghang.android.presentation.ui.user.signup.view

import android.os.Bundle
import com.seoulyanghang.android.R
import com.seoulyanghang.android.presentation.base.BaseViewUtil
import com.seoulyanghang.android.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BaseViewUtil.BaseAppCompatActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}