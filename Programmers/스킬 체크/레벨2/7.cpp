// 주식가격이 떨어지지 않은 기간
#include <iostream>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;

    for (int i = 0; i < prices.size()-1; i++) {
        int index = prices.size()-i-1;
        for (int j = i+1; j < prices.size(); j++) {
            if (prices[i] > prices[j]) {
                index = j-i;
                break;
            }
        }
        answer.push_back(index);
    }
    answer.push_back(0);
    
    return answer;
}

int main() {
    vector<int> prices;
    prices.push_back(1);
    prices.push_back(2);
    prices.push_back(3);
    prices.push_back(2);
    prices.push_back(3);

    vector<int> result = solution(prices);
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << ' ';
    }
    return 0;
}