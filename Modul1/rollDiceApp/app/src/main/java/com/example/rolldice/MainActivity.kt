package com.example.rolldice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.rolldice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val diceViewModel: DiceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btRoll.setOnClickListener { diceViewModel.rollDice() }

        diceViewModel.dice1Result.observe(this, Observer { result ->
            val diceImageResource = when(result) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.dice_1
            }
            binding.ivDadu1.setImageResource(diceImageResource)
        })

        diceViewModel.dice2Result.observe(this, Observer { result ->
            val diceImageResource = when(result) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.dice_1
            }
            binding.ivDadu2.setImageResource(diceImageResource)
        })

        diceViewModel.isDouble.observe(this, Observer { isDouble ->
            val message = if (isDouble) {
                "Selamat anda dapat dadu double!"
            } else {
                "Anda belum beruntung!"
            }
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        })
    }
}