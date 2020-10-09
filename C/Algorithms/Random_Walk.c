#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
	srand(time(NULL));
	char a[10][10] = {{'.'}, {'.'}};
	for(int i = 0; i < 10; i++) {
		for(int j = 0; j < 10; j++) {
			a[i][j] = '.';
		}
	}
	
	char c = 'B';
	int v = 0;
	int i = 0;
	int j = 0;
	a[i][j] = 'A';
	while(v == 0) {
		int rnd = rand()%4;
		switch(rnd) {
			case 0:
				if((i-1) >= 0 && a[i-1][j] == '.') {    //up
					a[i-1][j] = c;
					i--;
					c++;
					if(c > 'Z') {
						v = 1;
					}
				}
				
				break;
			
			case 1:
				if((i+1) <= 9 && a[i+1][j] == '.') {    //down
					a[i+1][j] = c;
					i++;
					c++;
					if(c > 'Z') {
						v = 1;
					}
				}
				
				break;
			
			case 2:
				if((j+1) <= 9 && a[i][j+1] == '.') {    //dx
					a[i][j+1] = c;
					j++;
					c++;
					if(c > 'Z') {
						v = 1;
					}
				}
				
				break;
			
			case 3:
				if((j-1) >= 0 && a[i][j-1] == '.') {    //sx
					a[i][j-1] = c;
					j--;
					c++;
					if(c > 'Z') {
						v = 1;
					}
				}
				
				break;
				
			default:
				break;
		}
		
		if(a[i-1][j] != '.' && a[i+1][j] != '.' && a[i][j-1] != '.' && a[i][j+1] != '.') {
			v = 1;
			break;
		}
	}
	
	for(int i = 0; i < 10; i++) {
		for(int j = 0; j < 10; j++) {
			printf("%c ", a[i][j]);
		}
		
		printf("\n");
	}
	
	return 0;
}
