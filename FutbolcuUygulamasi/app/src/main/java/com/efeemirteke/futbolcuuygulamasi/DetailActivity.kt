package com.efeemirteke.futbolcuuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent=intent
        val uzunYazi=intent.getStringExtra("uzunYazi")
        val futbolcuIsmi=intent.getStringExtra("futbolcuIsim")
        val futbolcuImg=intent.getIntExtra("futbolcuImg",0)
        Glide.with(this).load(futbolcuImg).into(imgViewFootballer)
        tvFootballerName.text=futbolcuIsmi
        tvFootballerDescription.text=uzunYazi
    }
}