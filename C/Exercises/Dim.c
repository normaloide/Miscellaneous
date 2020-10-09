#include <stdio.h>
#include <limits.h>

int main() {
	printf("%d %d\n", sizeof(int), sizeof(long int));
	printf("%d %d %d %d %ld %ld %u %d %d\n", INT_MIN, INT_MAX, SHRT_MIN, SHRT_MAX, LONG_MIN, LONG_MAX, UINT_MAX, SCHAR_MIN, SCHAR_MAX);
	return 0;
}
