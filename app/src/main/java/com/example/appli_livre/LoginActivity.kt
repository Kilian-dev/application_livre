package com.example.appli_livre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        auth = Firebase.auth

        val loginButton = findViewById<Button>(R.id.LoginButton)
        loginButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.email).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString()
            signIn(email, password)
    }


}

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val intent = Intent(this, ListeLivreActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {

                    Toast.makeText(baseContext, "Erreur de connexion",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}