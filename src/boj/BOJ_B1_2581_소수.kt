package boj

// https://www.acmicpc.net/problem/2581
fun main() {
    val m = readln().toInt()
    val n = readln().toInt()

    var min = 10000
    var sum = 0
    val prime = MutableList(n + 1) { false }
    for (i in 2..n) {
        if (prime[i]) continue
        if (i >= m) {
            sum += i
            min = if (min > i) i else min
        }
        for (j in i + 1..n) {
            if (j % i == 0) prime[j] = true
        }
    }

    if (min != 10000) {
        println("$sum\n$min")
    } else {
        println(-1)
    }
}
