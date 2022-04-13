package com.example.zadanko13042022

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newpassword = findViewById<EditText>(R.id.nowehaslo)
        val checkpassword = findViewById<EditText>(R.id.sprhaslo)
        val ustawbtn = findViewById<Button>(R.id.Ustawbtn)
        val sprbtn = findViewById<Button>(R.id.sprbtn)
        val showpassword1 = findViewById<Switch>(R.id.switch1)
        val showpassword2 = findViewById<Switch>(R.id.switch2)
        var haslo = ""
        ustawbtn.setOnClickListener {
            haslo = newpassword.text.toString()
        }
        sprbtn.setOnClickListener {
            val podhaslo = checkpassword.text
            if(podhaslo.toString() == haslo)
            {
                Toast.makeText(this, "Podane haslo jest poprawne", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Podane haslo jest niepoprawne", Toast.LENGTH_SHORT).show()
            }
        }
        showpassword1?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                newpassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            else
                newpassword.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        showpassword2?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                checkpassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            else
                checkpassword.transformationMethod = PasswordTransformationMethod.getInstance()
        }

    }
}