package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_서울_13반_강인혁 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기위한 버퍼리더
		StringTokenizer st; // 입력 처리를 위한 토크나이저
		StringBuilder sb = new StringBuilder(); // 출력 스트링을 담는 빌더
		int tc = Integer.parseInt(bf.readLine().trim()); // 테스트 케이스
		for (int t = 1; t <= tc; ++t) { // 테스트 케이스만큼 반복
			st = new StringTokenizer(bf.readLine(), " "); // 토크나이저 객체 생성
			int a = Integer.parseInt(st.nextToken()); // 시급
			int b = Integer.parseInt(st.nextToken()); // 일한 시간
			sb.append("#").append(t).append(" "); // 테스크 케이스에 대한 출력
			if ((a*b)/10 == (a*b) /10.0) { // 최소 단위인 10센트로 나누어 떨어지지 않으면 불가능
				int s = a*b/10; // 10으로 나누고 시작
				int x = s/40; // 4달러 = 400센트 => 400/10 = 40
				s %= 40; // 4달러를 최대한 사용하고난 나머지
				int y = s/10; // 1달러 = 100센트 => 100/10 = 10
				s %= 10; // 1달러를 최대한 사용하고난 나머지
				int z = s; // 10센트 => 10/10 = 1
				/* 4달러는 1달러와 10센트로 만들 수 있고
				 * 1달러는 10센트로 만들 수 있으니
				 * 위와 같이 탐욕적인 방법으로 각 화폐단위의 최소 사용 개수를 알 수 있다. 
				 */
				sb.append(x).append(" ").append(y).append(" ").append(z);
			} else {
				sb.append(-1); // 불가능
			}
			sb.append("\n");
		}
		System.out.print(sb); // 출력
		bf.close(); // 버퍼리더 닫기
	}
}
