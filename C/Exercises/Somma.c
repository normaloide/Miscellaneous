#include <stdio.h>

int main() {
	int n = 1;
	int sum = 0;
	while(n != 0) {
		scanf("%d", &n);
		sum += n;
	}
	
	printf("\n%d\n", sum);
	return 0;
}
