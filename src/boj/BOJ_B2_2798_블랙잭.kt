package boj

// https://www.acmicpc.net/problem/2798
fun main() {
    val nm = readln().split(" ").map { it.toInt() }
    val cards = readln().split(" ").map { it.toInt() }
    var max = 0
    for (i in 0 until nm[0] - 2) {
        if (cards[i] >= nm[1]) continue
        for (j in i + 1 until nm[0] - 1) {
            if (cards[i] + cards[j] >= nm[1]) continue
            for (k in j + 1 until nm[0]) {
                val sum = cards[i] + cards[j] + cards[k]
                if (sum == nm[1]) {
                    println(sum)
                    return
                } else if (sum < nm[1] && sum > max) {
                    max = sum
                }
            }
        }
    }
    println(max)
}
