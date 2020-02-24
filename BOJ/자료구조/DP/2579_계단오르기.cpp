/* 2579 계단 오르기
 * 2019.11.28
 */
#include <iostream>

using namespace std;

int main() {
    int n;
    int arr[301];
    cin >> n;    
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    int dp[301];
    dp[0] = 0;
    dp[1] = arr[1];
    dp[2] = arr[2] + arr[1];
    for (int i = 3; i <= n; i++) {
        int a = arr[i] + arr[i-1] + dp[i-3];
        int b = arr[i] + dp[i-2];
        dp[i] = a > b ? a : b;
    }
    cout << dp[n];
    return 0;
}