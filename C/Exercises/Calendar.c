#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int m = atoi(argv[1]);
	int d = atoi(argv[2]);
	switch(m) {
		case 2:
			m = 28;
			break;
		case 4:
			m = 30;
			break;
		case 6:
			m = 30;
			break;
		case 9:
			m = 30;
		case 11:
			m = 30;
			break;
		default:
			m = 31;
			break;
	}
	
	printf("\nM  T  W  T  F  S  S\n");
	for(int i = 1; i < m + d; i++) {
		if(i >= d) {
			if(i < 10 + d - 1) {
				printf("%d  ", (i - d + 1));
			}
			
			if(i >= 10 + d - 1) {
				printf("%d ", (i - d + 1));
			}
			
			if(i % 7 == 0) {
				printf("\n");
			}
		}
		
		else {
			printf("   ");
		}
	}
	
	printf("\n\n");
}
