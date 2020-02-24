/* 2748 피보나치 수 2
 * 2019.11.28
 */
#include <iostream>

using namespace std;

int main() {
    int n;
    long long dp[91];
    cin >> n;
    
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    cout << dp[n];
    return 0;
}