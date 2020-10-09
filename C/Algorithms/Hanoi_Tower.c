#include <stdio.h>

/**
* If we (for example) start with n = 2, n == 1 is ignored, it goes to hanoi(n-1, from, a, to) and
* moves to the recursive branch where n = 1, so it prints "1 from A to B" (we switched "to" with "a"),
* then it returns. Then it exits the branch and it executes the printf as it follows: "2 (the initial branch)
* from A to C (the initial "from" and "to")". In the end it does the same thing as the beginning but the new "from"
* is the beginner "a": 1 from B to C. The program can now finally end.

* Resuming: the program will create n branches for each branch. Every branch if n == 1 will end, else it
* will create the same amount of branches till n == 1 is reached for each node, then it terminates.
*/

void hanoi(int n, char from, char to, char a) {
	if(n == 1) {
		printf("\n%d from %c to %c", n, from, to);
		return;
	}
	
	hanoi(n-1, from, a, to);
	printf("\n%d from %c to %c", n, from, to); 
	hanoi(n-1, a, to, from);
}

int main(int argc, char *argv[]) {
	int n = atoi(argv[1]);           //number of plates
	hanoi(n, 'A', 'C', 'B');         //executes hanoi
	printf("\n");
	return 0;
}
