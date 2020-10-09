#include <stdio.h>

int main() {
	float fahr;
	printf("Inserisci i gradi in Fahrenheit: ");
	scanf("%f", &fahr);
	float ce = (fahr - 32) * 5/9;
	printf("%f", ce);
	return 0;
}
