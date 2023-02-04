package edu.iest.linear_layout

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Mensajes(var msg: String) {
    fun showToast(msg: String, context : Context) {
        Toast.makeText(context, msg,  Toast.LENGTH_LONG).show()
    }

    fun showSnackbar(p0 : View) {
        Snackbar.make(p0, msg,  Toast.LENGTH_LONG).show()
    }
}