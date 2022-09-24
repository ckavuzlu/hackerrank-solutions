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
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

fun minimumBribes(q: Array<Int>): Unit {
    var bribeCount = 0

    for (i in q.size - 1 downTo 0) {
        if (q[i] != i + 1) {
            if (i - 1 >= 0 && q[i - 1] == i + 1) {
                q[i - 1] = q[i]
                q[i] = i + 1
                bribeCount++
            } else if (i - 2 >= 0 && q[i - 2] == i + 1) {
                q[i - 2] = q[i - 1]
                q[i - 1] = q[i]
                q[i] = i + 1
                bribeCount += 2
            } else {
                println("Too chaotic")
                return
            }
        }
    }
    println(bribeCount)

}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        minimumBribes(q)
    }
}
