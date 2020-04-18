// dp 등굣길
#include <iostream>
#include <vector>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    
    int map[101][101] = {0};
    int dp[101][101] = {0};

    for (auto v: puddles) {
        map[v[1]][v[0]] = -1;
    }
    
    dp[1][0] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (map[i][j] == -1) {
                continue;
            } else {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
    }
    
    int answer = dp[n][m];
    return answer;
}

int main() {
    int m = 4, n = 3;
    vector<vector<int>> puddles;
    puddles.push_back(vector<int>());
    puddles[0].push_back(2);
    puddles[0].push_back(2);

    cout << solution(4, 3, puddles);
    return 0;
}