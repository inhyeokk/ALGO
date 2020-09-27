import java.util.*

fun solution(operations: Array<String>): IntArray {
    val pq1 = PriorityQueue<Int>()
    val pq2 = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
    operations.forEach { op ->
        val st = StringTokenizer(op, " ")
        val order = st.nextToken()
        val num = st.nextToken().toInt()
        when (order) {
            "I" -> {
                pq1.add(num)
                pq2.add(num)
            }
            "D" -> {
                if (pq1.isNotEmpty()) {
                    if (num == 1) {
                        pq1.remove(pq2.poll())
                    } else {
                        pq2.remove(pq1.poll())
                    }
                }
            }
        }
    }
    return if (pq1.isNotEmpty()) {
        intArrayOf(pq2.peek(), pq1.peek())
    } else {
        intArrayOf(0, 0)
    }
}