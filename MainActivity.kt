package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand:Double = 0.0
    private var operation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultText)
    }

    fun numberClick (clickedView: View) {
        if (clickedView is TextView) {
            var result = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number
        }
    }
    fun operationClick (clickedView: View) {
        if (clickedView is TextView) {
            var operand = resultTextView.text.toString()
            this.operand = operand.toDouble()
            operation = clickedView.text.toString()

            resultTextView.text = "0"
        }
    }
    fun equalsClick(clickedView: View) {
        val secOperand = resultTextView.text.toString().toDouble()
//        print(operation)
        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
        }
        if (".0" == resultTextView.text.toString().substring(resultTextView.text.toString().length-2, resultTextView.text.toString().length)){
            resultTextView.text = resultTextView.text.toString().substring(0, resultTextView.text.toString().length-2)
        }
        operation = ""
        operand = 0.0
    }

    fun clearClick(clickedView: View){
        resultTextView.text = "0"
    }

    fun delClick(clickedView: View){
        if (resultTextView.text.toString().length > 1){
            resultTextView.text = resultTextView.text.toString().substring(0, resultTextView.text.toString().length-1)
        }else{
            resultTextView.text = "0"
        }
    }

    fun pointClick(clickedView: View){
        if (!resultTextView.text.contains(".")){
            resultTextView.text = resultTextView.text.toString() + "."
        }
    }

}