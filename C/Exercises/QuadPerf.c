#include <stdio.h>
#include <math.h>

#define MAX 10

int main() {
	for(int i = 0; i < MAX; i++) {
		printf("%.f\n", pow((double)i, 2.));
	}
	
	return 0;
}
