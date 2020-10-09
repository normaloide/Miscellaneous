#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char *argv[]) {
	int key = atoi(argv[1]);
	printf("Inserisci una stringa: ");
	char c;
	while(1) {
		c = getchar();
		if(c == '\n') {
			break;
		}
		
		if(isupper(c)) {
			printf("%c", (char)(c + key - 65) % 26 + 65);
		}
		
		if(islower(c)) {
			printf("%c", (char)(c + key - 97) % 26 + 97);
		}
	}
	
	printf("\n");
	return 0;
}
