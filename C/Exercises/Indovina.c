#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
	int false = 1;
	char car;
	int max = 1000;
	int min = 0;
	srand(time(NULL));
	int b = (rand() % (max - min + 1)) + min;
	while(false == 1) {
		printf("Il numero e' %d? ", b);
		scanf(" %c", &car);
		if(car == '=') {
			printf("SONO UN COMPUTER INTELLIGENTE\n");
			false = 0;
			return 0;
		}
		
		if(car == '>') {
			min = b + 1;
			srand(time(NULL));
			b = (rand() % (max - min + 1)) + min;
		}
		
		if(car == '<') {
			max = b - 1;
			srand(time(NULL));
			b = (rand() % (max - min + 1)) + min;
		}
	}
}
