package com.ramazanaltun.horoscopes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.ramazanaltun.horoscopes.databinding.ActivityMainBinding

class HoroscopeDetail : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityMainBinding.inflate(   LayoutInflater.from(this))
        setContentView(viewBinding.root)
        var position= intent.extras?.get("position")
        Toast.makeText(this,"clicked item: "+ position.toString(),Toast.LENGTH_LONG).show()

    }
}