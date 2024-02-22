package com.example.appli_livre

import LivreAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appli_livre.ui.theme.Appli_livreTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentUser = Firebase.auth.currentUser
        if (currentUser == null) {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
            finish()
        } else {

            val bookListIntent = Intent(this, ListeLivreActivity::class.java)
            startActivity(bookListIntent)
            finish()
        }
    }
}
