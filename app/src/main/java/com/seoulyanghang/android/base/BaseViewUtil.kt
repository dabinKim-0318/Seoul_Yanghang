package com.seoulyanghang.android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

//여기선 왜 굳이 sealed class로 정의한걸까...abstract class 로 해도 되지 않나..
sealed class BaseViewUtil {
    //상속이 가능한 open클래스와 다르게 추상클래스는 상속이 필수적이다. 즉 얘 자체로 객체를 만들어서 쓰기 위함이 아니라 상속을 위한 클래스.
//따라서 Base~ 는 그자체로 사용할 거 아니니까 상속이 필수적인 abstract로 선언하자
    abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes val layout: Int) : Fragment() {
        private var _binding: T? = null
        val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = DataBindingUtil.inflate(inflater, layout, container, false)
            binding.lifecycleOwner = viewLifecycleOwner  //라이프사이클 안줘도 실행 잘되는데 왜 꼭 줘야할까?
            return binding.root
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }

    abstract class BaseAppCompatActivity<T : ViewDataBinding>(@LayoutRes val layoutRes: Int) :
        AppCompatActivity() {
        protected lateinit var binding: T
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView(this, layoutRes)

        }
    }
}