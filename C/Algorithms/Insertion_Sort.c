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
	
	for(int k = 1; k < 25; k++) {
		for(int i = 1; i < 25; i++) {
			int j = i-1;
			int x = a[i];
			while(j >= 0 && a[j] > x) {
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = x;
		}
	}
	
	printf("\n");
	for(int i = 0; i < 25; i++) {
		printf("%d ", a[i]);
	}
	
	printf("\n");
	return 0;
}
