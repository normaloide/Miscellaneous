#include <stdio.h>
#include <math.h>

int main() {
	int base, n;
	int value = 0;
	int i = 0;
	printf("Inserisci una base b e un numero da convertire: ");
	scanf(" %d%d", &base, &n);
	while(n > 0) {
		value += (n%10)*pow((double)base, (double)i);
		n /= 10;
		i++;
	}

	printf("%d\n", value);
	return 0;
}
