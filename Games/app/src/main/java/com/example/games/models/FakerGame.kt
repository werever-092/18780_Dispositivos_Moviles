package com.example.games.models

import com.example.games.R

class FakerGame {

    fun getVideogames() : ArrayList<Game>{
        var games : ArrayList<Game>
        games = arrayListOf<Game>()

        games.add(Game(1, "Midnight Club 3: DUB Edition REMIX", 900F, "Playstation 2", R.drawable.mc3, "Everyone"))
        games.add(Game(2, "Hot Wheels: Beat That!", 500F, "Playstation 2", R.drawable.hotwheelsbeatthat, "Everyone"))
        games.add(Game(3, "Speed Racer: The Videogame", 500F, "Playstation 2", R.drawable.speedracer, "Everyone"))
        games.add(Game(4, "MotorStorm: Artic Edge", 500F, "Playstation 2", R.drawable.motorstorm, "Teen"))
        games.add(Game(5, "Star Wars: Battlefront II", 1000F, "Playstation 2", R.drawable.swbattlefront, "Teen"))
        games.add(Game(6, "Halo 4", 1000F, "Xbox 360", R.drawable.halo4, "Mature"))
        games.add(Game(7, "Mad Max", 900F, "Xbox One", R.drawable.madmax,"Mature"))
        games.add(Game(8, "Need for Speed: Payback", 900F, "Xbox One", R.drawable.payback, "Teen"))
        return games
    }
}