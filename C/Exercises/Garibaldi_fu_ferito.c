#include <stdio.h>
#include <string.h>

int main() {
	char k;
	char c = 'A';
	printf("Stringa: ");
	scanf(" %c", &k);
	getchar();
	while(1) {
		c = getchar();
		if(c == '\n') {
			break;
		}
		
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			putchar(k);
		}
		
		else {
			putchar(c);
		}
	}
	
	printf("\n");
}
