import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_8821_D3_적고지우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; ++i) {
			char[] str = sc.next().toCharArray();
			List<Character> list = new ArrayList<>();
			for (int j = 0, len = str.length; j < len; ++j) {
				if (!list.contains(str[j])) {
					list.add(str[j]);
				} else {
					list.remove(Character.valueOf(str[j]));
				}
			}
			sb.append("#").append(i).append(" ").append(list.size()).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}
