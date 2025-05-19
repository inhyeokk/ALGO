package boj

// https://www.acmicpc.net/problem/19532
fun main() {
    val input = readln().split(" ").map { it.toInt() }
    for (x in -999 .. 999) {
        for (y in -999 .. 999) {
            if (input[0] * x + input[1] * y == input[2]
                && input[3] * x + input[4] * y == input[5]) {
                println("$x $y")
                return
            }
        }
    }
}
