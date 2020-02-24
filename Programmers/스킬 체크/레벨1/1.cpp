// 소수 찾기
#include <iostream>
#include <vector>

using namespace std;

bool isPrime(int n) {

    if (n == 1) {
        return false;
    }
    if (n == 2) {
        return true;
    }
    if (n % 2 == 0) {
        return false;
    }

    for (int i = 3; i < n; i+=2) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}

int solution(int n) {

    vector<int> num;
    for (int i = 2; i <= n; i++) {
        if (isPrime(i)) {
            num.push_back(i);
        }
    }

    int answer = num.size();
    return answer;
}

int main() {
    
    int n;
    cin >> n;
    cout << solution(n);

    return 0;
}