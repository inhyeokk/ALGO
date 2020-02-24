/* 기능개발
 * 2019.10.23
 */
#include <math.h>
#include <queue>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> q;
    for (int i = 0; i < progresses.size(); i++) {
        q.push(ceil((double)(100 - progresses[i]) / (double)speeds[i]));
    }
    
    int cnt = 1;
    int head = q.front();
    q.pop();
    while (!q.empty())  {
        if (head >= q.front()) {
            q.pop();
            cnt += 1;
        } else {
            answer.push_back(cnt);
            cnt = 1;
            head = q.front();
            q.pop();
        }
    }
    answer.push_back(cnt);
    return answer;
}