#include <string>
#include <vector>

using namespace std;

bool isRightString(string str) {
    vector <char> stack;
    for (int i = 0; i < str.length(); i++) {
        switch (str[i]) {
            case '(':
                stack.push_back('(');
                break;
            case ')':
                if (stack.size() != 0) {
                    stack.pop_back();
                } else {
                    return false;
                }
                break;
        }
    }
    return true;
}

bool isBalancedString(string str) {
    int f_cnt = 0, s_cnt = 0;
    for (int i = 0; i < str.length(); i++) {
        switch (str[i]) {
            case '(':
                f_cnt += 1;
                break;
            case ')':
                s_cnt += 1;
                break;
        }
    }
    return f_cnt == s_cnt;
}

string solution(string p) {

    if (p.length() == 0)
        return p;

    if (isRightString(p)) {
        return p;
    }

    string u = "", v = "";
    for (int i = 2; i <= p.length(); i+=2) {
        if (isBalancedString(p.substr(0, i))
            && isBalancedString(p.substr(i, p.length() - i))
        ) {
            u = p.substr(0, i);
            v = p.substr(i, p.length() - i);
            break;
        }
    }

    if (isRightString(u)) {
        return u + solution(v);
    } else {
        string temp = "(";
        temp += solution(v);
        temp += ")";
        for (int i = 1; i < u.length()-1; i++) {
            switch (u[i]) {
                case '(':
                    temp += ")";
                    break;
                case ')':
                    temp += "(";
                    break;
            }
        }
        return temp;
    }
}