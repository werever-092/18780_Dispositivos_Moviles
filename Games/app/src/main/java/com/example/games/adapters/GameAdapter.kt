package com.example.games.adapters

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.games.R
import com.example.games.models.Game

class GameAdapter (game: ArrayList<Game>, contxt: Context):
    RecyclerView.Adapter<GameAdapter.ContenedorDeVista>() {

    var inner_games: ArrayList<Game> = game
    var inner_contxt: Context = contxt

    inner class ContenedorDeVista(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        //Aqui haremos el inflate del layout
        val tvName : TextView
        val tvPrice : TextView
        val tvConsole : TextView
        val tvClass : TextView
        val ivPhoto : ImageView
        val bnBuy : Button
        init { // Define click listener for the ViewHolder's View.
            tvName = view.findViewById(R.id.tvTitle)
            tvPrice = view.findViewById(R.id.tvPrice)
            tvConsole = view.findViewById(R.id.tvDisp)
            tvClass = view.findViewById(R.id.tvClass)
            ivPhoto = view.findViewById(R.id.ivMC3)
            bnBuy = view.findViewById(R.id.bnBuy)

            bnBuy.setOnClickListener(this)

        }

        override fun onClick(p0: View?) {
            if (adapterPosition >= 0){

                val sharedPref = inner_contxt.getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)

                val age = sharedPref.getInt("edad", 0)

                val Games: Game = inner_games.get(adapterPosition)
                if ((Games.rate == "Mature" && age <= 16 )|| (Games.rate == "Teen" && age <=11)){
                    Toast.makeText(inner_contxt, "No puedes comprar el juego ${Games.name}.", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(inner_contxt, "Gracias por comprar el juego ${Games.name}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_second, parent,false)
        return ContenedorDeVista(view)
    }

    override fun getItemCount(): Int {
        return inner_games.size
    }

    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val game: Game = inner_games.get(position)
        holder.tvName.text = game.name
        holder.tvConsole.text = game.console
        holder.tvClass.text = game.rate
        holder.tvPrice.text = game.price.toString()
        holder.ivPhoto.setImageResource(game.image)

    }
}