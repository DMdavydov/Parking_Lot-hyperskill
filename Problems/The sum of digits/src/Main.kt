import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val digit = scanner.nextInt()
    val one = digit / 100
    val two = (digit / 10) % 10
    val three = digit % 10

    println(one + three + two)
}