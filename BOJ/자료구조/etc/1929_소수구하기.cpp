/* 1929 소수 구하기
 * 2019.11.28
 */
#include <iostream>
#include <string.h>

using namespace std;

int main() {
    int m, n;
    bool arr[1000001];

    cin >> m >> n;
    memset(arr, true, sizeof(arr));
    arr[1] = false;

    // 에라토스테네스의 체
    for (int i = 2; i <= n; i++) {
        for (int j = i+i; j <= n; j+=i) {
            arr[j] = false;
        }
    }

    for (int i = m; i <= n; i++) {
        if (arr[i]) {
            cout << i << '\n';
        }
    }
    return 0;
}