#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int getNum(int n, int k) {

    string num = "";
    while(n > k) {
        num = to_string(n % k) + num;
        n /= k;
    }
    num = to_string(n) + num;
    return atoi(num.c_str());
}

int getMultiple(int n) {

    int num = 1;
    while (n >= 10) {
        if (n != 0) {
            num *= n % 10;
        }
        n /= 10;
    }
    num *= n;
    return num;
}

int main() {

    int max = 0;
    int index = 2;
    for (int i = 2; i < 10; i++) {
        int temp = getNum(10, i);
        int mul = getMultiple(temp);
        
        cout << i << ' ' << temp  << ' ' << mul << endl;
        if (max < mul) {
            max = mul;
            index = i;
        }
    }
    cout << index << ' ' << max;
    return 0;
}