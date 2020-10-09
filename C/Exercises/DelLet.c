#include <stdio.h>
#include <string.h>

int main() {
	char testo[100];
	
	for(int i = 0; i <= sizeof(testo)/sizeof(testo[0]); i++) {
		scanf("%c", &testo[i]);
		if(testo[i] == '\n') {
			break;
		}
	}
	
	int len = strlen(testo);
	char a = testo[len - 2];
	
	for(int i = 0; i < len; i++) {
		if(testo[i] == a) {
			testo[i] = 0;
		}
	}
	
	for(int i = 0; i < len; i++) {
		printf("%c", testo[i]);
	}
}
