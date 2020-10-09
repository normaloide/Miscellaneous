#include <stdio.h>
#include <ctype.h>

int main() {
	char c;
	int value;
	printf("Inserisci un carattere: ");
	scanf("%c", &c);
	getchar();         /* posso fare così oppure scanf(" %c\n", &c);
					      altrimenti non legge un singolo carattere */
					      
	value = (int)tolower(c);
	if(value == 97 || value == 97 || value == 97 || value == 97 || value == 97) {
		printf("Il carattere %c, e' una vocale\n", c);
		return 0;
	}
	
	if(value >= 97 && value <= 122 && value != 106 && value != 107 && value != 119 && value != 120 && value != 121) {
		printf("Il carattere %c, e' una consonante\n", c);
		return 0;
	}
	
	else {
		printf("Il carattere %c non fa parte dell'alfabeto italiano\n", c);
		return 0;
	}
}
