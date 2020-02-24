// BOJ BinarySearch 16401 과자 나눠주기
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool isDivisiable(vector<int> snack, int m, int length) {
    int cnt = 0;
    for (int i = 0; i < snack.size(); i++) {
        cnt += snack[i] / length;
    }
    return cnt >= m;
}

int main() {
    int m, n, input;
    vector<int> snack;

    cin >> m >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        snack.push_back(input);
    }
    sort(snack.begin(), snack.end());

    int low = 1, high = snack[n-1];
    int mid = (low + high) / 2;
    int answer = 0;

    while (low <= high) {
        if (isDivisiable(snack, m, mid)) {
            answer = max(answer, mid);
            low = mid + 1;
        } else {
            high = mid - 1;
        }
        mid = (low + high) / 2;
    }
    
    cout << answer;
    return 0;
}