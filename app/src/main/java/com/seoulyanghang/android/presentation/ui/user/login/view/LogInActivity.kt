package com.seoulyanghang.android.presentation.ui.user.login.view

import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.seoulyanghang.android.R
import com.seoulyanghang.android.databinding.ActivityLogInBinding
import com.seoulyanghang.android.presentation.base.BaseViewUtil
import com.seoulyanghang.android.presentation.ui.user.myPage.MyPageActivity
import com.seoulyanghang.android.presentation.ui.user.signup.view.SignUpActivity
import com.seoulyanghang.android.presentation.util.extension.shortToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInActivity : BaseViewUtil.BaseAppCompatActivity<ActivityLogInBinding>(R.layout.activity_log_in) {
    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        setUiListener()
        clickLogin()
        subcribeData()
    }


    private fun setUiListener() {
        with(binding) {
            //회원가입 버튼 클릭
            tvLoginSignup.setOnClickListener {
                startActivity(Intent(this@LogInActivity, SignUpActivity::class.java))
            }
            //아이디 찾기
            tvLoginFindId.setOnClickListener {

            }
            //비밀번호 찾기
            tvLoginFindPassword.setOnClickListener {

            }
        }
    }

    private fun clickLogin() {
        binding.loginLoginButton.setOnClickListener {
            logIn(binding.editxtLoginEmail.text.toString(), binding.editxtLoginPassword.text.toString())
            shortToast("로그인 click")
        }
    }

    //로그인 처리
    private fun logIn(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        shortToast("로그인 성공")
                        moveMainPage(auth?.currentUser)
                        finish()
                    }else{
                        shortToast("fail")
                    }
                }
        }
    }

    //MainPage로 이동
    private fun moveMainPage(user: FirebaseUser?) {
        startActivity(Intent(this, MyPageActivity::class.java))
        finish()
    }

    //viewmodel 구독
    private fun subcribeData() {

    }
}