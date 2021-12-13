package com.android.uhilibrary

import android.app.Activity
import android.content.Intent
import android.webkit.WebView
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity

class PinManager {

    companion object{

        private var webView:WebView?=null

        fun init(activty:Activity)
        {
            webView = WebView(activty)
            webView?.apply {
                settings.javaScriptEnabled = true
                settings.setSupportMultipleWindows(true)
                isVerticalScrollBarEnabled = false
            }

            //we may expect some input params to be passed with url

            webView!!.loadUrl("https://sdk.dev.eka.care/transaction/hoihoihk")
        }


        fun verifyPin(activty:AppCompatActivity,resultLauncher:ActivityResultLauncher<Intent>)
        {
            var nextIntent = Intent(activty,PinVerificationActivity::class.java)

            resultLauncher.launch(nextIntent)


        }

    }
}