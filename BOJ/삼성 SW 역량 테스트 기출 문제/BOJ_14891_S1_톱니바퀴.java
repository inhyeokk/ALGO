import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_14891_톱니바퀴 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char[][] chain = new char[4][8];
		for (int i = 0; i < 4; ++i) {
			chain[i] = bf.readLine().toCharArray();
		}
		int n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int[] di = new int[4];
			int numb = num-1;
			di[numb] = d;
			while (numb+1 < 4 && chain[numb][2] != chain[numb+1][6]) {
				di[numb+1] = di[numb]*-1;
				numb++;
			}
			numb = num-1;
			while (numb-1 >= 0 && chain[numb][6] != chain[numb-1][2]) {
				di[numb-1] = di[numb]*-1;
				numb--;
			}
			for (int j = 0; j < 4; ++j) {
				if (di[j] == -1) {
					char tmp = chain[j][0];
					for (int k = 0; k < 7; ++k) {
						chain[j][k] = chain[j][k+1];
					}
					chain[j][7] = tmp;
				} else if (di[j] == 1) {
					char tmp = chain[j][7];
					for (int k = 6; k >= 0; --k) {
						chain[j][k+1] = chain[j][k];
					}
					chain[j][0] = tmp;
				}
			}
		}
		int score = 0;
		for (int j = 0; j < 4; ++j) {
			if (chain[j][0] == '1') {
				score += Math.pow(2, j);
			}
		}
		System.out.print(score);
		bf.close();
	}
}
