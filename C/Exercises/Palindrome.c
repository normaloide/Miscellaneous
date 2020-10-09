#include <stdio.h>
#include <string.h>

int main() {
	char a[100];
	scanf("%s", a);
	int len = strlen(a) - 1;
	
	int i = 0;
	while(a[i]) {
		a[i] = toupper(a[i]);
		i++;
	}
	
	i = 0;
	while(len > 0) {
		if(a[len] != a[i]) {
			printf("%s is not palindrome\n", a);
			return 0;
		}
		
		i++;
		len--;
	}
	
	printf("%s is palindrome\n", a);
	return 0;
}
