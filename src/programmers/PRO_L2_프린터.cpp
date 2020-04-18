/* 프린터
 * 2019.10.24
 */
#include <queue>
#include <vector>

using namespace std;

bool isHigh(vector<pair<int, int> > q) {

    pair<int, int> j = q[0];
    for (int i = 1; i < q.size(); i++) {
        if (j.second < q[i].second) {
            return true;
        }
    }
    return false;
}

int solution(vector<int> priorities, int location) {
    
    int answer = 0;
    vector<pair<int, int> > q; // 인덱스, 중요도
    for (int i = 0; i < priorities.size(); i++) {
        q.push_back(make_pair(i, priorities[i]));
    }

    while (!q.empty()) {
        if (isHigh(q)) {
            vector<pair<int, int> > temp;
            for (int i = 1; i < q.size(); i++) {
                temp.push_back(q[i]);
            }
            temp.push_back(q[0]);
            q.clear();
            for (auto t: temp) {
                q.push_back(t);
            }
        } else {
            answer += 1;
            if (q[0].first == location) {
                return answer;
            }
            vector<pair<int, int> > temp;
            for (int i = 1; i < q.size(); i++) {
                temp.push_back(q[i]);
            }
            q.clear();
            for (auto t: temp) {
                q.push_back(t);
            }
        }
    }
    return answer;
}