package com.example.games

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.games.adapters.GameAdapter
import com.example.games.models.FakerGame
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GameList : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GameAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_list)
        val games = FakerGame().getVideogames()
        val recycler = findViewById<RecyclerView>(R.id.rvGames)

        val Col_Count = 2
        var LayoutAdmin = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recycler.layoutManager = LayoutAdmin
        recycler.adapter = GameAdapter(games,this)

        val fabPreferencias = findViewById<FloatingActionButton>(R.id.fbPrefs)

        fabPreferencias.setOnClickListener {
            val s = Intent(this, SharedPreference::class.java)
            startActivity(s)
            finish()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.vertical -> {
                // Se cambia a un LinearLayoutManager vertical
                layoutManager = LinearLayoutManager(this)
                recyclerView.layoutManager = layoutManager
            }
            R.id.horizontal -> {
                // Se cambia a un LinearLayoutManager horizontal
                layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                recyclerView.layoutManager = layoutManager
            }
            R.id.grid2 -> {
                // Se cambia a un GridLayoutManager con 2 columnas
                layoutManager = GridLayoutManager(this, 2)
                recyclerView.layoutManager = layoutManager
            }
            R.id.grid3 -> {
                // Se cambia a un GridLayoutManager con 3 columnas
                layoutManager = GridLayoutManager(this, 3)
                recyclerView.layoutManager = layoutManager
            }
        }

        return super.onOptionsItemSelected(item)
    }
}