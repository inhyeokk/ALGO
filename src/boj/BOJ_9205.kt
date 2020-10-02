package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.math.abs

/**
 * {@link} https://www.acmicpc.net/problem/9205
 * @date   2020-10-02
 * @author lolol0705
 * @memory 13968KB / 128MB
 * @time   112ms / 1초
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = br.readLine().toInt()
        val arr = Array(n+2) { intArrayOf(0,0) }
        repeat(n+2) {
            val st = StringTokenizer(br.readLine(), " ")
            arr[it][0] = st.nextToken().toInt()
            arr[it][1] = st.nextToken().toInt()
        }
        val q = LinkedList<IntArray>().apply { add(arr[0]) }
        val visit = BooleanArray(n+2).apply { this[0] = true }
        var happy = false
        while (q.isNotEmpty()) {
            val cur = q.poll()
            arr.forEachIndexed { i, xy ->
                if (!visit[i] && abs(xy[0]-cur[0]) + abs(xy[1]-cur[1]) <= 1000) {
                    if (i == n+1) {
                        happy = true
                        q.clear()
                        return@forEachIndexed
                    }
                    visit[i] = true
                    q.add(xy)
                }
            }
        }
        sb.append(if (happy) "happy" else "sad").append("\n")
    }
    print(sb)
}
