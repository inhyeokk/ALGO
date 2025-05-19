package boj

/**
 * @link	https://www.acmicpc.net/problem/1018
 * @date   	2025-05-19
 * @author 	rkddlsgur983
 * @memory 	33588KB / 128MB
 * @time   	240ms / 2초
 * @idea	브루트포스
 */
fun main() {
    val nm = readln().split(" ").map { it.toInt() }
    val board = Array(nm[0]) { "" }
    for (i in 0 until nm[0]) {
        board[i] = readln()
    }
    val bw = "BWBWBWBW"
    val wb = "WBWBWBWB"
    val bwBoard = arrayOf(bw, wb, bw, wb, bw, wb, bw, wb)
    val wbBoard = arrayOf(wb, bw, wb, bw, wb, bw, wb, bw)
    var min = 32
    for (i in 0 until board.size - 8 + 1) {
        for (j in 0 until board[i].length - 8 + 1) {
            var bwdiff = 0
            var wbdiff = 0
            repeat(8) { k ->
                val cur = board[i + k].slice(j until j + 8)
                bwdiff += cur.zip(bwBoard[k]).count { (a, b) -> a != b }
                wbdiff += cur.zip(wbBoard[k]).count { (a, b) -> a != b }
            }
            min = if (min < bwdiff) min else bwdiff
            min = if (min < wbdiff) min else wbdiff
        }
    }
    print(min)
}
