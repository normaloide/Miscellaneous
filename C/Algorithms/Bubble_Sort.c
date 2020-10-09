#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
	srand(time(NULL));
	int a[25] = {0};
	for(int i = 0; i < 25; i++) {
		a[i] = rand()%101;
		printf("%d ", a[i]);
	}
	
	int s = 1;
	int i = 0;
	while(s && i < 25) {
		s = 0;
		for(int j = 1; j < 25-i; j++) {
			if(a[j] < a[j-1]) {
				int x = a[j];
				a[j] = a[j-1];
				a[j-1] = x;
				s = 1;
			}
		}
		
		i++;
	}
	
	printf("\n");
	for(int i = 0; i < 25; i++) {
		printf("%d ", a[i]);
	}
	
	printf("\n");
	return 0;
}
