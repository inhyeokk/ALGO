package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * {@link}  https://programmers.co.kr/learn/courses/30/lessons/42891
 * @date    2021-01-10
 * @author  rkddlsgur983
 */
public class PRO_무지의먹방라이브 {

//    public static void main(String[] args) {
//        int answer = solution(new int[]{3,1,2}, 5);
//        System.out.println(answer);
//    }

    public int solution(int[] food_times, long k) {
        int length = food_times.length;
        long sum = 0;
        List<Food> foods = new ArrayList<>(length);
        for (int i = 0; i < length; ++i) {
            foods.add(new Food(i + 1, food_times[i]));
            sum += food_times[i];
        }
        if (sum <= k) {
            return -1;
        }
        foods.sort(Comparator.comparingInt(o -> o.t));
        long beforeTime = 0;
        for (int i = 0; i < length; ++i) {
            long cur = foods.get(i).t - beforeTime;
            beforeTime = foods.get(i).t;
            if (k - cur * (length - i) > 0) {
                k -= cur * (length - i);
            } else {
                List<Food> subList = foods.subList(i, length);
                subList.sort(Comparator.comparingInt(o -> o.i));
                k %= (length - i);
                return subList.get((int)k).i;
            }
        }
        return -1;
    }

    static class Food {
        int i;
        int t;
        public Food(int i, int t) {
            this.i = i;
            this.t = t;
        }
    }
}
