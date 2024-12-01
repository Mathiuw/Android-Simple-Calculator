package com.example.uscsapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var btnAdd : Button
    private lateinit var btnSub : Button
    private lateinit var btnMut : Button
    private lateinit var btnDiv : Button
    private lateinit var etA : EditText
    private lateinit var etB : EditText
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_subtract)
        btnMut = findViewById(R.id.btn_multiply)
        btnDiv = findViewById(R.id.btn_divide)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        tvResult = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMut.setOnClickListener(this)
        btnDiv.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        val a = etA.text
        val b = etB.text
        var result: Double? = 0.0

        if (a.toString() == "" || b.toString() == "")
        {
            return
        }

        val aD: Double = a.toString().toDouble()
        val bD: Double = b.toString().toDouble()

        when(v?.id)
        {
            R.id.btn_add -> {result = aD + bD}
            R.id.btn_subtract -> {result = aD - bD}
            R.id.btn_multiply -> {result = aD * bD}
            R.id.btn_divide -> {result = aD / bD}
        }

        tvResult.text = "Result: $result"
    }
}