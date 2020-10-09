#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 7

void max_secondmax(int a[], int n, int *max, int *second_max) {
	int s = 1;
	int i = 0;
	while(s && i < n) {
		s = 0;
		for(int j = 1; j < n-i; j++) {
			if(a[j] < a[j-1]) {
				int x = a[j];
				a[j] = a[j-1];
				a[j-1] = x;
				s = 1;
			}
		}
		
		i++;
	}
	
	*max = a[n-1];
	*second_max = a[n-2];
}

int main() {
	srand(time(NULL));
	int a[N];
	printf("\n");
	for(int i = 0; i < N; i++) {
		a[i] = rand()%100 + 1;
		printf("%d ", a[i]);
	}
	
	int max, second_max;
	max_secondmax(a, N, &max, &second_max);
	
	printf("\n\nmax: %d\nsecond max: %d\n", max, second_max);
	
	return 0;
}
