import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val arrSize = scanner.nextInt()
    val arr = IntArray(arrSize)
    for (i in 0 until arrSize) {
        arr[i] = scanner.nextInt()
    }
    println(arr.max())
}