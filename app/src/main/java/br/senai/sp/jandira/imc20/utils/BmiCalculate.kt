package br.senai.sp.jandira.imc20.utils

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.senai.sp.jandira.imc20.R
import br.senai.sp.jandira.imc20.ResultActivity
import kotlin.math.pow


fun getBmi(weight: Int, height: Double): Double {
    return weight / height.pow(2)

}

fun getStatusBmi(bmi: Double,context: Context): String {

    if (bmi <= 18.5) {
        return context.getString(R.string.under)
    } else if (bmi > 18.5 && bmi < 25.0) {
        return context.getString(R.string.ideal)
    } else if (bmi >= 25.0 && bmi < 30.0){
        return  context.getString(R.string.more_ideal)
    } else if (bmi >= 30.0 && bmi < 35.0) {
        return context.getString(R.string.overweight1)
    } else if (bmi >= 35.0 && bmi < 40.0) {
        return context.getString(R.string.overweight2)
    } else {
        return context.getString(R.string.overweight3)
    }
}

