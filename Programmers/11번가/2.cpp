#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> v) {
    sort(v.begin(), v.end());

    int max_sum = 0;
    do {
        int sum = 0;
        for (int i = 0; i < v.size()-1; i++) {
            int temp = v[i] - v[i+1];
            if (temp < 0) {
                temp = temp * -1;
            }
            sum += temp;
        }
        max_sum = max(max_sum, sum);
    } while(next_permutation(v.begin(), v.end()));
    
    return max_sum;
}

int main() {
    vector<int> v;
    v.push_back(20);
    v.push_back(8);
    v.push_back(10);
    v.push_back(1);
    v.push_back(4);
    v.push_back(15);

    cout << solution(v);
    return 0;
}