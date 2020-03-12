import java.util.PriorityQueue;

/**
 * @{link} https://programmers.co.kr/learn/courses/30/lessons/17686
 * @date   2020-03-12
 * @author rkddlsgur983
 */
public class PRO_L2_파일명정렬 {
	public String[] solution(String[] files) {
		PriorityQueue<File> pq = new PriorityQueue<>();
		for (int i = 0; i < files.length; ++i) {
			String s = files[i];
			int a = 0, b = 0, c = s.length(), len = c;
			for (int j = 0; j < len; ++j) {
				if (b == 0 && Character.isDigit(s.charAt(j))) {
					b = j;
				} else if (b != 0 && !Character.isDigit(s.charAt(j))) {
					c = j;
					break;
				}
			}
			pq.add(new File(s, s.substring(a, b).toLowerCase(), Integer.parseInt(s.substring(b,c)), i));
		}
	    String[] answer = new String[files.length];
	    for (int i = 0; !pq.isEmpty(); ++i) {
	    	answer[i] = pq.poll().origin;
	    }
	    return answer;
	}
	
	class File implements Comparable<File>{
		String origin;
		String head;
		int number, idx;
		
		public File(String origin, String head, int number, int idx) {
			this.origin = origin;
			this.head = head;
			this.number = number;
			this.idx = idx;
		}

		@Override
		public int compareTo(File o) {
			if (head.equals(o.head)) {
				if (number == o.number) {
					if (idx < o.idx) {
						return -1;
					} else {
						return 1;
					}
				} else if (number < o.number){
					return -1;
				} else {
					return 1;
				}
			} else {
				return head.compareTo(o.head);
			}
		}
	}
}
