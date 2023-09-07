package ru.netology.tetris.models

import android.graphics.Point
import ru.netology.tetris.constatnts.FieldConstants
import ru.netology.tetris.helper.HelperFunction.array2dOfBite
import ru.netology.tetris.storage.AppPreferences


class AppModel {
    var score: Int = 0
    private var preferences: AppPreferences? = null

    var currentBlock: Block? = null
    var currentState : String? = Statuses.AWAITING_START.name

    private var field: Array<ByteArray> = array2dOfBite(
        FieldConstants.FieldConstatns.ROW_COUNT.value,
        FieldConstants.FieldConstatns.COLUMN_COUNT.value
    )
    enum class Statuses{
        AWAITING_START, ACTIVE, INACTIVE, OVER
    }
    enum class Motions {
        LEFT, RIGHT, DOWN, ROTATE
    }
    fun setPreferences(preferences: AppPreferences?){
        this.preferences = preferences
    }

    fun getCellStatus(row: Int, column: Int): Byte?{
        return field[row] [column]
    }

    private fun setCellStatus(row:Int,column: Int,status: Byte?){
        if (status!= null){
            field[row][column] = status
        }
    }

    fun isgameOver(): Boolean{
        return currentState == Statuses.OVER.name
    }

    fun isGameActive(): Boolean{
        return  currentState == Statuses.ACTIVE.name
    }

    fun isGameAwaitingStart():Boolean{
        return currentState == Statuses.AWAITING_START.name
    }

    private fun bootScore(){
        score += 10
        if (score> preferences?.getHigtScore() as Int)
            preferences?.saveHighScore(score)
    }
    private fun generateNextBlock(){
        currentBlock = Block.createBlock()
    }




}