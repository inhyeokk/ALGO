// 4. 출근하는 브라운
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, input;
    vector<int> v;

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        if (input == 1) {
            v.push_back(i);
        }
    }

    int max = 0;
    if (v.size() == 1) {
        if (v[0] > n/2) {
            max = v[0];
        } else {
            max = n-1 - v[0];
        }
        cout << max;
    } else if (v.size() > 1) {
        for (int i = 0; i < v.size()-1; i++) {
            if (v[i+1] - v[i] > max) {
                max = v[i+1] - v[i];
            }
        }
        cout << max/2;
    } else {
        cout << max;
    }
    return 0;
}