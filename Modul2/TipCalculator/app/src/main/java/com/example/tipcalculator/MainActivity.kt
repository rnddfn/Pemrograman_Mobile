package com.example.tipcalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TipCalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupListeners()
        observeViewModel()
    }

    private fun setupListeners() {
        binding.btnRadio1.setOnClickListener {
            viewModel.setAmazing()
        }

        binding.btnRadio2.setOnClickListener {
            viewModel.setGood()
        }

        binding.btnRadio3.setOnClickListener {
            viewModel.setOkay()
        }

        binding.swRoundUp.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setRoundUp(isChecked)
        }

        binding.btnCalculate.setOnClickListener {
            viewModel.setBiaya(binding.etInputBiaya.text?.toString() ?: "")
            viewModel.calculateTip()
        }
    }

    private fun observeViewModel() {
        viewModel.tipAmount.observe(this, Observer { tip ->
            binding.tvTipAmount.text = String.format("Tip Amount: %.2f", tip)
        })
    }
}