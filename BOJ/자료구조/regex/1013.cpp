// BOJ regex 1013 Contact
#include <iostream>
#include <regex>
#include <string>

using namespace std;

int main() {
    int n;
    string input;

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        if (regex_match(input, regex("(100+1+|01)+"))) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
    return 0;
}