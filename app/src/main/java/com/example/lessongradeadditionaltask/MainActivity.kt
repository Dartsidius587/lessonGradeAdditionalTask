package com.example.lessongradeadditionaltask

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inputGradeET: EditText
    private lateinit var buttonRandomDigitBT: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        init()
    }

    private fun init() {
        setContentView(R.layout.activity_main)
        inputGradeET = findViewById(R.id.inputGradeET)
        registerForContextMenu(inputGradeET)

        buttonRandomDigitBT = findViewById(R.id.buttonRandomDigitBT)
        buttonRandomDigitBT.setOnClickListener(this)
    }

    override fun onClick(v: View){
        val randomDigit = (1..50).random().toString()
        inputGradeET.setText(randomDigit).toString()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_change_color -> {
                when(inputGradeET.text.toString().toInt()){
                    in 1..10 -> inputGradeET.setTextColor(Color.RED)
                    in 11..20 -> inputGradeET.setTextColor(Color.rgb(255,87,34))
                    in 21..30 -> inputGradeET.setTextColor(Color.YELLOW)
                    in 31..40 -> inputGradeET.setTextColor(Color.GREEN)
                    in 41..50 -> inputGradeET.setTextColor(Color.BLUE)
                }
            }
            R.id.menu_exit -> {
                finish()
            }
            else -> return super.onContextItemSelected(item)
        }
        return true
    }
}