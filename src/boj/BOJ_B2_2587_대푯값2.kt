package boj

/**
 * @link    https://www.acmicpc.net/problem/2587
 * @date    2025-05-19
 * @author    rkddlsgur983
 * @memory    KB / 128MB
 * @time    ms / 1초
 * @idea    정렬
 */
fun main() {
    val n = 5
    val num = Array(n) { 0 }
    var sum = 0
    repeat(n) {
        num[it] = readln().toInt()
        sum += num[it]
    }
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            if (num[i] < num[j]) {
                val k = num[i]
                num[i] = num[j]
                num[j] = k
            }
        }
    }
    print("${sum / n}\n${num[2]}")
}
