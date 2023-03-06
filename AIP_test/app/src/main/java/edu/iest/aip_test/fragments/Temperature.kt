package edu.iest.aip_test

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class TemperatureFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_temperature, container, false)

        val database = Firebase.database
        val databaseReference = database.getReference()
        var state = 0

        val pbTemp: ProgressBar = view.findViewById(R.id.pbTemperature)
        val tvTemp: TextView = view.findViewById(R.id.tvTemperature)
        val tbDHT11: ToggleButton = view.findViewById(R.id.tbDHT11)

        databaseReference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val value = dataSnapshot.child("temperature").getValue<Float>()
                state = dataSnapshot.child("state").getValue<Int>()!!

                pbTemp.progress = value?.toInt() ?: 0
                tvTemp.text = "Temperatura: "+value.toString()+" C°"

                if (state == 0) {
                    tbDHT11.isChecked = false
                    state = 1
                } else {
                    tbDHT11.isChecked = true
                    state = 0
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("TAG", "Failed to read value.", error.toException())
            }
        })

        tbDHT11.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                databaseReference.child("state").setValue(state)
            } else {
                databaseReference.child("state").setValue(0)
            }
        }

        return view
    }

}