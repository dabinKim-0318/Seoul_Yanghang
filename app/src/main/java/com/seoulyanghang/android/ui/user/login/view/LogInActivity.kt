package com.seoulyanghang.android.ui.user.login.view

import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.seoulyanghang.android.R
import com.seoulyanghang.android.base.BaseViewUtil
import com.seoulyanghang.android.databinding.ActivityLogInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInActivity : BaseViewUtil.BaseAppCompatActivity<ActivityLogInBinding>(R.layout.activity_log_in) {
    private lateinit var firebaseAuth: FirebaseAuth
 


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}