// 수 반대로 출력하기
#include <iostream>
#include <vector>

using namespace std;

vector<int> solution(long long n) {

    vector<int> answer;
    while (n >= 10) {
        answer.push_back(n % 10);
        n /= 10;
    }
    answer.push_back(n % 10);
    return answer;
}

int main() {
    int n;
    cin >> n;

    vector<int> result = solution(n);
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << ' ';
    }

    return 0;
}