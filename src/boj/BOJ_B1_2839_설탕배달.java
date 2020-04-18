package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @{link}	https://www.acmicpc.net/problem/2839
 * @date   	2020-03-27
 * @author 	rkddlsgur983
 * @memory 	12920KB / 128MB
 * @time   	76ms / 1초
 * @idea	탐욕법
 */
public class BOJ_B1_2839_설탕배달 {
	public static void main(String[] args) throws IOException {
		// 입력을 위한 br 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// m kg의 소금을 입력받음
		int m = Integer.parseInt(br.readLine());
		// 초기값 -1
		int ans = -1;
		/* 최소의 봉지를 사용하기 위해서 5kg봉지를 최대한 사용해야한다.
		 * 그래서 가능한 5kg봉지의 최대 개수인 m/5 부터 
		 * 5kg봉지를 사용하지 않는 0까지 반복한다.
		 * 이때 5*i만큼 소금을 5kg봉지에 담고 남은 
		 * tmp가 3kg봉지에 전부 넣을 수 있다면 m만큼의 소금을 배달할 수 있으므로
		 * 그때의 각 봉지 수의 합을 ans에 저장한다.
		 * 정확한 요청 수량을 배달할 수 없을 경우 초기값 -1이 출력된다.
		 */
		for (int i = m/5; i >= 0; --i) {
			int tmp = m - 5*i;
			if (tmp % 3 == 0) {
				ans = i + tmp/3;
				break;
			}
		}
		System.out.print(ans);
		br.close();
	}
}
