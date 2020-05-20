package programmers;

import java.util.LinkedList;
import java.util.List;

/**
 * @source	Summer/Winter Coding(~2018)
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/49994
 * @date   	2020-05-20
 * @author 	rkddlsgur983
 * @idea	단순 좌표의 방문이 아닌 좌표와 좌표 사이 간선을 방문했는지 확인해야하므로
 * 			이동 경로를 리스트에 저장해두고 이동할때마다 경로 포함 여부를 확인한다.
 */
public class PRO_L3_방문길이 {
	private int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public int solution(String dirs) {
		int r = 5, c = 5;
		List<Move> list = new LinkedList<>();
		for (int i = 0, len = dirs.length(); i < len; ++i) {
			int d = getDir(dirs.charAt(i));
			int nr = r + di[d][0];
			int nc = c + di[d][1];
			if (nr >= 0 && nr <= 10 && nc >= 0 && nc <= 10) {
				boolean contain = false;
				for (Move m: list) {
					if ((m.fr == r && m.fc == c && m.er == nr && m.ec == nc)
							|| (m.fr == nr && m.fc == nc && m.er == r && m.ec == c)){
						contain = true;
						break;
					}
				}
				if (!contain) {
					list.add(new Move(r,c,nr,nc));
				}
				r = nr;
				c = nc;
			}
		}
        return list.size();
    }
	
	class Move {
		int fr;
		int fc;
		int er;
		int ec;
		public Move(int fr, int fc, int er, int ec) {
			this.fr = fr;
			this.fc = fc;
			this.er = er;
			this.ec = ec;
		}
	}
	
	private int getDir(char c) {
		switch (c) {
			case 'R':
				return 0;
			case 'D':
				return 1;
			case 'L':
				return 2;
			case 'U':
				return 3;
		}
		return 0;
	}
}
