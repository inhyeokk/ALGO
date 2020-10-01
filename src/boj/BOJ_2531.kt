package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

/**
 * {@link}  https://www.acmicpc.net/problem/2531
 * @date    2020-09-06
 * @author  lolol0705
 * @memory  16800KB / 256MB
 * @time    156ms / 1초
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val d = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val arr = IntArray(n) {0}
    repeat(n) {
        arr[it] = br.readLine().toInt()
    }
    val cnt = IntArray(d+1) {0}
    var eat = 0
    repeat(k) {
        ++cnt[arr[it]]
        if (cnt[arr[it]] == 1) ++eat
    }
    var max = eat
    for (s in 0 until n-1) {
        val e = (s + k) % n
        --cnt[arr[s]]
        if (cnt[arr[s]] == 0) --eat
        ++cnt[arr[e]]
        if (cnt[arr[e]] == 1) ++eat
        max = max(eat, max)
        if (cnt[c] == 0) {
            max = max(eat+1, max)
        }
        if (max == d) break
    }
    print(max)
}