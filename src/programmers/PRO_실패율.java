package programmers;

import java.util.Arrays;

/**
 * {@link}  https://programmers.co.kr/learn/courses/30/lessons/42889
 * @date    2021-01-14
 * @author  rkddlsgur983
 */
public class PRO_실패율 {
    public int[] solution(int N, int[] users) {
        Arrays.sort(users);
        Stage[] stages = new Stage[N];
        int i = 0, cnt = 0;
        float remain = users.length;
        for (int j = 0, len = users.length; i < N && j < len;) {
            if (users[j] == i+1) {
                --remain;
                ++cnt;
                ++j;
            } else {
                stages[i] = new Stage(i+1, cnt / remain);
                ++i;
                cnt = 0;
            }
        }
        if (cnt > 0) {
            stages[i] = new Stage(i+1, cnt / remain);
            ++i;
        }
        for (; i < N; ++i) {
            stages[i] = new Stage(i+1, 0);
        }

        Arrays.sort(stages, (o1, o2) -> {
            if (o1.per == o2.per) {
                return Integer.compare(o1.i, o2.i);
            } else {
                return Float.compare(o2.per, o1.per);
            }
        });
        int[] answer = new int[N];
        for (int j = 0; j < N; ++j) {
            answer[j] = stages[j].i;
        }
        return answer;
    }

    static class Stage {
        int i;
        float per;

        public Stage(int i, float per) {
            this.i = i;
            this.per = per;
        }
    }
}
