import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val days = scanner.nextInt()
    val costPerDay = scanner.nextInt()
    val flight = scanner.nextInt()
    val hotelPerDay = scanner.nextInt()

    println(days * costPerDay + flight * 2 + hotelPerDay * (days - 1))
}