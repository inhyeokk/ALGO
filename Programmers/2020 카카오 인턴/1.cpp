/* 2019 카카오 겨울 인턴십 1번
 * 2019.11.09
 */
#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    stack<int> s[30];
    for (int i = board.size()-1; i >= 0; i--) {
        for(int j = 0; j < board[i].size(); j++) {
            if (board[i][j] != 0) {
                s[j].push(board[i][j]);
            }
        }
    }
    stack<int> result;
    int answer = 0;
    for (int i = 0; i < moves.size(); i++) {
        if (s[moves[i]-1].empty()) {
            continue;
        }
        if (!result.empty() && result.top() == s[moves[i]-1].top()) {
            result.pop();
            answer += 2;
        } else {
            result.push(s[moves[i]-1].top());
        }
        s[moves[i]-1].pop();
    }
    return answer;
}

int main() {
    vector<vector<int>> board(5);
    board[0].push_back(0);
    board[0].push_back(0);
    board[0].push_back(0);
    board[0].push_back(0);
    board[0].push_back(0);
    
    board[1].push_back(0);
    board[1].push_back(0);
    board[1].push_back(1);
    board[1].push_back(0);
    board[1].push_back(3);

    board[2].push_back(0);
    board[2].push_back(2);
    board[2].push_back(5);
    board[2].push_back(0);
    board[2].push_back(1);
    
    board[3].push_back(4);
    board[3].push_back(2);
    board[3].push_back(4);
    board[3].push_back(4);
    board[3].push_back(2);
    
    board[4].push_back(3);
    board[4].push_back(5);
    board[4].push_back(1);
    board[4].push_back(3);
    board[4].push_back(1);
    vector<int> moves({1,5,3,5,1,2,1,4});

    cout << solution(board, moves);
    return 0;
}