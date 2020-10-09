#include <stdio.h>

int main() {
	int a[100];
	int k = 0;
	while(k <= 99) {
		scanf("%d", &a[k]);
		if(a[k] == 0) {
			break;
		}
		k++;
	}
	
	for(int i = sizeof(a[0]); i >= 0; i--) {
		printf("\n%d", a[i]);
	}
	
	printf("\n");
}
