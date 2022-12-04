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

fun countTriplets(arr: Array<Long>, r: Long): Long {
    var tripletCount: Long = 0
    val pairMap: HashMap<Long, Long> = HashMap()
    val numberOccurrenceMap: HashMap<Long, Long> = HashMap()
    for (i in arr.indices.reversed()) {
        val currentItem = arr[i]
        val nextItem = arr[i] * r
        tripletCount += pairMap.getOrDefault(nextItem, 0)
        pairMap[currentItem] = pairMap.getOrDefault(currentItem, 0L) + (numberOccurrenceMap.getOrDefault(nextItem, 0L))
        numberOccurrenceMap[currentItem] = numberOccurrenceMap.getOrDefault(currentItem, 0) + 1
    }
    return tripletCount
}

fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}
