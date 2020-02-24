// 3. 화장실
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, min = 150, max = 0, a, b;
    vector<pair<int, int> > apply;
    
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a >> b;
        if (min > a) {
            min = a;
        }
        if (max < b) {
            max = b;
        }
        apply.push_back(pair<int, int>(a, b));
    }

    int max_cnt = 0;
    for (int i = min; i <= max; i++) {
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (apply[j].first <= i && apply[j].second > i) {
                cnt += 1;
            }
        }
        if (max_cnt < cnt) {
            max_cnt = cnt;
        }
    }
    cout << max_cnt;
    return 0;
}