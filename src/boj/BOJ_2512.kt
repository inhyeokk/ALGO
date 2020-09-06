package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

/**
 * {@link}  https://www.acmicpc.net/problem/2512
 * @date    2020-09-04
 * @author  lolol0705
 * @memory  14684KB / 128MB
 * @time    120ms / 1초
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    val st = StringTokenizer(br.readLine(), " ")
    val arr = IntArray(n) {0}
    var min = 0
    var max = 0
    repeat(n) {
        arr[it] = Integer.parseInt(st.nextToken())
        max = max(arr[it], max)
    }
    val m = Integer.parseInt(br.readLine())
    var result = min
    while (min <= max) {
        val mid = (min + max) / 2
        var sum = 0
        arr.forEach { sum += if (it >= mid) mid else it }
        if (sum == m) {
            result = mid
            break
        } else if (sum < m) {
            min = mid + 1
            result = mid
        } else {
            max = mid - 1
        }
    }
    print(result)
}