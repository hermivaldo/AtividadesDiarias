package com.example.hermivaldobraga.atividadesdiarias

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        startActivity(Intent(this, PainelAct::class.java))

        finish()
    }
}
