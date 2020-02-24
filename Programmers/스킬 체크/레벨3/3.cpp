/* 사각형
 */
#include <vector>

using namespace std;

long long solution(int N) {
    
    long long dp[81] = {0};
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= N; i++) {
        dp[i] = dp[i-2] + dp[i-1];
    }

    long long answer = 0;
    if (N == 1) {
        answer = 4;
    } else {
        answer = (dp[N]*2 + dp[N-1]) * 2;
    }
    return answer;
}