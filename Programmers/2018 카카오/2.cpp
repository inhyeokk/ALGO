// 2017 KAKAO BLIND RECURITMENT [1차] 다트 게임
#include <iostream>
#include <string>
#include <math.h>

using namespace std;

int solution(string dartResult) {
    int length = dartResult.length();
    int score[3] = {0, 0, 0};
    int scoreIndex = -1;
    int tempScore = 0;
    bool isInt = false;

    for (int i = 0; i < length; i++) {
        if (dartResult[i] >= '0' && dartResult[i] <= '9') {
            if (isInt) {
                tempScore *= 10;
            } else {
                isInt = true;
                scoreIndex += 1;
                tempScore = dartResult[i] - '0';
            }
        } else if (dartResult[i] == 'S' || dartResult[i] == 'D' || dartResult[i] == 'T') {
            switch (dartResult[i]) {
                case 'S':
                    break;
                case 'D':
                    tempScore = pow(tempScore, 2);
                    break;
                case 'T':
                    tempScore = pow(tempScore, 3);
                    break;
            }
            isInt = false;
            score[scoreIndex] = tempScore;
        } else {
            switch (dartResult[i]) {
                case '*':
                    if (scoreIndex > 0) {
                        score[scoreIndex-1] *= 2;
                    }
                    tempScore *= 2;
                    break;
                case '#':
                    tempScore *= -1;
                    break;
            }
            score[scoreIndex] = tempScore;
        }
    }
    int answer = score[0] + score[1] + score[2];
    return answer;
}

int main() {

    int n;
    string input;

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        cout << solution(input) << endl;
    }

    return 0;
}