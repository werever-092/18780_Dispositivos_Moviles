package edu.iest.sqlite.interfaces

import edu.iest.sqlite.models.Juego

public interface juegosInterface {
    fun juegoEliminado()
    fun editarJuego(juego: Juego)

}