package com.roomy_mobile

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val USER_AGENT_FAKE =
        "Mozilla/5.0 (Linux; Android 4.1.1; Roomy Native) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19"

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webview)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }


            override fun onPageFinished(view: WebView, url: String) {
                // TODO Auto-generated method stub
                super.onPageFinished(view, url)
            }


        }

        val webSettings: WebSettings = webView.getSettings()
        webSettings.setUserAgentString(USER_AGENT_FAKE);
        webSettings.javaScriptEnabled = true

        webView.loadUrl("http://jjxpa.com/")

    }
    override fun onBackPressed() {
        when {
            webView?.canGoBack() == true -> webView.goBack()
            else -> super.onBackPressed()
        }
    }

}
