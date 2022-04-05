package com.example.takeout.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.takeout.R
import com.example.takeout.ui.fragment.HomeFragment
import com.example.takeout.ui.fragment.MoreFragment
import com.example.takeout.ui.fragment.OrderFragment
import com.example.takeout.ui.fragment.UserFragment


class MainActivity : AppCompatActivity() {
    var main_bottom_bar: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_bottom_bar = findViewById<LinearLayout>(R.id.main_bottom_bar)
        initBottomBar()
        changeIndex(0)
    }
    val fragments: List<Fragment> = listOf<Fragment>(HomeFragment(),OrderFragment(),UserFragment(),MoreFragment())

    private fun initBottomBar() {
        main_bottom_bar?.run {
            for (i in 0 until this.childCount){
                this.getChildAt(i).setOnClickListener {
                    view -> changeIndex(i)
                }
            }
        }

    }

    private fun changeIndex(index: Int) {
        main_bottom_bar?.run {
            for (i in 0 until this.childCount){
                val child = this.getChildAt(i)
                if (i == index){
                    child.isEnabled = false
                    setEnable(child,false)
                }else{
                    setEnable(child,true)
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.main_content,fragments[index]).commit()
        }
    }

    private fun setEnable(child: View, isEnable: Boolean) {
        child.isEnabled = isEnable
        if (child is ViewGroup){
            for (i in 0 until child.childCount){
                child.getChildAt(i).isEnabled = isEnable
            }
        }
    }
}