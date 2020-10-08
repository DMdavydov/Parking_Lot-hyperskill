package parking

import java.util.*
import kotlin.collections.ArrayList

data class Spot(val number: Int, var regNumber: String?, var color: String?, var free: Boolean = true) {
    override fun toString(): String {
        return "$number $regNumber $color"
    }
}

var park = ArrayList<Spot>()

fun main() {
    val scanner = Scanner(System.`in`)

    loop@ while (true) {
        val command = scanner.nextLine()
        when (command.substringBefore(" ")) {
            "create" -> create(command)
            "reg_by_color" -> search(command.substringAfter(" "), command.substringBefore(" "))
            "spot_by_color" -> search(command.substringAfter(" "), command.substringBefore(" "))
            "spot_by_reg" -> search(command.substringAfter(" "), command.substringBefore(" "))
            "status" -> status()
            "park" -> park(command)
            "leave" -> leave(command)
            "exit" -> break@loop
        }
    }
}

private fun search(command: String, searchFactor: String) {
    if (checkCreate()) return
    val list: ArrayList<Spot> = ArrayList()
    when (searchFactor) {
        "reg_by_color" -> {
            if (getByColor(list, command)) return
            println(list.map { it.regNumber }
                    .joinToString())
        }
        "spot_by_color" -> {
            if (getByColor(list, command)) return
            println(list.map { it.number }
                    .joinToString())
        }
        else -> getByRegNum(list, command)
    }
}

private fun getByRegNum(list: ArrayList<Spot>, command: String) {
    park.filterTo(list) { it.regNumber.equals(command, true) }
    if (list.isEmpty()) {
        println("No cars with registration number $command were found.")
        return
    }
    println(list.map { it.number }
            .joinToString())
}

private fun getByColor(list: ArrayList<Spot>, command: String): Boolean {
    park.filterTo(list) { it.color.equals(command, true) }
    if (list.isEmpty()) {
        println("No cars with color $command were found.")
        return true
    }
    return false
}

private fun create(command: String) {
    if (park.isEmpty()) {
        createSpots(command)
        return
    }
    park.clear()
    createSpots(command)
}

private fun createSpots(command: String) {
    val num = command.substringAfter(" ").toInt()
    for (i in 1..num) {
        park.add(Spot(i, null, null))
    }
    println("Created a parking lot with $num spots.")
}

private fun leave(command: String) {
    if (checkCreate()) return
    val leave = command.substringAfter(" ")
    park.filter { it.number == leave.toInt() }
            .map {
                it.regNumber = null
                it.color = null
                it.free = true
            }
    println("Spot $leave is free.")
}

private fun park(command: String) {
    if (checkCreate()) return
    val free = park.firstOrNull() { it.free }

    if (free != null) {
        park.filter { it.number == free.number }
                .map {
                    it.regNumber = command.substringAfter(" ").substringBeforeLast(" ")
                    it.color = command.substringAfterLast(" ")
                    it.free = false
                }
        println("${command.substringAfterLast(" ")} car parked in spot ${free.number}.")
        return
    }
    println("Sorry, the parking lot is full.")
}

private fun status() {
    if (checkCreate()) return
    if (park.all { it.free }) {
        println("Parking lot is empty.")
        return
    }
    park.filter { !it.free }
            .forEach { println(it) }
}

private fun checkCreate(): Boolean {
    if (park.isEmpty()) {
        println("Sorry, a parking lot has not been created.")
        return true
    }
    return false
}


