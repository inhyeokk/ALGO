package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * {@link} https://www.acmicpc.net/problem/2667
 * @date   2020-08-30
 * @author rkddlsgur983
 * @memory 14048KB / 128MB
 * @time   92ms / 1초
 */
private val dir = arrayOf(arrayOf(0,1), arrayOf(1,0), arrayOf(0,-1), arrayOf(-1,0))
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    val arr = Array(n) { Array(n) { false } }
    for (i in 0 until n) {
        val row = br.readLine()
        for (j in 0 until n) {
            arr[i][j] = row[j] == '1'
        }
    }

    val q: Queue<Int> = LinkedList()
    val result = ArrayList<Int>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j]) {
                arr[i][j] = false
                q.add(i)
                q.add(j)
                var cnt = 1
                while (!q.isEmpty()) {
                    val r = q.poll()
                    val c = q.poll()
                    dir.forEach {
                        val nr = r + it[0]
                        val nc = c + it[1]
                        if (nr in 0 until n && nc in 0 until n && arr[nr][nc]) {
                            arr[nr][nc] = false
                            q.add(nr)
                            q.add(nc)
                            ++cnt
                        }
                    }
                }
                result.add(cnt)
            }
        }
    }

    result.sort()
    val sb = StringBuilder()
    sb.append(result.size).append("\n")
    result.forEach { sb.append(it).append("\n") }
    print(sb)
}