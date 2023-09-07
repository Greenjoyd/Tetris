package ru.netology.tetris.models
import ru.netology.tetris.helper.HelperFunction.array2dOfBite
class Frame(private val width: Int) {

    val data: ArrayList<ByteArray> = ArrayList()

    fun addRow(byteStr: String): Frame{
        val row = ByteArray(byteStr.length)

        for (index in byteStr.indices){
            row[index]="${byteStr[index]}".toByte()
        }
        data.add(row)
        return this
    }

    fun as2dByteArray(): Array<ByteArray>{
        val bytes = array2dOfBite(data.size,width)
        return data.toArray(bytes)
    }
}