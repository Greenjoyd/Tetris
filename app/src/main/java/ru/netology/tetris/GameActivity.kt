package ru.netology.tetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.netology.tetris.databinding.ActivityGameBinding
import ru.netology.tetris.storage.AppPreferences

class GameActivity : AppCompatActivity() {
    lateinit var bindingClass :ActivityGameBinding

    var tvHighScore: TextView? = null
    var tvCurrentScore: TextView? = null
    var appPreferences: AppPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityGameBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)

        appPreferences = AppPreferences(this)

        val btnRestart = bindingClass.btnRestart
        tvHighScore = bindingClass.tvHighScore
        tvCurrentScore = bindingClass.tvCurrentScore
        updateHighScore()
        updateCurrentScore()
    }
    private fun updateHighScore(){
        tvHighScore?.text = "${appPreferences?.getHigtScore()}"
    }

    private fun updateCurrentScore(){
        tvCurrentScore?.text = "0"
    }


}