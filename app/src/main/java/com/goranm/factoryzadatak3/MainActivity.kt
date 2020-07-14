package com.goranm.factoryzadatak3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "MainActivity"

    private val kocka1 = Kocka(false, 1)
    private val kocka2 = Kocka(false,1)
    private val kocka3 = Kocka(false,1)
    private val kocka4 = Kocka(false,1)
    private val kocka5 = Kocka(false,1)
    private val kocka6 = Kocka(false,1)

    private var canRollSecondTime = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        btnRoll.setOnClickListener {
            if (canRollSecondTime){
                secondRoll()
                resetingValues()
            }else {
                startRoll()
                canRollSecondTime=true
            }
        }

    }

    private fun initView(){
        val ivDiceOne = findViewById<ImageView>(R.id.ivDice)
        ivDiceOne.setOnClickListener { onClick(ivDiceOne) }
        val ivDiceTwo = findViewById<ImageView>(R.id.ivDice2)
        ivDiceTwo.setOnClickListener { onClick(ivDiceTwo) }
        val ivDiceThree = findViewById<ImageView>(R.id.ivDice3)
        ivDiceThree.setOnClickListener { onClick(ivDiceThree) }
        val ivDiceFour = findViewById<ImageView>(R.id.ivDice4)
        ivDiceFour.setOnClickListener { onClick(ivDiceFour) }
        val ivDiceFive = findViewById<ImageView>(R.id.ivDice5)
        ivDiceFive.setOnClickListener { onClick(ivDiceFive) }
        val ivDiceSix = findViewById<ImageView>(R.id.ivDice6)
        ivDiceSix.setOnClickListener { onClick(ivDiceSix) }
    }

    private fun startRoll(){
        ivDice.setImageLevel(kocka1.rollRandomNumber())
        ivDice2.setImageLevel(kocka2.rollRandomNumber())
        ivDice3.setImageLevel(kocka3.rollRandomNumber())
        ivDice4.setImageLevel(kocka4.rollRandomNumber())
        ivDice5.setImageLevel(kocka5.rollRandomNumber())
        ivDice6.setImageLevel(kocka6.rollRandomNumber())
    }

    private fun secondRoll(){
        ivDice.setImageLevel(kocka1.secondRollCheck())
        ivDice2.setImageLevel(kocka2.secondRollCheck())
        ivDice3.setImageLevel(kocka3.secondRollCheck())
        ivDice4.setImageLevel(kocka4.secondRollCheck())
        ivDice5.setImageLevel(kocka5.secondRollCheck())
        ivDice6.setImageLevel(kocka6.secondRollCheck())
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ivDice -> {kocka1.isDiceEnabled = true}
            R.id.ivDice2 -> {kocka2.isDiceEnabled = true}
            R.id.ivDice3 -> {kocka3.isDiceEnabled = true}
            R.id.ivDice4 -> {kocka4.isDiceEnabled = true}
            R.id.ivDice5 -> {kocka5.isDiceEnabled = true}
            R.id.ivDice6 -> {kocka6.isDiceEnabled = true}
            else->{
                return
            }
        }
    }

    private fun resetingValues(){
        kocka1.isDiceEnabled = false
        kocka2.isDiceEnabled = false
        kocka3.isDiceEnabled = false
        kocka4.isDiceEnabled = false
        kocka5.isDiceEnabled = false
        kocka6.isDiceEnabled = false
        canRollSecondTime = false
    }

}