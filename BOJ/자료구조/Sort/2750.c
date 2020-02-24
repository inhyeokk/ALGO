// BOJ sort 2750 수 정렬하기
#include <stdio.h>

int main() {
    int data[1001];
    int n, i, j, temp;

    scanf("%d", &n);

    for(i = 0; i < n; i++)
        scanf("%d", &data[i]);

    for(i = 0;i < n-1; i++) {
        j = i;
        while(data[j] > data[j+1]) {
            temp = data[j];
            data[j] = data[j+1];
            data[j+1] = temp;
            j--;
        }
    }

    for(int i = 0; i < n; i++)
        printf("%d\n", data[i]);

    return 0;
}