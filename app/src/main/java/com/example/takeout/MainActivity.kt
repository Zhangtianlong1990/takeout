package com.example.takeout

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var main_bottom_bar: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_bottom_bar = findViewById<LinearLayout>(R.id.main_bottom_bar)
        initBottomBar()
    }

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