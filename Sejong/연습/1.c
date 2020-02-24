/* 예제1
 * 1019.10.28
 */
#include <stdio.h>
#include <string.h> 
#include <stdlib.h>

int solution(char *arr) {

    int index = 0, i = 0;
    char a[7], b[7];
    int x, y;
    for (i = 0; i < 6; i++) {
        if (!(arr[i] >= '1' && arr[i] <= '9')) {
            index = i;
            break;
        }
    }
    strncpy(a, arr, index);
    strncpy(b, arr+index+1, 5-index);
    a[index] = '\0';
    b[5-index] = '\0';
    x = atoi(a);
    y = atoi(b);
    
    switch(arr[index]) {
        case '+':
            return x+y;
        case '-':
            return x-y;
        case '*':
            return x*y;
    }
}

int main() {
    printf("%d\n", solution("123+45")); // 168
    printf("%d", solution("34*100")); // 3
    return 0;
}