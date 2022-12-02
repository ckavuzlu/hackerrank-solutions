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
 * Complete the 'sherlockAndAnagrams' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */


// first i need whole substrings of string
// i need the find anagrams for each substring
// Hash Map HashMap<Set<Set<Char,Int>>>, Int>


// In the end  each Hashmap value -1 gives me anagram count

fun sherlockAndAnagrams(s: String): Int {

    var totalAnagram = 0
    val substringMap = mutableMapOf<HashMap<Char, Int>, Int>()
    for (i in s.indices) {
        for (j in i + 1..s.length) {
            val substring = mutableMapOf<Char, Int>()
            s.substring(i, j).forEach {
                substring[it] = substring.getOrDefault(it, 0) + 1
            }
            substringMap[substring as HashMap<Char, Int>] = substringMap.getOrDefault(substring, 0) + 1
        }
    }
    substringMap.forEach {
        totalAnagram += calculatePairCount(it.value)
    }
    return totalAnagram
}

fun calculatePairCount(value: Int): Int {
    if(value <= 1 ) return 0
    return value * (value - 1) / 2
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}
