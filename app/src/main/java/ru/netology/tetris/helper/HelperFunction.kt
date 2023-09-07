package ru.netology.tetris.helper

object HelperFunction {
    fun array2dOfBite(sizeOuter: Int, sizeInner: Int):Array<ByteArray>
        = Array(sizeOuter) { ByteArray(sizeInner)}


}