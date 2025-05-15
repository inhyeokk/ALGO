package boj

import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.acmicpc.net/problem/9506
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val n = br.readLine().toInt()
        if (n == -1) return
        val list = arrayListOf<Int>()
        var sum = 0
        (1 until n).forEach { i ->
            if (n % i == 0) {
                sum += i
                list.add(i)
            }
        }
        if (sum == n) {
            println("$n = ${list.joinToString(" + ")}")
        } else {
            println("$n is NOT perfect.")
        }
    }
}
