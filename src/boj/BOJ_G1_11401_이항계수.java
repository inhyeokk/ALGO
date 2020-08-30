package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/11401
 * @date   	2020-04-02
 * @author 	lolol0705
 * @memory 	43852KB / 256MB
 * @time   	156ms / 1초
 * @idea	페르마의 소정리 + 빠른 거듭제곱
 * 			https://nexters.me/vg
 */
public class BOJ_G1_11401_이항계수 {
	private static final int MOD = 1000000007;
	private static long[] fac;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		long ans = 1;
		if (n != r && r > 0) {
			fac = new long[n+1];
			fac[1] = 1;
			for (int i = 2; i <= n; ++i) {
				fac[i] = (fac[i-1]*i)%MOD;
			}
			ans = (fac[n]*pow((fac[n-r]*fac[r])%MOD, MOD-2))%MOD;
		}
		System.out.println(ans);
	}
	
	private static long pow(long base, int power) {
		
		long result = 1L;
		while (power > 0) {
			if ((power & 1)==1) {
				result = (result * base) % MOD;
			}
			power >>= 1;
			base = base * base % MOD;
		}
		return result;
	}
}
