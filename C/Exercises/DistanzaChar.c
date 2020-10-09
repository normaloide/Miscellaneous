#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, char *argv[]) {
	printf("%d\n", abs(*argv[1] - *argv[2]));
}
