package com.example.appli_livre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.semantics.Role.Companion.Button
import com.google.android.material.textfield.TextInputEditText
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}