package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.imc20.databinding.ActivityResultBinding
import br.senai.sp.jandira.imc20.utils.getBmi
import br.senai.sp.jandira.imc20.utils.getStatusBmi

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        //Recuperar valores que estao na Intent
        val peso = intent.getIntExtra("weight", 0)
        val altura = intent.getDoubleExtra("height", 0.0)

        val bmi = getBmi(peso, altura)
        binding.textViewResult.text = String.format("%.2f", bmi)
        binding.textViewStatus.text = getStatusBmi(bmi, this)

    }
}