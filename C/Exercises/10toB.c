#include <stdio.h>
 
int main() {
	int n, b;
	int v[100];
	int k = 0;
	scanf("%d%d", &n, &b);
	while(n > 0) {
		v[k] = n%b;
		n = n/b;
		k++;
	}
	
	for(int i = k - 1; i >= 0; i--) {
		printf("%d", v[i]);
	}
	
	printf("\n");
	return 0;
}
