package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * {@link}  https://www.acmicpc.net/problem/1939
 * @date    2020-10-17
 * @author  lolol0705
 * @comment 백준 JDK로인해 컴파일 에러이지만 자바와 동일
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = LinkedList<IntArray>()
    repeat(n) {
        val st = StringTokenizer(br.readLine(), " ")
        val deadline = st.nextToken().toInt()
        val cup = st.nextToken().toInt()
        list.add(intArrayOf(deadline, cup))
    }
    list.sortWith { o1, o2 -> o2[0].compareTo(o1[0]) }

    var cnt = 0
    val pq = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
    repeat(n) {
        val cur = n-it
        while (list.isNotEmpty() && cur <= list.first[0]) {
            pq.add(list.poll()[1])
        }
        if (pq.isNotEmpty()) {
            cnt += pq.poll()
        }
    }
    print(cnt)
}