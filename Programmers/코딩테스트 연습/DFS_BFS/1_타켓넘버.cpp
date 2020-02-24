// DFS/BFS 타겟 넘버
#include <iostream>
#include <vector>

using namespace std;

int cnt;

void DFS(vector<int> numbers, int target, int value, int i) {
    if (i == numbers.size()) {
        if (value == target) {
            cnt += 1;
        }
        return;
    }
    DFS(numbers, target, value + numbers[i], i+1);
    DFS(numbers, target, value - numbers[i], i+1);
}

int solution(vector<int> numbers, int target) {
    DFS(numbers, target, 0, 0);
    int answer = cnt;
    return answer;
}

int main() {
    vector<int> numbers;
    int target = 3;
    numbers.push_back(1);
    numbers.push_back(1);
    numbers.push_back(1);
    numbers.push_back(1);
    numbers.push_back(1);

    cout << solution(numbers, target);
    return 0;
}