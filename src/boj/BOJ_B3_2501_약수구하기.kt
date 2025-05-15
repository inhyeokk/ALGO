package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// https://www.acmicpc.net/problem/2501
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")
    val n = Integer.parseInt(st.nextToken())
    val k = Integer.parseInt(st.nextToken())
    var count = 0
    (1..n).forEach { i ->
        if (n % i == 0) count += 1
        if (count == k) {
            println(i)
            return
        }
    }
    println(0)
}
