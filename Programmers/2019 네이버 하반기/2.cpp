#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

bool isValid(int n) {
    return ceil((n-1)/4.0) == floor((n-1)/4.0);
}

long long getNum(int n) {
    return (n-1)/4 + 1;
}

long long solution(int n) {
    if (n > 1 && isValid(n)) {
        long long num = getNum(n);
        return num * (num+1) * (num+2);
    } else {
        long long share = (n-1)/4;
        return (n-share) * (n-share+1);
    }
}

int main() {
    int n;
    cin >> n;
    cout << solution(n);
    return 0;
}