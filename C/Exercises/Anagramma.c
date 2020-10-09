#include <stdio.h>
#include <ctype.h>

int main() {
	char c;
	int car1[26] = {0};
	int car2[26] = {0};
	int car3[26] = {0};
	while(1) {
		c = toupper(getchar());
		if(c == '.') {
			break;
		}
		
		if(c >= 'A' && c <= 'Z') {
			car1[c-'A']++;
		}
	}
	
	while(1) {
		c = toupper(getchar());
		if(c == '.') {
			break;
		}
		
		if(c >= 'A' && c <= 'Z') {
			car2[c-'A']++;
		}
	}
	
	for(int i = 0; i < 26; i++) {
		car3[i] += car1[i] + car2[i]; 
		
		if(car3[i]%2 != 0) {
			printf("La parola non e' anagramma\n");
			return 0;
		}
	}
	
	printf("La parola e' anagramma\n");
	return 0;
}
