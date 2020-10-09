#include <stdio.h>
#include <math.h>

int main() {
	float r;
	printf("Choose a radius: ");
	scanf("%f", &r);
	printf("The area, for radius %.2f is equal to %f m^2\n", r, r*r*M_PI); 
	return 0;
}
