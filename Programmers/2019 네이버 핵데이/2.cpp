// 재확인 필요
#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<int> share[26];
bool isVisited[1001][1001];

bool isValid(vector<string> maps, int x, int y) {

    if (x < 0 || x >= maps.size()) {
        return false;
    }
    if (y < 0 || y >= maps[0].length()) {
        return false;
    }
    return true;
}

bool contains(int a, int b) {

    if (find(share[a].begin(), share[a].end(), b) != share[a].end()) {
        return true;
    } else {
        return false;
    }
}

void DFS(vector<string> maps, int x, int y) {

    int i = maps[x].substr(y,1).c_str()[0] - 'A';
    isVisited[x][y] = true;

    if (isValid(maps, x, y-1) && maps[x].substr(y-1,1).c_str()[0] != '.' && !isVisited[x][y-1]) {
        int a = maps[x].substr(y-1,1).c_str()[0] - 'A';
        if (i != a) {
            if (!contains(i, a)) {
                share[i].push_back(a);
            }
            if (!contains(a, i)) {
                share[a].push_back(i);
            }
        }
        DFS(maps, x, y-1);
    }
    if (isValid(maps, x, y+1) && maps[x].substr(y+1,1).c_str()[0] != '.' && !isVisited[x][y+1]) {
        int a = maps[x].substr(y+1,1).c_str()[0] - 'A';
        if (i != a) {
            if (!contains(i, a)) {
                share[i].push_back(a);
            }
            if (!contains(a, i)) {
                share[a].push_back(i);
            }
        }
        DFS(maps, x, y+1);
    }
    if (isValid(maps, x-1, y) && maps[x-1].substr(y,1).c_str()[0] != '.' && !isVisited[x-1][y]) {
        int a = maps[x-1].substr(y,1).c_str()[0] - 'A';
        if (i != a) {
            if (!contains(i, a)) {
                share[i].push_back(a);
            }
            if (!contains(a, i)) {
                share[a].push_back(i);
            }
        }
        DFS(maps, x-1, y);
    }
    if (isValid(maps, x+1, y) && maps[x+1].substr(y,1).c_str()[0] != '.' && !isVisited[x+1][y]) {
        int a = maps[x+1].substr(y,1).c_str()[0] - 'A';
        if (i != a) {
            if (!contains(i, a)) {
                share[i].push_back(a);
            }
            if (!contains(a, i)) {
                share[a].push_back(i);
            }
        }
        DFS(maps, x+1, y);
    }
}

vector<int> solution(vector<string> maps) {

    for (int i = 0; i < maps.size(); i++) {
        for (int j = 0; j < maps[i].length(); j++) {
            char temp = maps[i].substr(j,1).c_str()[0];
            if (temp != '.' && !isVisited[i][j]) {
                DFS(maps, i, j);
            }
        }
    }

    int sum = 0;
    int max_size = 0;
    for (int i = 0; i < 26; i++) {
        sum += share[i].size();
        if (max_size < share[i].size()) {
            max_size = share[i].size();
        }
    }

    vector<int> answer;
    answer.push_back(sum/2);
    answer.push_back(max_size);
    return answer;
}

int main() {
    vector<string> maps;
    maps.push_back("..........");
    maps.push_back("AAACC.....");
    maps.push_back(".AAA.....Z");
    maps.push_back("..AAAA..C.");
    maps.push_back("...BBBBB..");
    maps.push_back("....BBB...");
    maps.push_back("...ZBBB...");
    maps.push_back("ZZZZAAAC..");
    maps.push_back(".....CCCC.");
    maps.push_back("QQ......C.");
    maps.push_back("..........");

    vector<int> result = solution(maps);
    cout << result[0] << ' ' << result[1];
    return 0;
}