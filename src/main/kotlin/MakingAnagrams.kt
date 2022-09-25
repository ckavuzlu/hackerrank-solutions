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

/*
 * Complete the 'makeAnagram' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING a
 *  2. STRING b
 */

fun makeAnagram(a: String, b: String): Int {
    val firstStringChars = Array(26) { 0 }
    val secondStringChars = Array(26) { 0 }
    var minChangeCount = 0

    for(i in 0..25){
        firstStringChars[i] = a.count { it.toInt() == i + 'a'.toInt() }
        secondStringChars[i] = b.count { it.toInt() == i + 'a'.toInt() }

    }
    firstStringChars.forEachIndexed { index, value ->
        minChangeCount += Math.abs(value - secondStringChars[index])
    }

    return minChangeCount
}

fun main(args: Array<String>) {
    val a = readLine()!!

    val b = readLine()!!

    val res = makeAnagram(a, b)

    println(res)
}
