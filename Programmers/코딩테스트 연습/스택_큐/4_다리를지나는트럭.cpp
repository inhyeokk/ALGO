/* 다리를 지나는 트럭
 * 2019.10.25
 */
#include <algorithm>
#include <vector>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b) {
    return a.second < b.second;
}

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    
    pair<int, int> truck[10000]; // 무게, 시간
    truck[0] = make_pair(truck_weights[0], 0);
    int it = 1;
    int index = 1;
    int time = 1;
    int w = truck_weights[0];
    while(it != 0) {
        for (int i = 0; i < it; i++) {
            truck[i].second += 1;
        }
        while (it != 0
            && truck[it-1].second >= bridge_length) {
            w -= truck[it-1].first;
            it -= 1;
        }
        if (index < truck_weights.size()
            && w+truck_weights[index] <= weight) {
            truck[it] = make_pair(truck_weights[index], 0);
            w += truck_weights[index];
            index += 1;
            it += 1;
            sort(truck, truck+it, compare);
        }
        time += 1;
    }
    int answer = time;
    return answer;
}