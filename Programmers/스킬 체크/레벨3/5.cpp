/* 저울
 * 2019.11.21
 */
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> weight) {

    sort(weight.begin(), weight.end());
    int answer = 1;
    for (auto w: weight) {
        if (answer < w) {
            break;
        }
        answer += w;
    }
    return answer;
}

int main() {
    vector<int> weight({3, 1, 6, 2, 7, 30, 1});
    cout << solution(weight); // 21
    return 0;
}