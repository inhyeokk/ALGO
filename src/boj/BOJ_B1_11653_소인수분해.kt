package boj

// https://www.acmicpc.net/problem/11653
fun main() {
    var n = readln().toInt()
    if (n != 1) {
        var m = 2
        while (true) {
            if (n % m == 0) {
                n /= m
                println(m)
            } else {
                m += 1
                if (n < m) return
            }
        }
    }
}
