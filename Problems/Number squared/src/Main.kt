import java.util.*

// write your code here
fun square(a: Int): Int = a * a
/* Do not change code below */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()
    println(square(number))
}