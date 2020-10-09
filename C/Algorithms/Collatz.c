#include <stdio.h>

int collatz(int n) {
	if(n%2 == 0) {
		return n/2;
	}
	
	return (n*3)+1;
}

int main() {
	int n;
	int l = 1;
	printf("Choose a number: ");
	scanf("%d", &n);
	while(n != 1) {
		printf("%d ", n);
		n = collatz(n);
		l++;
	}
	
	printf("1\n%d\n", l);
}
