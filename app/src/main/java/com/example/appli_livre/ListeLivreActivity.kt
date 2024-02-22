
package com.example.appli_livre

import LivreAdapter
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import classes.Livre
import com.example.DetailLivreActivity.DetailsLivreActivity
import com.example.appli_livre.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import classes.Livre as Livre1

class ListeLivreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.liste_livre)

        val recyclerView: RecyclerView = findViewById(R.id.ListeLivreRV)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val db = Firebase.firestore
        val listeLivres = mutableListOf<Livre>()

        db.collection("livre")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val titre = document.getString("titre") ?: ""
                    val auteur = document.getString("auteur") ?: ""
                    val synopsis = document.getString("synopsis") ?: ""
                    val imageUri = document.getString("imageUri") ?: ""
                    val isLu = document.getString("synopsis") ?: ""


                    val unlivre = Livre1(titre, auteur,imageUri, synopsis)
                    listeLivres.add(unlivre)
                }

                // Une fois que la liste des livres est remplie, créez et définissez l'adaptateur
                val adapter = LivreAdapter(listeLivres) { livre ->
                    val intent = Intent(this, DetailsLivreActivity::class.java)
                    intent.putExtra("livre_titre", livre.titre)
                    intent.putExtra("livre_auteur", livre.auteur)
                    intent.putExtra("livre_synopsis", livre.synopsis)
                    intent.putExtra("livre_islu", livre.isLu)
                    startActivity(intent)
                }
                recyclerView.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }


    }
}
