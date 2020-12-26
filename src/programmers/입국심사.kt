package programmers

import java.lang.Long.max

fun solution(n: Int, times: IntArray): Long {
    var min = 0L
    var max = 0L
    times.forEach { t -> max = max(t.toLong(), max) }
    max *= n
    var answer = 0L
    while (min <= max) {
        val mid = (min + max) / 2
        var cnt = 0L
        times.forEach { t ->
            cnt += mid / t
            if (cnt >= n) return@forEach
        }
        if (cnt >= n) {
            answer = mid
            max = mid - 1
        } else {
            min = mid + 1
        }
    }
    return answer
}