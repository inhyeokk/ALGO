/* 3-1
 * 2019.10.28
 */
#include <stdio.h>
#include <string.h>

int main() {
	int m, i, j;
	char str[50][101];
	char first, last;
	int index = 0;
	int len;
	scanf("%d", &m);
	for (i = 0; i < m; i++) {
		scanf("%s", str[i]);
	}
	len = strlen(str[0]);
	last = str[0][len - 1];
	for (i = 1; i < m; i++) {
		if (last != str[i][0]) {
			index = i + 1;
			printf("%d", index);
			return 0;
		}
		for (j = 0; j < i; j++) {
			if (strcmp(str[i], str[j]) == 0) {
				index = i + 1;
				printf("%d", index);
				return 0;
			}
		}
		len = strlen(str[i]);
		last = str[i][len - 1];
	}
	printf("%d", index);
	return 0;
}