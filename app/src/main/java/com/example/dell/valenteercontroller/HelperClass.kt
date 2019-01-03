package com.example.dell.valenteercontroller

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

fun progressBarEnable(progressBar: ProgressBar, loadingText: TextView){
    progressBar.visibility = View.VISIBLE
    loadingText.visibility = View.VISIBLE
}
fun progressBarDisable(progressBar: ProgressBar, loadingText: TextView){
    progressBar.visibility = View.INVISIBLE
    loadingText.visibility = View.INVISIBLE
}