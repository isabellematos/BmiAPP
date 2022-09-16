package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.imc20.databinding.ActivityBmiBinding
import br.senai.sp.jandira.imc20.model.User

class BmiActivity : AppCompatActivity() {

    lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBmiBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar!!.hide()

        loadProfile()

        binding.button3.setOnClickListener {
            bmiCalculate()
        }
    }



    private fun loadProfile() {
        //abrir o arquivo shared preferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUsername.text = dados.getString("name", "")
        binding.textViewEmail.text = dados.getString("email", "")
        binding.textViewWeight.text = "Weight: ${dados.getInt("weight", 0)} Kg "
        binding.textViewHeight.text = "Height: ${dados.getFloat("height", 0.0f)}"

    }

    private fun bmiCalculate() {
        val openResult = Intent(this, ResultActivity::class.java)
        val dados = getSharedPreferences("dados", MODE_PRIVATE)
        val user = User()
        val editor = dados.edit()

        openResult.putExtra("weight", binding.textWeight.text.toString().toInt())
        user.weight = binding.textWeight.text.toString().toInt()
        editor.putInt("weight", user.weight)

        if (binding.textHeight.text.isEmpty()){
            val height = dados.getFloat("height", 0.0f)
            openResult.putExtra("height", height.toDouble())
        }else{
            user.height = binding.textHeight.text.toString().toDouble()
            editor.putFloat("height", user.height.toFloat())
            openResult.putExtra("height", binding.textHeight.text.toString().toDouble())

        }

        editor.commit()
        startActivity(openResult)
    }
}