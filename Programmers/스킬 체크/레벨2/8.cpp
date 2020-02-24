// 전화번호부와 접두어
#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

bool shorter(string a, string b) {
    return a.length() < b.length();
}

bool solution(vector<string> phone_book) {

    sort(phone_book.begin(), phone_book.end(), shorter);

    for (int i = 0; i < phone_book.size(); i++) {
        for (int j = i+1; j < phone_book.size(); j++) {
            int a_length = phone_book[i].length();
            if (atoi(phone_book[i].c_str()) == atoi(phone_book[j].substr(0, a_length).c_str())) {
                return false;
            }
        }
    }
    return true;
}

int main() {
    vector<string> phone_book;
    phone_book.push_back("119");
    phone_book.push_back("97674223");
    phone_book.push_back("1195524421");
    
    cout << solution(phone_book);
    return 0;
}