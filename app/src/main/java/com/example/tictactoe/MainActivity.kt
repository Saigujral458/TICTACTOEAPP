package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), View.OnClickListener {
    var Player=true
    var Turn_count=0
    var boardstat=Array(3){IntArray(3)}
lateinit var board: Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board= arrayOf(
            arrayOf(button,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )
        for(i in board) {
            for (button in i) {
                button.setOnClickListener(this)
            }
        }
        initializeBoardStatus()
        rst.setOnClickListener(){
            Player=true
            Turn_count=0
            initializeBoardStatus()
            updatedisplay("NEW GAME")
        }
    }

    private fun initializeBoardStatus() {
        for (i in 0..2) {
            for (j in 0..2) {
                boardstat[i][j] = -1
            }
        }
        for(i in board){
            for(button in i){
                button.isEnabled= true
                button.text=""
            }
        }
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.button -> {
                update_stat(r=0, c=0)
            }
            R.id.button2 -> {
                update_stat(r=0, c=1)

            }
            R.id.button3 -> {
                update_stat(r=0, c=2)

            }
            R.id.button4 -> {
                update_stat(r=1, c=0)

            }
            R.id.button5 -> {
                update_stat(r=1, c=1)

            }
            R.id.button6 -> {
                update_stat(r=1, c=2)

            }
            R.id.button7 -> {
                update_stat(r=2, c=0)

            }
            R.id.button8 -> {
                update_stat(r=2, c=1)

            }
            R.id.button9 -> {
                update_stat(r=2, c=2)

            }
        }
        Turn_count++
        Player=!Player
        if(Player){
            updatedisplay("PLAYER X TURN")
        }
        else{
            updatedisplay("PLAYER O TURN")
        }
        if(Turn_count==9){
            updatedisplay("GAME DRAW")
        }

        checkWinner()
            

            }

    private fun checkWinner() {
        //horizontal rows
        for(i in 0..2){
            if(boardstat[i][0]==boardstat[i][1]&&boardstat[i][0]==boardstat[i][2]){
                if(boardstat[i][0]==1){
                    updatedisplay("PLAYER X IS WINNER")
                    break
                }
                else if (boardstat[i][0]==0){
                    updatedisplay("PLAYER O IS WINNER")
                    break

                }
            }
        }
        //VERTICAL COLS
        for(i in 0..2){
            if(boardstat[0][i]==boardstat[1][i]&&boardstat[0][i]==boardstat[2][i]){
                if(boardstat[0][i]==1){
                    updatedisplay("PLAYER X IS WINNER")
                    break
                }
                else if(boardstat[0][i]==0){
                    updatedisplay("PLAYER O IS WINNER")
                    break
                }
            }
        }
       // first diagonal
        if(boardstat[0][0]==boardstat[1][1]&&boardstat[0][0]==boardstat[2][2])
        {
            if(boardstat[0][0]==1){
                updatedisplay("PLAYER X IS WINNER")

            }
            else if(boardstat[0][0]==0){
                updatedisplay("PLAYER O IS WINNER")

            }

        }
        // first diagonal
        if(boardstat[0][2]==boardstat[1][1]&&boardstat[0][2]==boardstat[2][0])
        {
            if(boardstat[0][2]==1){
                updatedisplay("PLAYER X IS WINNER")

            }
            else if(boardstat[0][2]==0){
                updatedisplay("PLAYER O IS WINNER")

            }

        }
    }

    private fun updatedisplay(text: String) {
        tv.text=text
        if(text.contains("WINNER")){
            disableButton()
        }

    }
    private fun disableButton(){
        for(i in board){
            for(button in i){
                button.isEnabled=false
            }

        }
    }

    private fun update_stat(r: Int, c: Int) {
        val text=if (Player) "X" else "O"
        val value=if (Player) 1 else  0

    board[r][c].apply {

        isEnabled=false
        setText(text)
    }
        boardstat[r][c]=value
    }
}

private fun Button.setOnClickListener() {

}
