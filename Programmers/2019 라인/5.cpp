// 5. 코니와 문의 술래잡기
#include <iostream>

using namespace std;

int factorial(int n) {
    int f = 1;
    for (int i = n; i >= 1; i--) {
        f *= i;
    }
    return f;
}

int main() {
    int d_x, d_y;
    int k_x, k_y;

    cin >> d_x >> d_y;
    cin >> k_x >> k_y;

    if (k_x > d_x || k_y > d_y) {
        cout << "fail" << endl;
    } else {
        cout << k_x + k_y << endl;

        int k_x_f = factorial(k_x);
        int k_y_f = factorial(k_y);
        int k_xy_f = factorial(k_x + k_y);

        cout << k_xy_f / (k_x_f * k_y_f) << endl;
    }

    return 0;
}