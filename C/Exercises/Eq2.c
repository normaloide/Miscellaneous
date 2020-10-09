#include <stdio.h>
#include <math.h>

int main() {
	int a, b, c;
	double delta, result1, result2;
	printf("Data l'equazione ax^2 + bx + c, scegliere gli argomenti\n");
	printf("a: ");
	scanf("%d", &a);
	printf("b: ");
	scanf("%d", &b);
	printf("c: ");
	scanf("%d", &c);
	delta = pow((double)b, 2) - (4*(a)*(c));
	if(delta < 0) {
		delta = delta - (delta*2);
		result1 = (-(double)b + sqrt(delta))/(2*(double)a);
		result2 = (-(double)b - sqrt(delta))/(2*(double)a);
		printf("%fi\n", result1);
		printf("%fi\n", result2);
	}
	
	else {
		result1 = (-(double)b + sqrt(delta))/(2*(double)a);
		result2 = (-(double)b - sqrt(delta))/(2*(double)a);
		printf("%f\n", result1);
		printf("%f\n", result2);
	}
	
	return 0;
}
