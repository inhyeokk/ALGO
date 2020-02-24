// BOJ #1699 제곱수의 합 - DP
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

const int MAX_N = 100001;

int n;
int dp[MAX_N];

int main() {

    cin >> n;

    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
        dp[i] = MAX_N;
    }

    for (int i = 1; i <= floor(sqrt(n)); i++) {
        for (int j = i*i; j <= n; j++) {
            dp[j] = min(dp[j], dp[j - i*i] + 1);
        }
    }

    cout << dp[n];

    return 0;
}