#include <stdio.h>

void scambia(int *p, int *q) {
	int tmp = *p;
	*p = *q;
	*q = tmp;
}

int main(int argc, char *argv[]) {
	int i = 1;
	int j = 2;
	scambia(&i, &j);
	printf("%d %d\n", i, j);
	return 0;
}
