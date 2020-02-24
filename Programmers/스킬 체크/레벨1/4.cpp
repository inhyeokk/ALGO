// 수의 합과 평균
#include <vector>

using namespace std;

double solution(vector<int> arr) {
    double sum = 0.0;
    for (int i = 0; i < arr.size(); i++) {
        sum += arr[i];
    }
    return sum / arr.size();
}