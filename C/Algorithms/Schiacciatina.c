#include <stdio.h>
#include <math.h>

int main() {
	int r, c;
	printf("Inserisci il numero di righe dell'array: ");
	scanf("%d", &r);
	printf("Inserisci il numero di colonne dell'array: ");
	scanf("%d", &c);
	char a[r][c];
	int r1 = r;
	int c1 = c;
	while(r1 > 0) {
		while(c1 > 0) {
			printf("Inserisci valore [%d, %d]: ", abs(r1-r), abs(c1-c));
			scanf(" %c", &a[abs(r1-r)][abs(c1-c)]);
			c1--;
		}
		
		c1 = c;
		r1--;
	}
	
	printf("\n");
	for(int i = 0; i < r; i++) {
		for(int j = 0; j < c; j++) {
			printf("%c ", a[i][j]);
		}
		
		printf("\n");
	}
	
	for(int k = 0; k <= sqrt(r); k++) {
		for(int i = r-1; i >= 0; i--) {
			for(int j = c-1; j >= 0; j--) {
				if(a[i+1][j] == '*') {
					a[i+1][j] = a[i][j];;
					a[i][j] = '*';
				}
			}
		}
	}
	
	printf("\n");
	for(int i = 0; i < r; i++) {
		for(int j = 0; j < c; j++) {
			printf("%c ", a[i][j]);
		}
		
		printf("\n");
	}
	
	return 0;
}
