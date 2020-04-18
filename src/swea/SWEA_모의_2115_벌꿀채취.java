package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-02-28
 * @author rkddlsgur983
 * @memory 32836KB
 * @time   145ms
 */
public class SWEA_모의_2115_벌꿀채취 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] map = new int[100];
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; ++j) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int k = 0; k < n; ++k) {
					map[j*n+k] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for (int j = 0; j < n*n-2*m+1; ++j) {
				if (j/n != (j+m-1)/n) continue;
				int amax = 0;
				for (int k = 1; k < (1<<m); ++k) {
					int ac = 0;
					int atmax = 0;
					for (int l = 0; l < m; ++l) {
						int honey = map[j+l];
						if ((k&(1<<l))>0 && ac+honey <= c) {
							ac += honey;
							atmax += honey*honey;
						}
					}
					amax = Math.max(atmax, amax);
				}
				for (int k = j+m; k < n*n-m+1; ++k) {
					if (k/n != (k+m-1)/n) continue;
					int bmax = 0;
					for (int l = 1; l < (1<<m); ++l) {
						int bc = 0;
						int btmax = 0;
						for (int p = 0; p < m; ++p) {
							int honey = map[k+p];
							if ((l&(1<<p))>0 && bc+honey <= c) {
								bc += honey;
								btmax += honey*honey;
							}
						}
						bmax = Math.max(btmax, bmax);
					}
					max = Math.max(amax+bmax, max);
				}
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
