#include <stdio.h>
#include <stdlib.h>

#define N 1000

void show(int a[], int l) {
	for(int i = 0; i < l; i++) {
		printf("%d ", a[i]);
	}
}

void invert(int a[], int i, int j) {
	int tmp = a[i];
	a[i] = a[j];
	a[j] = tmp;
}

void selectionsort(int a[], int n) {
	if(n > 0) {
		int k = 0;
		for(int i = 1; i < n; i++) {
			if(a[k] < a[i]) {
				k = i;
			}
		}
		
		invert(a, k, n-1);
		selectionsort(a, n-1);
	}
}

void mergesort(int a[], int sx, int dx) {
	int b[sx], c[dx];
	for(int i = 0; i < dx; i++) {
		b[i] = a[i];
		c[i] = a[i+dx-1];
	}
	
	selectionsort(b, sx);
	selectionsort(c, dx);
	
	int i1 = 0;
	int i2 = 0;
	int k = 0;
	while(i1 < sx && i2 < dx) {
		if(b[i1] <= c[i2]) {
			a[k] = b[i1];
			i1++;
		}
		
		else {
			a[k] = c[i2];
			i2++;
		}
		
		k++;
	}
	
	if(i1 < sx) {
		for(int j = i1; j < sx; j++) {
			a[k] = b[j];
			k++;
		}
	}
	
	else {
		for(int j = i2; j < dx; j++) {
			a[k] = c[j];
			k++;
		}
	}
}

int main() {
	srand(time(NULL));
	int a[N];
	for(int i = 0; i < N; i++) {
		a[i] = rand() % 101;
	}
	
	show(a, N);
	
	int q = 0;
	while(q == 0) {
		printf("\nSelection Sort or Merge Sort (S/M)? ");
		char c = getchar();
		switch(c) {
			case 'S': 
				selectionsort(a, N);
				q = 1;
				break;
			
			case 'M':
				mergesort(a, N/2, N-(N/2));
				q = 1;
				break;
				
			default:
				printf("Not valid input");
				getchar();
				break;
		}
	}
	
	show(a, N);
	printf("\n");
	return 0;
}
