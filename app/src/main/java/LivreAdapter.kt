import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import classes.Livre
import com.example.appli_livre.R
import com.bumptech.glide.Glide

class LivreAdapter(private val listeLivres: List<Livre>, private val onLivreClickListener: (Livre) -> Unit) : RecyclerView.Adapter<LivreAdapter.LivreViewHolder>() {

    inner class LivreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewLivreTitre: TextView = itemView.findViewById(R.id.textViewLivreTitre)
        val textViewLivreAuteur: TextView = itemView.findViewById(R.id.textViewAuteur)
        val imageViewLivre: ImageView = itemView.findViewById(R.id.imageViewLivre)


        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val livre = listeLivres[position]
                    onLivreClickListener(livre)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivreViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.element_livre, parent, false)
        return LivreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LivreViewHolder, position: Int) {
        val livreCourant = listeLivres[position]
        holder.textViewLivreTitre.text = livreCourant.titre
        holder.textViewLivreAuteur.text = livreCourant.auteur
        Glide.with(holder.itemView.context)
            .load(Uri.parse(livreCourant.imageUri))
            .into(holder.imageViewLivre)

    }

    override fun getItemCount() = listeLivres.size
}
