package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnclick(view: View) {
        val btnSelecionado = view as Button
        var celID = 0

        when (btnSelecionado.id) {
            R.id.x1 -> celID = 1
            R.id.x2 -> celID = 2
            R.id.x3 -> celID = 3
            R.id.x4 -> celID = 4
            R.id.x5 -> celID = 5
            R.id.x6 -> celID = 6
            R.id.x7 -> celID = 7
            R.id.x8 -> celID = 8
            R.id.x9 -> celID = 9
        }

     //   Toast.makeText(this, "ID:" + celID, Toast.LENGTH_SHORT).show()
        playGame(celID,btnSelecionado)
    }
    class Players{
        var user: String = ""
    }

    //aRRAY PARA GUARDAR AS JOGADAS
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var player = 1 //sempre começar com o jogador 1

    fun playGame(celID: Int, btnSelecionado: Button) {

        if (player == 1) {
            btnSelecionado.text = "X"
            btnSelecionado.setBackgroundColor(Color.GREEN)
            player1.add(celID)
            player = 2
        } else {
            btnSelecionado.text = "Y"
            btnSelecionado.setBackgroundColor(Color.BLUE)
            player2.add(celID)
            player = 1
        }
        btnSelecionado.isEnabled = false
        checkWiner()
    }
    fun checkWiner(){
        var winer = -1
        ////////////////////////////////////////////////
        //linha 1  play1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winer = 1
        }
        //linha 1 play2
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winer = 2
        }
        /////////////////////////////////////////////////
        //linha 2 play 1
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winer = 1
        }
        //linha 2 play2
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winer = 2
        }
        //////////////////////////////////////////////
        //linha 3 play 1
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winer = 1
        }
        //linha 3 play2
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winer = 2
        }

        //////////////////////COLUNAS////////////////////////////
        //coluna 1 play 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winer = 1
        }
        //coluna 1 play2
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winer = 2
        }

        //coluna 2 play 1
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winer = 1
        }
        //coluna 2 play2
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winer = 2
        }

        //coluna 3 play 1
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer = 1
        }
        //coluna 3 play2
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer = 2
        }

        //transverso 1 play 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winer = 1
        }
        //transverso 1 play 2
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winer = 2
        }
        //transverso 2 play2
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winer = 2
        }
        //transverso 2 play1
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winer = 1
        }



        //WINER
        if(winer!=-1){
            if(winer==1){
                Toast.makeText(this,"Player 1 Winer",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Player 2 Winer",Toast.LENGTH_SHORT).show()
            }

        }
    }
}





