// BOJ DFS 10265 MT
// 14% 시간초과
/*
 1. 노드 단방향 연결
 2. 각 노드에 종속된 연결 요소 셋
 3. 순차적으로 재귀 탐색
  1) start가 속한 그룹의 인원수(=start 노드에 연결된 노드 개수) cnt에 저장
  2) start 노드에 연결되지 않은 노드의 연결 요소 재탐색
 */
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

const int MAX_N = 1001;

// DFS
vector<int> graph[MAX_N];
bool isConnected[MAX_N][MAX_N]; // DP

int n, k;

void DFS(int start, int node) {

    // 노드 방문
    isConnected[start][node] = true;
    
    for (int j = 0; j < graph[node].size(); j++) {
        int next = graph[node][j];
        // 방문한 노드가 아니면 탐색    
        if (!isConnected[start][next]) {
            DFS(start, next);
        }
    }
}

int DFS_PEOPLE(int before, bool isVisited[], int start) {

    bool temp[MAX_N];

    int cnt = 0;
    for (int j = 1; j <= n; j++) {
        temp[j] = isVisited[j]; // 임시 값 복사
        temp[j] = temp[j] || isConnected[start][j];
        if (temp[j]) {
            cnt += 1; // 인원수
        }
    }

    // int cnt = count(temp+1, temp+n+1, true);
        
    if (cnt > k) { // 재귀 종료 조건
        return before;
    }

    for (int j = 1; j <= n; j++) {
        isVisited[j] = temp[j]; // 다시 복사
    }

    for (int j = 1; j <= n; j++) {
        if (!isVisited[j]) {
            cnt = DFS_PEOPLE(cnt, isVisited, j);
        }
    }

    return cnt;
}

int main() {
    cin >> n >> k;

    int node;
    for (int i = 1; i <= n; i++) {
        cin >> node;
        graph[i].push_back(node);
    }

    // 순차 노드 방문
    for (int i = 1; i <= n; i++) {
        DFS(i, i);
    }

    int max_cnt = 0;
    for (int i = 1; i <= n; i++) {
        bool isVisited[MAX_N] = {false};
        max_cnt = max(max_cnt, DFS_PEOPLE(0, isVisited, i));
    }

    cout << max_cnt;
    return 0;
}