package edu.iest.android_wear

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import edu.iest.android_wear.databinding.ActivityWatchBinding

class MainActivity : Activity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityWatchBinding
    private var selectText : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvHi.text = "Hola Amiguito"
        binding.bnChange.text = "Enviar"

        val adapter = ArrayAdapter.createFromResource(this, R.array.myOptions,
            android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spOptions.adapter = adapter
        binding.spOptions.onItemSelectedListener = this



        binding.bnChange.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Atencion").setMessage("Quieres enviar el saludo $selectText")
                .setCancelable(false)
                .setPositiveButton("OK", DialogInterface.OnClickListener {
                    dialogInterface, i ->
                    binding.tvHi.text = selectText
                })
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                    Toast.makeText(this, "Una lastima :,(", Toast.LENGTH_LONG).show()
                })
                .show()
        }
    }

    override fun onItemSelected(primaryView: AdapterView<*>?, viewRow: View?, position: Int, idView: Long) {
        selectText = primaryView?.getItemAtPosition(position).toString()
        Toast.makeText(this, "Elegiste $selectText", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}