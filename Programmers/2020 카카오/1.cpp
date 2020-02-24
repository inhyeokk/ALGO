#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int size = s.length();
    int max = 0;

    for (int i = 1; i <= size / 2; i++) {
        int cnt = 0;
        int comprassSize = 0;
        for (int j = 0; j < size - i; j += i) {
            if (s.substr(j, i) == s.substr(j+i, i)) {
                cnt += 1;
            } else {
                if (cnt > 0) {
                    int numCnt = 1, tempCnt = cnt+1;
                    while (tempCnt >= 10) {
                        numCnt += 1;
                        tempCnt /= 10;
                    }
                    comprassSize += i * cnt - numCnt;
                }
                cnt = 0;
            }
        }
        if (cnt > 0) {
            int numCnt = 1, tempCnt = cnt+1;
            while (tempCnt >= 10) {
                numCnt += 1;
                tempCnt /= 10;
            }
            comprassSize += i * cnt - numCnt;
        }
        if (comprassSize > max) {
            max = comprassSize;
        }
    }
    int answer = size - max;
    return answer;
}

int main() {

    cout << solution("aabbaccc") << endl;
    cout << solution("ababcdcdababcdcd") << endl;
    cout << solution("abcabcdede") << endl;
    cout << solution("abcabcabcabcdededededede") << endl;
    cout << solution("xababcdcdababcdcd") << endl;

    string input;
    cin >> input;
    cout << solution(input);

    return 0;
}