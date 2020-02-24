#include <deque>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

vector<string> split(string str, char delimiter) {
    vector<string> v;
    stringstream ss(str);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        v.push_back(temp.c_str());
    }
 
    return v;
}

vector<string> solution(vector<string> record) {
    vector<string> perm;
    deque<string> temp;

    for (int i = 0; i <record.size(); i++) {
        vector<string> result = split(record[i], ' ');
        if (result[0] == "RECEIVE") {
            temp.push_back(result[1]);
        } else if (result[0] == "DELETE") {
            if (!temp.empty()) {
                temp.pop_back();
            }
        } else if (result[0] == "SAVE") {
            while (!temp.empty()) {
                string e = temp.front();
                temp.pop_front();
                perm.push_back(e);
            }
        }
    }
    return perm;
}