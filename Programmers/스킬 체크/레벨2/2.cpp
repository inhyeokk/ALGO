// 쇠막대기
#include <iostream>
#include <queue>
#include <string>

using namespace std;

int solution(string arrangement) {
    
    queue<char> q;
    for (int i = 0; i < arrangement.length(); i++) {
        q.push(arrangement[i]);
    }

    int answer = 0;
    int level = 0;
    while (!q.empty()) {
        if (q.front() == '(') {
            q.pop();
            level += 1;
            if (q.front() == ')') {
                q.pop();
                level -= 1;
                answer += level;
            }
        } else { // q.front() == ')'
            answer += 1;
            level -= 1;
            q.pop();
        }
    }

    return answer;
}

int main() {
    string arrangement = "()(((()())(())()))(())";

    cout << solution(arrangement);

    return 0;
}