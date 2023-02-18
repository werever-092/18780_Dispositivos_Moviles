package edu.iest.comparison

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import edu.iest.comparison.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter.createFromResource(this, R.array.myNums, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spFirstNum.adapter = adapter
        binding.spSecondNum.adapter = adapter

        binding.bnChange.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Atencion").setMessage("Quieres comparar los dos numeos?")
                .setCancelable(false)
                .setPositiveButton("OK", DialogInterface.OnClickListener {
                        dialogInterface, i ->
                    compNums()
                })
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener{
                        dialogInterface, i ->
                    Toast.makeText(this, "Una lastima :,(", Toast.LENGTH_LONG).show()
                })
                .show()
        }

    }

    private fun compNums () {
        val num1 = binding.spFirstNum.selectedItem.toString().toInt()
        val num2 = binding.spSecondNum.selectedItem.toString().toInt()

        if (num1 == num2) {
            Toast.makeText(this, "Los valores son iguales", Toast.LENGTH_LONG).show()
        } else if (num1 > num2) {
            Toast.makeText(this, "$num1 es mayor", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "$num2 es mayor", Toast.LENGTH_LONG).show()
        }
    }
}