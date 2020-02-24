#include <algorithm>
#include <vector>

using namespace std;

int getMin(vector<int> grade, int start) {

    int min_grade = grade[start];
    for (int i = start+1; i < grade.size(); i++) {
        min_grade = min(min_grade, grade[i]);
    }
    return min_grade;
}

int solution(vector<int> grade) {
    
    int answer = 0;

    for (int i = 0; i < grade.size()-1; i++) {
        int min = getMin(grade, i+1);
        if (grade[i] > min) {
            answer += (grade[i] - min);
            grade[i] = min;
        }
    }
    
    return answer;
}