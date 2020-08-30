package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

/**
 * {@link} https://www.acmicpc.net/problem/3145
 * @date   2020-08-30
 * @author rkddlsgur983
 * @result 9% 시간초과
 */
private var n = 0
private var r = 0
private var c = 0
private val town = ArrayList<Town>()
private val name = ArrayList<Name>()
private lateinit var visitTown: BooleanArray
private lateinit var visitName: BooleanArray
private var find = false
private val dir = arrayOf(
        arrayOf(0,1), arrayOf(1,1), arrayOf(1,0), arrayOf(1,-1),
        arrayOf(0,-1), arrayOf(-1,-1), arrayOf(-1,0), arrayOf(-1,1)
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")
    r = Integer.parseInt(st.nextToken())
    c = Integer.parseInt(st.nextToken())

    repeat(r) { i ->
        val row = br.readLine()
        var j = 0
        while (j < c) {
            when (row[j]) {
                'x' -> town.add(Town(i,j))
                in 'A'..'Z' -> {
                    var cnt = 1
                    while (j+cnt < c && row[j+cnt] in 'A'..'Z') {
                        ++cnt
                    }
                    name.add(Name(i, j, j+cnt, row.substring(j, j+cnt)))
                    j += cnt-1
                }
            }
            ++j
        }
    }

    n = town.size
    visitTown = BooleanArray(n)
    visitName = BooleanArray(n)
    find(0, Array(n) {""})
}

private fun find(depth: Int, result: Array<String>) {
    if (depth == n) {
        find = true
        val sb = StringBuilder()
        result.forEach {
            sb.append(it).append("\n")
        }
        print(sb)
        return
    }
    if (find) return

    repeat(n) { i ->
        if (!visitTown[i]) {
            visitTown[i] = true
            dir.forEach {
                val nr = town[i].r + it[0]
                val nc = town[i].c + it[1]
                if (nr in 0 until r && nc in 0 until c) {
                    repeat(n) { j ->
                        if (!visitName[j]) {
                            visitName[j] = true
                            if (nr == name[j].r && nc in name[j].c until name[j].end) {
                                result[depth] = "${town[i].r+1} ${town[i].c+1} ${name[j].name}"
                                find(depth+1, result)
                                if (find) return
                            }
                            visitName[j] = false
                        }
                    }
                }
            }
            visitTown[i] = false
        }
    }
}

private class Town(val r: Int, val c: Int)
private class Name(val r: Int, val c: Int, val end: Int, val name: String)