package com.roynaldi19.cvroynaldi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val link = listOf<LinkModel>(
            LinkModel("Github", R.drawable.github, "https://github.com/roynaldi19"),
            LinkModel("GoogleDev", R.drawable.adev, "https://developers.google.com/profile/u/roynaldi19"),

            )

        val linkAdapter = LinkAdapter(link, object : LinkAdapter.OnAdapterListener {
            override fun onClick(link: LinkModel) {
                openUrl(link.url)
            }

        })
        findViewById<RecyclerView>(R.id.rv_main).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = linkAdapter
        }

    }

    private fun openUrl(url: String) {
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }

}