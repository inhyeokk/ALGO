// BOJ queue 1966 프린터 큐
#include <iostream>
#include <queue>

using namespace std;

int main() {
    int t, n, m, input;
    queue<pair<int, int>> q;
    priority_queue<int> pq;

    cin >> t;
    for (int i = 0; i < t; i++) {
        // 초기화
        int cnt = 0;
        while(!q.empty()) {
            q.pop();
        }
        while(!pq.empty()) {
            pq.pop();
        }

        cin >> n >> m;
        for (int j = 0; j < n; j++) {
            cin >> input;
            q.push(pair<int, int>(j, input));
            pq.push(input); // 중요도 내림차순
        }

        while(!pq.empty()) {
            int priority = pq.top();
            pq.pop();
            while (priority != q.front().second) {
                // 큐의 가장 뒤에 재배치
                pair<int, int> temp = q.front();
                q.pop();
                q.push(temp);
            }
            cnt += 1; // 인쇄 횟수
            pair<int, int> temp = q.front();
            q.pop();

            // m번째 위치에 있는 문서가
            // 몇 번째로 인쇄되었는지 출력
            if (temp.first == m) {
                cout << cnt << endl;
                break;
            }
        }
    }
    return 0;
}