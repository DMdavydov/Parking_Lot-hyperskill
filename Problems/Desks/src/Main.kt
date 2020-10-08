import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val one = scanner.nextInt()
    val oneResult = if (one % 2 == 0) one else one + 1
    val two = scanner.nextInt()
    val twoResult = if (two % 2 == 0) two else two + 1
    val three = scanner.nextInt()
    val threeResult = if (three % 2 == 0) three else three + 1
    val result = (oneResult + twoResult + threeResult) / 2
    println(result)
}