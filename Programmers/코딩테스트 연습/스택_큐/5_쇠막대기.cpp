/* 쇠막대기
 * 2019.10.25
 */
#include <iostream>
#include <stack>
#include <string>

using namespace std;

int solution(string arrangement) {
    
    stack<char> s;
    int bar = 0;
    for (int i = 0; i < arrangement.length(); i++) {
        if (arrangement[i] == '(') {
            s.push(arrangement[i]);
            if (arrangement[i+1] == ')') {
                s.pop();
                bar += s.size();
                i += 1;
            }
        } else if (arrangement[i] == ')') {
            s.pop();
            bar += 1;
        }
    }
    int answer = bar;
    return answer;
}

int main() {
    string arrangement = "()(((()())(())()))(())";
    cout << solution(arrangement); // 17
    return 0;
}