#include <stdio.h>
#include <ctype.h>

int main() {
	char c;
	int car[26] = {0};
	while(1) {
		c = toupper(getchar());
		if(c == '.') {
			break;
		}
		
		if(c >= 'A' && c <= 'Z') {
			car[c-'A']++;
		}
	}
	
	printf("\n");
	c = 'A';
	int i = 0;
	while(i < 26) {
		if(car[i] != 0) {
			printf("%c: ", c);
		}
		
		for(int j = 0; j < car[i]; j++) {
			printf("*");
		}	
		
		if(car[i] != 0) {
			printf("\n");
		}
		
		c++;
		i++;
	}
}
