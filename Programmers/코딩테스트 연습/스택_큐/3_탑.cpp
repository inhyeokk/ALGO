/* 탑
 * 2019.10.24
 */
#include <stack>
#include <vector>

using namespace std;

vector<int> solution(vector<int> heights) {
    
    stack<int> s;
    while (!heights.empty()) {
        int i = heights.size()-1;
        int h = heights[i];
        heights.pop_back();

        bool isPush = false;
        for (int j = heights.size()-1; j >= 0; j--) {
            if (h < heights[j]) {
                s.push(j+1);
                isPush = true;
                break;
            }
        }
        if (!isPush) {
            s.push(0);
        }
    }
    vector<int> answer;
    while (!s.empty()) {
        answer.push_back(s.top());
        s.pop();
    }
    return answer;
}