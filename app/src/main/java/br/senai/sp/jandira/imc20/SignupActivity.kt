package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.senai.sp.jandira.imc20.model.User

class SignupActivity : AppCompatActivity() {

    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editWeight: EditText
    lateinit var editHeight: EditText
    lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // definir conteudo de vizualizacao
        setContentView(R.layout.activity_signup)

        supportActionBar!!.hide()

        //instanciar os componentes(views)
        editName = findViewById(R.id.editTextName)
        editEmail = findViewById(R.id.editTextEmailAddress)
        editPassword = findViewById(R.id.editTextPassword)
        editWeight = findViewById(R.id.editTextWeight)
        editHeight = findViewById(R.id.editTextHeight)
        buttonSave = findViewById(R.id.button2)


        buttonSave.setOnClickListener {
            saveUser()
        }
    }

    private fun saveUser() {

        val user = User()
        user.id = 1
        user.name = editName.text.toString()
        user.email = editEmail.text.toString()
        user.password = editPassword.text.toString()
        user.weight = editWeight.text.toString().toInt()
        user.height = editHeight.text.toString().toDouble()

        // gravar o usuario no SharedPreferences
        // Step 1 - Obter a instancia do SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        // Step 2 -Criar um editor para o arquivo
        val editor = dados.edit()

        // Step3 - Inserir os dados no arquivo SharedPreferences
        editor.putInt("id", user.id)
        editor.putString("name", user.name)
        editor.putString("email", user.email)
        editor.putString("password", user.password)
        editor.putInt("weight", user.weight)
        editor.putFloat("height", user.height.toFloat())

        if (editor.commit()){
            Toast.makeText(this, "Usuário gravado com sucesso", Toast.LENGTH_SHORT).show()
            finish() //fecha a activity
        }else{
            Toast.makeText(this, "Ocorreu um erro na gravação", Toast.LENGTH_SHORT).show()
        }

    }
}