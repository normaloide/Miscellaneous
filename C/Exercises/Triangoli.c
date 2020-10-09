#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int a = atoi(argv[1]);
	int b = atoi(argv[2]);
	int c = atoi(argv[3]);
	if(!(a < b + c && b < c + a && c < a + b)) {
		printf("This figure is not a triangle\n");
		return 0;
	}
	
	if(a == b && b == c) {                     //all sides must match
		printf("The triangle %d %d %d is equilateral\n", a, b, c);
		return 0;
	}
	
	if((a == b) != (b == c) != (c == a)) {     //XOR, only one pair matches
		printf("The triangle %d %d %d is isosceles\n", a, b, c);
		return 0;
	}
	
	printf("The triangle %d %d %d has not a defined shape\n", a, b, c);
	return 0;
}
