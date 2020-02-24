// BOJ sort 2751 수 정렬하기2
#include <stdio.h>

int sorted[1000001];

void merge(int arr[], int m, int middle, int n) {
    int i = m;
    int j = middle + 1;
    int k = m;

    // 작은 순서대로 삽입
    while (i <= middle && j <= n) {
        if(arr[i] <= arr[j]) {
            sorted[k] = arr[i];
            i++;
        } else {
            sorted[k] = arr[j];
            j++;
        }
        k++;
    }

    // 남은 데이터도 삽입
    if (i > middle) {
        for (int t = j; t <= n; t++) {
            sorted[k] = arr[t];
            k++;
        }
    } else {
        for(int t = i; t <= middle; t++) {
            sorted[k] = arr[t];
            k++;
        }
    }
    
    // 정렬된 배열을 삽입
    for (int t = m; t <= n; t++)
        arr[t] = sorted[t];
}

void mergeSort(int arr[], int m, int n) {
    // 크기가 1보다 큰 경우
    if (m < n) {
        int middle = (m + n) / 2;
        mergeSort(arr, m, middle); // 분할
        mergeSort(arr, middle+1, n);
        merge(arr, m, middle, n); // 정렬
    }
}

int main() {
    int num;
    int arr[1000001];

    scanf("%d", &num);
    
    for(int i = 0; i < num; i++)
        scanf("%d", &arr[i]);

    mergeSort(arr, 0, num-1);

    for(int i = 0; i < num; i++)
        printf("%d\n", arr[i]);
        
    return 0;
}