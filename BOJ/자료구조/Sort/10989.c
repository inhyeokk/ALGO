// BOJ Sort 10989 수 정렬하기 3
#include <stdio.h>

int a[10001];

int main() {    
    int n, input, i;

    scanf("%d", &n);
    for(i = 0; i < n; i++) {
        scanf("%d", &input);
        a[input] += 1;
    }

    for(i = 0; i < 10001; i++) {
        while(a[i] != 0) {
            printf("%d\n", i);
            a[i] -= 1;
        }
    }
    return 0;
}