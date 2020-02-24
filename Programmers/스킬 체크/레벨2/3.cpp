// 최소값과 최대값
#include <iostream>
#include <algorithm>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

vector<int> split(string str, char delimiter) {
    vector<int> v;
    stringstream ss(str);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        v.push_back(atoi(temp.c_str()));
    }
 
    return v;
}

string solution(string s) {

    vector<int> v = split(s, ' ');

    sort(v.begin(), v.end());

    string answer = "";
    answer += to_string(v[0]);
    answer += " ";
    answer += to_string(v[v.size()-1]);
    return answer;
}

int main() {
    string arrangement = "1 2 3 4";

    cout << solution(arrangement);

    return 0;
}