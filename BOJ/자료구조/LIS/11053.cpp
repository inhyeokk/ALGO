/* 11053 가장 긴 증가하는 부분 수열
 * 2019.11.28
 */
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    int arr[1000] = {};
    int lis[1000] = {};

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    lis[0] = 1;
    int len = 1;
    for (int i = 1; i < n; i++) {
        int max = 0;
        for (int j = 0; j < i; j++) {
            if (arr[j] < arr[i]) {
                if (max < lis[j]) {
                    max = lis[j];
                }
            }
        }
        lis[i] = max+1;
        if (len < lis[i]) {
            len = lis[i];
        }
    }
    cout << len;
    return 0;
}