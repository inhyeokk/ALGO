// DFS/BFS 네트워크
#include <iostream>
#include <vector>

using namespace std;

bool isVisited[200];

void DFS(int n, vector<vector<int>> computers, int start) {
    
    isVisited[start] = true;

    for (int j = 0; j < n; j++) {
        if (!isVisited[j] && computers[start][j] == 1) {
            DFS(n, computers, j);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    
    int answer = 0;
    for (int i = 0; i < n; i++) {
        if (!isVisited[i]) {
            DFS(n, computers, i);
            answer += 1;
        }
    }
    return answer;
}

int main() {
    int n = 3;
    vector<vector<int>> computers;
    computers.push_back(vector<int>());
    computers[0].push_back(1);
    computers[0].push_back(1);
    computers[0].push_back(0);

    computers.push_back(vector<int>());
    computers[1].push_back(1);
    computers[1].push_back(1);
    computers[1].push_back(1);

    computers.push_back(vector<int>());
    computers[2].push_back(0);
    computers[2].push_back(1);
    computers[2].push_back(1);

    cout << solution(n, computers);
    return 0;
}