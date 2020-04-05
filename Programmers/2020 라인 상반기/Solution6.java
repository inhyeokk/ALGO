import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution6 {
	private Node root = new Node("/", new LinkedList<>());
	private List<String> list = new LinkedList<>();
	public String[] solution(String[] directory, String[] command) {
		for (String dir: directory) {
			makedir(dir);
		}
		
		StringTokenizer st;
		for (String c: command) {
			st = new StringTokenizer(c, " ");
			String o = st.nextToken();
			String dir = st.nextToken();
			switch (o) {
				case "mkdir":
					makedir(dir);
					break;
				case "cp":
					Node cur = find(dir);
					Node target = find(st.nextToken());
					target.childs.add(cur);
					break;
				case "rm":
					remove(dir);
					break;
			}
		}
		getAllDir(root, "");
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		String[] answer = new String[list.size()];
    	int i = 0;
    	for (String s: list) {
    		answer[i++] = s;
    	}
        return answer;
    }
	
	private void makedir(String dir) {
		StringTokenizer st = new StringTokenizer(dir, "/");
		Node cur = root;
		while (st.hasMoreTokens()) {
			boolean exist = false;
			String s = st.nextToken();
			for (Node n: cur.childs) {
				if (n.dir.equals(s)) {
					exist = true;
					cur = n;
					break;
				}
			}
			if (!exist) {
				Node n = new Node("/"+s, new LinkedList<>());
				cur.childs.add(n);
				cur = n;
			}
		}
	}
	
	private Node find(String dir) {
		StringTokenizer st = new StringTokenizer(dir, "/");
		Node cur = root;
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			for (Node n: cur.childs) {
				if (n.dir.equals(s)) {
					cur = n;
					break;
				}
			}
		}
		return cur;
	}
	
	private void remove(String dir) {
		StringTokenizer st = new StringTokenizer(dir, "/");
		Node cur = root;
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			for (Node n: cur.childs) {
				if (n.dir.equals(s)) {
					if (!st.hasMoreTokens()) {
						cur.childs.remove(n);
						return;
					}
					cur = n;
					break;
				}
			}
		}
	}
	
	private void getAllDir(Node cur, String dir) {
		String dirs = dir+cur.dir;
		list.add(dirs);
		for (Node n: cur.childs) {
			getAllDir(n, dirs);
		}
	}
	
	class Node {
		String dir;
		List<Node> childs;
		
		public Node(String dir, List<Node> childs) {
			this.dir = dir;
			this.childs = childs;
		}
	}
}
