
package com.example.DetailLivreActivity

import android.app.Activity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import classes.Livre
import com.bumptech.glide.Glide
import com.example.appli_livre.R

class DetailsLivreActivity : AppCompatActivity() {

    private lateinit var checkBox: CheckBox
    private lateinit var livre: Livre

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_livre)

        val textViewTitre: TextView = findViewById(R.id.textViewTitre)
        val textViewAuteur: TextView = findViewById(R.id.textViewAuteur)
        val textViewSynopsis: TextView = findViewById(R.id.textViewSynopsis)
        val titre = intent.getStringExtra("livre_titre")
        val auteur = intent.getStringExtra("livre_auteur")
        val synopsis = intent.getStringExtra("livre_synopsis")
        val lu = intent.getBooleanExtra("livre_isLu",false)
        val imageUri = intent.getStringExtra("imageUri")


        textViewTitre.text = "Titre: $titre"
        textViewAuteur.text = "Auteur: $auteur"
        textViewSynopsis.text = "Synopsis: $synopsis"


        checkBox = findViewById(R.id.checkBox)

        checkBox.isChecked = lu

        checkBox.setOnCheckedChangeListener { _, isChecked ->

                livre.isLu = isChecked
                intent.putExtra("livre_isLu", isChecked)
               setResult(Activity.RESULT_OK, intent)
            finish()



        }



    }



}
