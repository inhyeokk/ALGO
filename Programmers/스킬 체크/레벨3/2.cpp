// 가장 먼 노드 개수
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<int> graph[20001];
bool bfs_visited[20001];

int BFS(int start) {

    queue<pair<int, int> > q; // first: 번호, second: 촌수
    bfs_visited[start] = true;
    q.push(make_pair(start, 0));

    int max = 0;
    int cnt = 0;
    while(!q.empty()) {
        pair<int, int> node = q.front();
        q.pop();
        if (max < node.second) {
            max = node.second;
            cnt = 1;
        } else if (max == node.second) {
            cnt += 1;
        }

        for (int j = 0; j < graph[node.first].size(); j++) {
            int next = graph[node.first][j];
            if (!bfs_visited[next]) {            
                bfs_visited[next] = true;
                q.push(make_pair(next, node.second+1));
            }
        }
    }
    return cnt;
}

int solution(int n, vector<vector<int>> edge) {

    for (int i = 0; i < edge.size(); i++) {
        int node1 = edge[i][0];
        int node2 = edge[i][1];
        graph[node1].push_back(node2); // 양방향 연결
        graph[node2].push_back(node1);
    }

    int answer = BFS(1);
    return answer;
}

int main() {
    int n, vector<vector<int>> edge;
    n = 6;

    edge.push_back(vector<int>());
    edge[0].push_back(3);
    edge[0].push_back(6);

    edge.push_back(vector<int>());
    edge[1].push_back(4);
    edge[1].push_back(3);

    edge.push_back(vector<int>());
    edge[2].push_back(3);
    edge[2].push_back(2);

    edge.push_back(vector<int>());
    edge[3].push_back(1);
    edge[3].push_back(3);
    
    edge.push_back(vector<int>());
    edge[4].push_back(1);
    edge[4].push_back(2);

    edge.push_back(vector<int>());
    edge[5].push_back(2);
    edge[5].push_back(4);

    edge.push_back(vector<int>());
    edge[6].push_back(5);
    edge[6].push_back(2);

    cout << solution(n, edge);

    return 0;
}