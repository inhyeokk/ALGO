package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * {@link}  https://www.acmicpc.net/problem/1719
 * @date    2020-10-05
 * @author  lolol0705
 * @memory  36412KB / 128MB
 * @time    732ms / 2초
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val adj = Array<LinkedList<IntArray>>(n) { LinkedList() }
    repeat(m) {
        val st2 = StringTokenizer(br.readLine(), " ")
        val x = st2.nextToken().toInt()-1
        val y = st2.nextToken().toInt()-1
        val r = st2.nextToken().toInt()
        adj[x].add(intArrayOf(y, r))
        adj[y].add(intArrayOf(x, r))
    }
    val results = Array(n) { Array(n) { it } }
    val arr = Array(n) { intArrayOf(it, Integer.MAX_VALUE) }
    for (i in 0 until n) {
        arr.forEach { it[1] = Integer.MAX_VALUE }
        arr[i][1] = 0
        val pq = PriorityQueue<IntArray> { o1, o2 -> o1[1].compareTo(o2[1]) }.apply { addAll(arr) }
        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            adj[cur[0]].forEach {
                if (arr[cur[0]][1] + it[1] < arr[it[0]][1]) {
                    arr[it[0]][1] = arr[cur[0]][1] + it[1]
                    pq.remove(arr[it[0]])
                    pq.add(arr[it[0]])
                    if (i != cur[0]) {
                        results[i][it[0]] = results[i][cur[0]]
                    }
                }
            }
        }
    }
    val sb = StringBuilder()
    results.forEachIndexed { i, result ->
        result.forEachIndexed { j, r ->
            sb.append(if(i == j) "- " else "${r+1} ")
        }
        sb.append("\n")
    }
    print(sb)
}