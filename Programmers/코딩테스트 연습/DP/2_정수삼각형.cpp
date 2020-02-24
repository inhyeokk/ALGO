// dp 정수 삼각형
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    vector<vector<int>> dp(triangle.size(), vector<int>(triangle.size()));
    
    dp[0][0] = triangle[0][0];
    for (int i = 1; i < triangle.size(); i++) {
        for (int j = 0; j <= i; j++) {
            if (j == 0) {
                dp[i][j] = dp[i-1][j] + triangle[i][j];
            } else if (j == i) {
                dp[i][j] = dp[i-1][j-1] + triangle[i][j];
            } else {
                dp[i][j] = max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
            }
            if (i == triangle.size()-1) {
                answer = max(answer, dp[i][j]);
            }
        }
    }
    return answer;
}

// 배열 할당 에러
int solution2(vector<vector<int>> triangle) {

    vector<int> dp;
    dp.push_back(triangle[0][0]);
    int top = 0, origin = 0;
    for (int i = 1; i < triangle.size(); i++) {
        for (int j = 0; j < i; j++) {
            dp.push_back(dp[top] + triangle[i][j]);
            dp.push_back(dp[top] + triangle[i][j+1]);
            top+=1;
        }
        origin += pow(2, i-1);
        top = origin;
    }

    int answer = *max_element(dp.begin(), dp.end());
    return answer;
}

int main() {
    vector<vector<int>> triangle;
    triangle.push_back(vector<int>());
    triangle[0].push_back(7);

    triangle.push_back(vector<int>());
    triangle[1].push_back(3);
    triangle[1].push_back(8);

    triangle.push_back(vector<int>());
    triangle[2].push_back(8);
    triangle[2].push_back(1);
    triangle[2].push_back(0);

    triangle.push_back(vector<int>());
    triangle[3].push_back(2);
    triangle[3].push_back(7);
    triangle[3].push_back(4);
    triangle[3].push_back(4);
    
    triangle.push_back(vector<int>());
    triangle[4].push_back(4);
    triangle[4].push_back(5);
    triangle[4].push_back(2);
    triangle[4].push_back(6);
    triangle[4].push_back(5);

    cout << solution(triangle);    
    return 0;
}