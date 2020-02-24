// BOJ BFS 2178 미로 탐색
#include <iostream>
#include <string>
#include <queue>
#include <vector>

using namespace std;

int graph[101][101];

bool bfs_visited[101][101];

int n, m;

// 상하좌우 확인 시 배열 범위 안인지 확인
bool isValid(int x, int y) {

    if (x < 1 || x > n) {
        return false;
    }
    if (y < 1 || y > m) {
        return false;
    }
    return true;
}

int BFS() {

    queue<pair<pair<int, int>, int> > q; // first: 좌표, second: 개수
    bfs_visited[1][1] = true;

    q.push(make_pair(make_pair(1, 1), 1));
    while(!q.empty()) {
        pair<pair<int, int>, int> node = q.front();
        q.pop();
        
        int x = node.first.first;
        int y = node.first.second;
        bfs_visited[x][y] = true;
        if (x == n && y == m) {
            return node.second;
        }

        if (isValid(x, y-1) && graph[x][y-1] && !bfs_visited[x][y-1]) {            
            bfs_visited[x][y-1] = true;
            q.push(make_pair(make_pair(x, y-1), node.second+1));
        }
        if (isValid(x, y+1) && graph[x][y+1] && !bfs_visited[x][y+1]) {
            bfs_visited[x][y+1] = true;
            q.push(make_pair(make_pair(x, y+1), node.second+1));
        }
        if (isValid(x-1, y) && graph[x-1][y] && !bfs_visited[x-1][y]) {
            bfs_visited[x-1][y] = true;
            q.push(make_pair(make_pair(x-1, y), node.second+1));
        }
        if (isValid(x+1, y) && graph[x+1][y] && !bfs_visited[x+1][y]) {
            bfs_visited[x+1][y] = true;
            q.push(make_pair(make_pair(x+1, y), node.second+1));
        }
    }
}

int main() {
    cin >> n >> m;

    string input;
    for (int i = 1; i <= n; i++) {
        cin >> input;
        for (int j = 1; j <= m; j++) {
            graph[i][j] = input.substr(j-1, 1).c_str()[0] - '0';
        }
    }

    cout << BFS();

    return 0;
}