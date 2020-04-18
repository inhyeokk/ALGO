/* 주식가격
 * 2019.10.25
 */
#include <stack>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    for (int i = 0; i < prices.size(); i++) {
        int sec = prices.size()-i-1;
        for (int j = i+1; j < prices.size(); j++) {
            if (prices[i] > prices[j]) {
                sec = j - i;
                break;
            }
        }
        answer.push_back(sec);
    }
    return answer;
}

vector<int> solution1(vector<int> prices) {
    vector<int> answer(prices.size());
    stack<int> s;
    for (int i = 0; i < prices.size(); i++) {
        while(!s.empty() && prices[s.top()] > prices[i]) {
            answer[s.top()] = i - s.top();
            s.pop();
        }
        s.push(i);
    }
    while (!s.empty()) {
        answer[s.top()] = prices.size()-s.top()-1;
        s.pop();
    }
    return answer;
}