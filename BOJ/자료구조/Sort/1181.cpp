// BOJ sort 1181 단어 정렬
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

string a[20000];
int n;

// 길이 순 오름차순
bool compare(string a, string b) {
    if(a.length() < b.length()) {
        return 1;
    } else if(a.length() > b.length()) {
        return 0;
    } else { // 길이가 같은 경우
        return a < b; // 사전순으로 정렬
    }
}

int main() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    sort(a, a + n, compare);

    for(int i = 0; i< n; i++) {
        if(i > 0 && a[i] == a[i-1]) {
            continue;
        } else{
            cout << a[i] << '\n';
        }
    }
    return 0;
}