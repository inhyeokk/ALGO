package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * {@link}  https://www.acmicpc.net/problem/1939
 * @date    2020-10-14
 * @author  lolol0705
 * @memory  70300KB / 128MB
 * @time    720ms / 1초
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val list = Array<LinkedList<IntArray>>(n+1) { LinkedList() }
    var min = 1_000_000_000
    var max = 1
    repeat(m) { // 1
        val st2 = StringTokenizer(br.readLine(), " ")
        val a = st2.nextToken().toInt()
        val b = st2.nextToken().toInt()
        val c = st2.nextToken().toInt()
        list[a].add(intArrayOf(b,c))
        list[b].add(intArrayOf(a,c))
        min = min(c, min)
        max = max(c, max)
    }
    val st3 = StringTokenizer(br.readLine(), " ")
    val s = st3.nextToken().toInt()
    val e = st3.nextToken().toInt()

    var result = 0
    while (min <= max) { // 2
        val mid = (min + max) / 2
        if (bfs(n, list, s, e, mid)) { // 3
            result = mid
            min = mid + 1
        } else {
            max = mid - 1
        }
    }
    print(result)
}

private fun bfs(n: Int, list: Array<LinkedList<IntArray>>, s: Int, e: Int, weight: Int): Boolean {
    val visit = Array(n+1){ false }.apply { this[s] = true }
    val q = LinkedList<Int>().apply { add(s) }
    while (q.isNotEmpty()) {
        val c = q.poll()
        list[c].forEach {
            if (it[1] >= weight) {
                if (it[0] == e) {
                    return true
                } else if (!visit[it[0]]) {
                    visit[it[0]] = true
                    q.add(it[0])
                }
            }
        }
    }
    return false
}