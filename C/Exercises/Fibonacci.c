#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int fib = atoi(argv[1]);
	int count = 2;
	unsigned long long int *a = (unsigned long long int *) malloc(sizeof(unsigned long long int));
	unsigned long long int *b = (unsigned long long int *) malloc(sizeof(unsigned long long int));
	unsigned long long int *c = (unsigned long long int *) malloc(sizeof(unsigned long long int));
	*a = 1;
	*b = 1;
	printf("%d\n%d\n", *a, *b);
	for(int i = 3; i <= fib; i++) {
		*c = *a + *b;
		*a = *b;
		*b = *c;
		printf("%llu\n", *c);
	}
	
	free(a);
	free(b);
	free(c);
	
	return 0;
}
