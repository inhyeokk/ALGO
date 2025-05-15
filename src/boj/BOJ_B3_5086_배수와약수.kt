package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// https://www.acmicpc.net/problem/5086
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val st = StringTokenizer(br.readLine(), " ")
        val r = Integer.parseInt(st.nextToken())
        val c = Integer.parseInt(st.nextToken())
        if (r == 0 && c == 0) return
        when {
            c / r > 0 && c % r == 0 -> println("factor")
            r / c > 0 && r % c == 0 -> println("multiple")
            else -> println("neither")
        }
    }
}
