/* 2-1
 * 2019.10.28
 */
#include <stdio.h>
#include <string.h>

int main() {
	char str[9];
	int cnt = 0, i;
	scanf("%s", str);
	for (i = 0; i < 7; i++) {
		if (str[i] == '1') {
			cnt += 1;
		}
	}
	if (cnt % 2 == 0) {
		str[7] = '0';
		str[8] = '\0';
	}
	else {
		str[7] = '1';
		str[8] = '\0';
	}
	printf("%s", str);
	return 0;
}