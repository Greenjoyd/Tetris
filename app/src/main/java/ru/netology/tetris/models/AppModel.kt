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




}