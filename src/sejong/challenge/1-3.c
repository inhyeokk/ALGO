/* 1-3
 * 20/100
 * 2019.10.28
 */
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, i, j, cnt = 0;
	int arr[201], brr[201], check[201];
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
		brr[i] = 0;
		check[i] = 0;
	}

	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			if (check[i] == 0 && check[j] == 0 && (arr[i] * 3 / 4) == arr[j]) {
				brr[cnt] = arr[j];
				cnt += 1;
				check[i] = 1;
				check[j] = 1;
			}
		}
	}

	for (i = 0; i < n; i++) {
		for (j = 0; j < cnt; j++) {
			if (arr[i] == brr[j]) {
				printf("%d ", arr[i]);
				break;
			}
		}
	}
	return 0;
}