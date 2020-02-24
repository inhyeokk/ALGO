import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17413_s3_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] s = bf.readLine().toCharArray();
		boolean open = false;
		for (int i = 0, len = s.length; i < len;) {
			if (!open) {
				if (s[i] == '<') {
					open = true;
				} else if (s[i] != ' ') {
					int j = i;
					do {
						++j;
					} while (j < len && s[j]!='<' && s[j]!=' ');
					int end = j--;
					for (; i < j; ++i, --j) {
						char tmp = s[i];
						s[i] = s[j];
						s[j] = tmp;
					}
					i = end;
					continue;
				}
			} else if (s[i] == '>') {
				open = false;
			}
			++i;
		}
		System.out.print(s);
		bf.close();
	}
}
