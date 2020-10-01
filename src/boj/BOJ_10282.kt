package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

/**
 * {@link}  https://www.acmicpc.net/problem/10282
 * @date    2020-10-02
 * @author  lolol0705
 * @memory  171204KB / 256MB
 * @time    1596ms / 2초
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(tc) {
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt() // 컴퓨터 개수
        val d = st.nextToken().toInt() // 의존성 개수
        val c = st.nextToken().toInt() // 해킹당한 컴퓨터 번호
        val adj = Array<LinkedList<IntArray>>(n+1) { LinkedList() }
        val dist = Array(n+1) { intArrayOf(it, Integer.MAX_VALUE) }.apply { this[c][1] = 0 }
        repeat(d) {
            val st2 = StringTokenizer(br.readLine())
            val a = st2.nextToken().toInt()
            val b = st2.nextToken().toInt()
            val s = st2.nextToken().toInt()
            adj[b].add(intArrayOf(a, s))
        }
        var cnt = 0
        var time = 0
        val pq = PriorityQueue<IntArray> { o1, o2 -> o1[1].compareTo(o2[1]) }.apply { addAll(dist) }
        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            if (cur[1] == Integer.MAX_VALUE) break
            time = cur[1]
            adj[cur[0]].forEach {
                if (it[1] + dist[cur[0]][1] < dist[it[0]][1]) {
                    dist[it[0]][1] = it[1] + cur[1]
                    pq.remove(dist[it[0]])
                    pq.add(dist[it[0]])
                }
            }
            ++cnt
        }
        sb.append("$cnt $time\n")
    }
    print(sb)
}