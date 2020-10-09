#include <stdio.h>
#include <string.h>
#include <math.h>

struct {
	int x[2];
	int y[2];
} punto;

struct {
	int a;
	int b;
} rettangolo;

struct {
	double r;
	int centro[2];
} cerchio;

int main() {
	printf("Choose the x coordinate: ");
	scanf("%d%d", &punto.x[0], &punto.x[1]);
	printf("Choose the y coordinate: ");
	scanf("%d%d", &punto.y[0], &punto.y[1]);
	
	rettangolo.a = abs(punto.x[0] - punto.y[0]);
	rettangolo.b = abs(punto.x[1] - punto.y[1]);
	int pr = (rettangolo.a * 2) + (rettangolo.b * 2);
	int arear = rettangolo.a * rettangolo.b;
	
	strncpy(cerchio.centro, punto.x, 2);
	cerchio.r = sqrt(pow((double)rettangolo.a, 2.0) + pow((double)rettangolo.b, 2.0));
	double p = cerchio.r * 2 * M_PI;
	double area = pow(cerchio.r, 2.0) * M_PI;
	
	char it;
	printf("Rettangolo o Cerchio? [r/c]  ");
	scanf(" %c", &it);
	
	if(it == 'r') {
		printf("\n%dm", pr);
		printf("\n%dm^2\n", arear);
		return 0;
	}
	
	if(it == 'c') {
		printf("\n%fm", p);
		printf("\n%fm^2\n", area);
		return 0;
	}
	
	else {
		printf("Input errato");
		return 0;
	}
}
