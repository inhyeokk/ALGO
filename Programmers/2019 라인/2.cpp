// 2. k번째 순열 찾기
#include <iostream>
#include <algorithm>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

vector<int> split(string str, char delimiter) {
    vector<int> v;
    stringstream ss(str);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        v.push_back(atoi(temp.c_str()));
    }
 
    return v;
}

int factorial(int n) {
    int f = 1;
    for (int i = n; i >= 1; i--) {
        f *= i;
    }
    return f;
}

string getPermutation(vector<int> num, int k) {

    if (num.size() == 1) {
        return to_string(num[0]);
    }
    int share = k / factorial(num.size() - 1);
    int rest = k % factorial(num.size() - 1);
    vector<int> temp;
    for (int i = 0; i < num.size(); i++) {
        if (i != share) {
            temp.push_back(num[i]);
        }
    }
    return to_string(num[share]) + getPermutation(temp, rest);
}

int main() {
    string input;
    int k;
    vector<int> num;

    getline(cin, input);
    cin >> k;

    num = split(input, ' ');

    sort(num.begin(), num.end());

    cout << getPermutation(num, k-1);
    
    return 0;
}