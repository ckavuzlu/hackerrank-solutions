import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val numberMap = HashMap<Int, Int>()
    val ansList = mutableListOf<Int>()
    var maxFr = 0
    for ((operation, input) in queries) {
        var value = numberMap.getOrDefault(input, 0)
        when (operation) {
            1 -> {
                maxFr = Math.max(maxFr, value)
                numberMap[input] = ++value
            }

            2 -> {
                if (value > 0) {
                    numberMap[input] = --value
                }
            }

            3 -> {
                if (numberMap.containsValue(input)) {
                    ansList.add(1)
                } else {
                    ansList.add(0)
                }
            }
        }
    }

    return ansList.toTypedArray()
}


fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}
