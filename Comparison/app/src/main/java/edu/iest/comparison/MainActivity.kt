package edu.iest.comparison

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import edu.iest.comparison.databinding.ActivityWatchBinding

class MainActivity : Activity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityWatchBinding
    private var selectText : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvComparison.text = "Hola Amiguito"
        binding.bnComparison.text = "Enviar"

        val adapter = ArrayAdapter.createFromResource(this, R.array.myOpNums,
            android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spFirstNum.adapter = adapter
        binding.spSecondNum.onItemSelectedListener = this



        binding.bnComparison.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Atencion").setMessage("Quieres enviar el saludo $selectText")
                .setCancelable(false)
                .setPositiveButton("OK", DialogInterface.OnClickListener {
                        dialogInterface, i ->
                    binding.tvComparison.text = selectText
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