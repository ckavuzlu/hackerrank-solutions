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

fun substrCount(n: Int, s: String): Long {
    var specialSubStrCount: Long = n.toLong()
    for (i in s.indices) {
        for (j in i + 1 until n) {
            if (s[i] != s[j]) {
                if (2 * j - i < n && s.substring(i, j).equals(s.substring(j + 1, 2 * j - i + 1))) {
                    specialSubStrCount++
                }
                break
            } else {
                specialSubStrCount++
            }
        }
    }

    return specialSubStrCount
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = substrCount(n, s)

    println(result)
}
