import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val arrSize = scanner.nextInt()
    val arr = mutableListOf<Int>()
    for (i in 0 until arrSize) {
        arr.add(scanner.nextInt())
    }
    val arrSorted = arr.sorted()
    if (arr == arrSorted) {
        println("YES")
    } else {
        println("NO")
    }
}