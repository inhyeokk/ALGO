// BOJ #11052 카드 구매하기 - DP
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

const int MAX_N = 1001;
const int MAX_P = 10001;

int n;
int p[MAX_N], dp[MAX_N];

int main() {

    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> p[i];
        dp[i] = 0;
    }

    dp[1] = p[1];
    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= floor(i/2); j++) {
            dp[i] = max(dp[i], max(p[i], dp[j] + dp[i-j]));
        }
    }

    cout << dp[n];
    return 0;
}