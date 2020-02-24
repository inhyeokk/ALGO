// 2017 KAKAO BLIND RECURITMENT [1차] 비밀지도 
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<vector<int>> brr1, brr2, brr3;
    
    for (int i = 0; i < n; i++) {
        int num1 = arr1[i];
        int num2 = arr2[i];
        vector<int> crr1, crr2;
        for (int j = 0; j < n; j++) {
            crr1.push_back(num1 % 2);
            crr2.push_back(num2 % 2);
            num1 /= 2;
            num2 /= 2;
        }
        brr1.push_back(crr1);
        brr2.push_back(crr2);
    }

    vector<string> answer;
    for (int i = 0; i < n; i++) {
        string s = "";
        for (int j = n-1; j >= 0; j--) {
            if (brr1[i][j] == 1 || brr2[i][j] == 1) {
                s += "#";
            } else {
                s += " ";
            }
        }
        answer.push_back(s);
    }
    return answer;
}

int main() {

    int n, input;
    vector<int> arr1, arr2;

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        arr1.push_back(input);
    }
    for (int i = 0; i < n; i++) {
        cin >> input;
        arr2.push_back(input);
    }

    solution(n, arr1, arr2);

    return 0;
}