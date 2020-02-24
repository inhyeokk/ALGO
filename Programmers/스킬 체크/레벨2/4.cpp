// 흩어진 종이 조각
#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<int> prime; // 소수를 담는 벡터

vector<int> getNum(string s) {

    vector<int> v;
    for (int i = 0; i < s.length(); i++) {
        v.push_back(s[i] - '0');
    }
    return v;
}

bool isPrime(int n) {

    if (n <= 1) {
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

bool contains(int p) {

    if (find(prime.begin(), prime.end(), p) != prime.end()) {
        return true;
    } else {
        return false;
    }
}

bool *DFS(string s, int start, vector<int> v, bool *isVisited) {

    isVisited[start] = true;
    s += to_string(v[start]);

    int p = atoi(s.c_str());
    if (isPrime(p) && !contains(p)) {
        prime.push_back(p);
    }

    for (int j = 0; j < v.size(); j++) {
        if (!isVisited[j]) {
            DFS(s, j, v, isVisited);
        }
    }
    isVisited[start] = false;
    return isVisited;
}

int solution(string s) {

    vector<int> v = getNum(s);

    sort(v.begin(), v.end());

    for (int i = 0; i < v.size(); i++) {
        bool isVisited[8] = {false};
        DFS("", i, v, isVisited);
    }
    int answer = prime.size();
    return answer;
}

int main() {
    string input;
    cin >> input;

    cout << solution(input);

    return 0;
}