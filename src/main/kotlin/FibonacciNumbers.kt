import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val input = readLine()!!.trim().toInt()
    println(sumOfFibonacciSeries(input))
}

fun sumOfFibonacciSeries(input: Int): Int {
    return when (input) {
        0 -> 0
        1 -> 1
        else -> sumOfFibonacciSeries(input - 1) + sumOfFibonacciSeries(input - 2)
    }
}
