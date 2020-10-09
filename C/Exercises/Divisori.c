#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int n = atoi(argv[1]);
	int count = 0;
	for(int i = n; i > 0; i--) {
		if(n%i == 0) {
			count++;
			printf("%d ", i);
		}
	}
	
	printf("\n");
	
	if(count == 2) {
		printf("The number is prime!\n");
	}
	
	else {
		printf("The number is not prime\n");
	}
	
	printf("\n");
}
