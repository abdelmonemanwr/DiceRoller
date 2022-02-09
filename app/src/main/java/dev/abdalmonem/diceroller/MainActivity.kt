package dev.abdalmonem.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton : Button
    private lateinit var diceImg : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImg = findViewById(R.id.diceImage)
        rollButton = findViewById(R.id.rollButton)

        // Anonymous Class & Anonymous Object
//      rollButton.setOnClickListener(object : View.OnClickListener{
//          override fun onClick(p0: View?) {
//              rollDice()
//          }
//      })

        // Lamda Expression --> more easier than anonymous class
        rollButton.setOnClickListener{
            rollDice()
        }


    }

    private fun rollDice() {
        val randomInt = Random.nextInt(until = 6) + 1  // generate random number between 1 and 6
        //diceNumber.text = randomInt.toString() // diceNumber.text = diceNumber.setText

        val drawableImg = when(randomInt){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        diceImg.setImageResource(drawableImg)
        Toast.makeText(this, "Dice Rolled Successfully!", Toast.LENGTH_SHORT).show()
    }
}