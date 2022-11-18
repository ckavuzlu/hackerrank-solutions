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
 * Complete the 'commonChild' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING s1
 *  2. STRING s2
 */


fun commonChild(s1: String, s2: String): Int {
    val table = Array(s1.length + 1) { IntArray(s2.length + 1) }
    for (i in 0..s1.length) {
        for (j in 0..s2.length) {
            if (i == 0 || j == 0) {
                table[i][j] = 0
            } else if (s1[i - 1] == s2[j - 1]) {
                table[i][j] = table[i - 1][j - 1] + 1
            } else {
                table[i][j] = Math.max(table[i - 1][j], table[i][j - 1])
            }

        }
    }
    return table[s1.length][s2.length]
}

fun main(args: Array<String>) {
    val s1 = readLine()!!

    val s2 = readLine()!!

    val result = commonChild(s1, s2)

    println(result)
}
