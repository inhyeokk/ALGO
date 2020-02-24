// 무인도
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> people, int limit) {

    sort(people.begin(), people.end());

    int answer = 0;
    int i = people.size() - 1, j = 0;
    while (i > j) {
        if (people[i] + people[j] <= limit) {
            answer += 1;
            j += 1;
        } else {
            answer += 1;
        }
        i -= 1;
    }
    if (i == j) {
        answer += 1;
    }

    return answer;
}

int main() {
    vector<int> people;
    int limit = 100;
    people.push_back(70);
    people.push_back(50);
    people.push_back(80);
    people.push_back(50);

    cout << solution(people, limit);

    return 0;
}