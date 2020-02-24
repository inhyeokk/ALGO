/* 2-2
 * 2019.10.28
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
	char str[8][9];
	int cnt = 0, i, j, eight = 0;

	for (i = 0; i < 7; i++) {
		scanf("%s", str[i]);
		cnt = 0;
		for (j = 0; j < 7; j++) {
			if (str[i][j] == '1') {
				cnt += 1;
			}
		}
		if (cnt % 2 == 0) {
			str[i][7] = '0';
			str[i][8] = '\0';
		}
		else {
			str[i][7] = '1';
			str[i][8] = '\0';
		}
	}

	for (i = 0; i < 8; i++) {
		cnt = 0;
		for (j = 0; j < 7; j++) {
			if (str[j][i] == '1') {
				cnt += 1;
			}
		}
		if (cnt % 2 == 0) {
			str[7][i] = '0';
		}
		else {
			str[7][i] = '1';
		}
	}
	str[7][8] = '\0';

	for (i = 0; i < 8; i++) {
		printf("%s\n", str[i]);
	}
	
	return 0;
}