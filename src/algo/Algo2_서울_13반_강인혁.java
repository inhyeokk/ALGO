package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_13반_강인혁 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		StringTokenizer st; // 입력 처리를 위한 토크나이저
		StringBuilder sb = new StringBuilder(); // 출력을 담기위한 빌더
//		char[][] map = new char[30000][30]; // map 재활용을 위해 최대 입력 범위만큼 생성
//		int tc = Integer.parseInt(bf.readLine().trim()); // 테스트 케이스
//		for (int t = 1; t <= tc; ++t) { // 테스트 케이스만큼 반복
			st = new StringTokenizer(bf.readLine().trim(), " "); // 토크나이저 객체 생성
			int r = Integer.parseInt(st.nextToken()); // R
			int c = Integer.parseInt(st.nextToken()); // C
			char[][] map = new char[r][c];
			// map에 r*c만큼 입력받음
			for (int i = 0; i < r; ++i) {
				String s = bf.readLine().trim();
				for (int j = 0; j < c; ++j) {
					map[i][j] = s.charAt(j);
				}
			}
			int n = Integer.parseInt(bf.readLine().trim()); // 화산탄 개수 N
//			st = new StringTokenizer(bf.readLine().trim(), " "); // 토크나이저 객체 생성
			for (int i = 0; i < n; ++i) { // 화산탄 개수만큼 반복
//				int k = Integer.parseInt(st.nextToken()); // 화산탄 열 위치
				int k = Integer.parseInt(bf.readLine());
				int x = 0, y = k-1; // 기준점을 0,0으로 잡기 위해 열위치-1
				while (true) { // break를 만나기 전까지 반복
					if (x+1 < r) { // 아래로 이동할 수 있는가
						if (map[x+1][y] == '.') { // 아래가 비어있으면
							++x; // 아래로 이동
						} else if (map[x+1][y] == 'X') { // 아래가 장애물이면
							break; // 종료
						} else { // 굳은 화산탄이면
							// 왼쪽칸과 왼쪽-아래칸이 비어있다면
							if (y-1 >= 0 && map[x+1][y-1] == '.' && map[x][y-1] == '.') {
								// 왼쪽-아래칸으로 이동
								++x;
								--y;
							} else {
								// 왼쪽으로 이동하지 않았다면
								// 오른쪽칸과 오른쪽-아래칸이 비어있는가
								if (y+1 < c && map[x+1][y+1] == '.' && map[x][y+1] == '.') {
									// 오른쪽-아래칸으로 이동
									++x;
									++y;
								} else {
									// 어느쪽으로도 이동할 수 없다면 종료
									break;
								}
							}
						}
					} else { // 없다면 종료
						break;
					}
				}
				map[x][y] = 'O'; // 화산탄 이동종료 = 굳은 화산탄
			}
//			sb.append("#").append(" ").append(t).append("\n"); // 출력
			for (int i = 0; i < r; ++i) { // 화산탄이 떨어지고난 map
				for (int j = 0; j < c; ++j) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
//		}
		System.out.print(sb); // 출력
		bf.close(); // 입력버퍼 닫기
	}
}
