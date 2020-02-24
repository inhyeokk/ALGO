// BOJ Sort 2752 세수정렬
#include <stdio.h>

int main() {
    int data[3];
    int i, j, temp;

    for(i = 0; i < 3; i++)
        scanf("%d", &data[i]);

    for(i = 0; i < 2; i++) {
        for(j = 0; j < 2-i; j++) {
            if(data[j] > data[j+1]) {
                temp = data[j];
                data[j] = data[j+1];
                data[j+1] = temp;
            }
        }
    }

    for(i = 0; i < 3; i++)
        printf("%d ", data[i]);
    return 0;
}