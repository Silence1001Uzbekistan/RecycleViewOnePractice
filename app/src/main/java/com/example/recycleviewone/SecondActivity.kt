package com.example.recycleviewone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewone.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var bindingS: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingS = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingS.root)


    }
}