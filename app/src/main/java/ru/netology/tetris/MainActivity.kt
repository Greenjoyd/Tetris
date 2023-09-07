package ru.netology.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import ru.netology.tetris.databinding.ActivityMainBinding
import ru.netology.tetris.storage.AppPreferences

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)

        supportActionBar?.hide()

        val btnNewGame = bindingClass.btnNewGame
        val btnResetScore = bindingClass.btnResetScore
        val btnexit = bindingClass.btnExit
        val tvHighScore = bindingClass.tvHighScore

        btnNewGame.setOnClickListener(this::onBtnNewGameClick)
        btnResetScore.setOnClickListener(this::onBtnResetScoreClick)
        btnexit.setOnClickListener(this::onBtnExitClick)

    }

    private fun onBtnNewGameClick(view: View){
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun onBtnResetScoreClick(view: View){
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        Snackbar.make(view,"Score successfully reset",Snackbar.LENGTH_SHORT).show()
        bindingClass.tvHighScore?.text = "High score ${preferences.getHigtScore()}"
    }

    private fun onBtnExitClick(view: View){
        System.exit(0)
    }
}