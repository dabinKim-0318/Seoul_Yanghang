package com.seoulyanghang.android.presentation.ui.user.login.view

import android.os.Bundle
import com.seoulyanghang.android.R
import com.seoulyanghang.android.presentation.base.BaseViewUtil
import com.seoulyanghang.android.databinding.ActivityLogInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInActivity : BaseViewUtil.BaseAppCompatActivity<ActivityLogInBinding>(R.layout.activity_log_in) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}