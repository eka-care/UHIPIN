package com.android.uhilibrary

import android.content.Context
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PinVerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_verification)
        initUI()
    }

    private fun initUI()
    {
      var webView = findViewById<WebView>(R.id.web_View)
        webView.apply {
            settings.javaScriptEnabled = true
            settings.setSupportMultipleWindows(true)
            addJavascriptInterface(AppBridge(this@PinVerificationActivity,this), "UHI")
            isVerticalScrollBarEnabled = false
        }
        webView.loadUrl("https://sdk.dev.eka.care/transaction/12414")

    }


    class AppBridge(private val mActivity: AppCompatActivity, private val webView: WebView) {


        @JavascriptInterface
        fun showToast(toast: String) {
            Toast.makeText(mActivity, toast, Toast.LENGTH_SHORT).show()
        }

        @JavascriptInterface
        fun onVerified(success: Boolean) {
            if(success) {
                mActivity.setResult(RESULT_OK)
            }
            mActivity.finish()
        }
    }
}