package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// https://www.acmicpc.net/problem/1978
fun main() {
    val num = MutableList(1001) { false }
    for (i in 2..1000) {
        if (num[i]) continue
        for (j in i + 1..1000) {
            if (j % i == 0) num[j] = true
        }
    }

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine(), " ")
    var sum = 0
    for (i in 0 until n) {
        val m = st.nextToken().toInt()
        if (m != 1 && !num[m]) sum += 1
    }
    println(sum)
}
