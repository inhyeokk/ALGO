package programmers.sk;

import java.util.Arrays;

public class Solution2 {
	public String[] solution(String[] company_names, int[][] scores) {
        int size = company_names.length;
		Company[] companys = new Company[size];
		for (int i = 0; i < size; ++i) {
			int cnt = 0, total = 0;
			for (int j = 0, len = scores[i].length; j < len; ++j) {
				total += scores[i][j];
				if (scores[i][j] >= 80) {
					++cnt;
				}
			}
			companys[i] = new Company(company_names[i], cnt, total);
		}
		Arrays.sort(companys);
		String[] answer = new String[size];
		for (int i = 0; i < size; ++i) {
			answer[i] = companys[i].name;
		}
        return answer;
    }
	
	class Company implements Comparable<Company> {
		String name;
		int cnt;
		int total;
		public Company(String name, int cnt, int total) {
			this.name = name;
			this.cnt = cnt;
			this.total = total;
		}

		@Override
		public int compareTo(Company o) {
			if (cnt == o.cnt) {
				if (total == o.total) {
					return name.compareTo(o.name);
				}
				return Integer.compare(o.total, total);
			}
			return Integer.compare(o.cnt, cnt);
		}
	}
}
