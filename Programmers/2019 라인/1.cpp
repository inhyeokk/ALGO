// 1. 메시지 처리 시간
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main() {
    int m, c, input;
    vector<int> v;
    queue<int> q[11];

    cin >> m >> c;
    for (int i = 0; i < m; i++) {
        cin >> input;
        v.push_back(input);
    }

    int time = 0, i = 0;
    while (i < v.size()) {
        for (int j = 0; j < c; j++) {
            if (q[j].empty()) {
                q[j].push(v[i]);
                i+=1;
                if (i >= v.size()) {
                    break;
                }
            } else {
                q[j].front() -= 1;
                if (q[j].front() <= 0) {
                    q[j].pop();
                    q[j].push(v[i]);
                    i+=1;
                    if (i >= v.size()) {
                        break;
                    }
                }
            }
        }
        time += 1;
    }

    int max = 0;
    for (int j = 0; j < c; j++) {
        if (!q[j].empty()) {
            if (max < q[j].front()) {
                max = q[j].front();
            }
        }
    }
    if (max > 0) {
        time += max - 1;
    }
    cout << time;
    return 0;
}