import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'checkMagazine' function below.
 *
 * The function accepts following parameters:
 *  1. STRING_ARRAY magazine
 *  2. STRING_ARRAY note
 */

fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    val requireCharMap = HashMap<Char, Int>()

    magazine.forEach { magazineWord ->
        magazineWord.forEach {
            requireCharMap[it] = requireCharMap.getOrDefault(it, 0) + 1
        }
    }

    note.forEach { noteWord ->
        noteWord.forEach {
            if(requireCharMap.contains(it) && requireCharMap[it] != 0){
                requireCharMap[it] = requireCharMap[it]!! -1
            }else {
                println("No")
                return@checkMagazine
            }
        }
    }

    println("Yes")
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val m = first_multiple_input[0].toInt()

    val n = first_multiple_input[1].toInt()

    val magazine = readLine()!!.trimEnd().split(" ").toTypedArray()

    val note = readLine()!!.trimEnd().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}
