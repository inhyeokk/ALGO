#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;
    for (int i = 0; i < queries.size(); i++) {
        int findCnt = 0;
        for (int j = 0; j < words.size(); j++) {
            if (queries[i].length() == words[j].length()) {
                bool isQuery = false;
                for (int k = 0; k < queries[i].length(); k++) {
                    if (queries[i][k] != '?' && queries[i][k] != words[j][k]) {
                        isQuery = false;
                        break;
                    } else {
                        isQuery = true;
                    }
                }
                if (isQuery) {
                    findCnt += 1;
                }
            }
        }
        answer.push_back(findCnt);
    }
    return answer;
}