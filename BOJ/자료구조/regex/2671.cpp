// BOJ regex 2671 잠수함식별
#include <iostream>
#include <regex>
#include <string>

using namespace std;

int main() {
    string input;
    cin >> input;
    bool answer = regex_match(input.c_str(), regex("(100+1+|01)+"));
    cout << (answer ? "SUBMARINE" : "NOISE") << endl;
    return 0;
}