#include <stdio.h>
#include <string.h>

int main() {
	int data = 0;
	char utenti[100][40];
	int numeri[100];
	while(1) {
		int x;
		printf("\nDesideri:\n1 Aggiungere un numero alla rubrica\n2 Visualizzare la rubrica\n3 Uscire\n");
		scanf("%d", &x);
		switch(x) {
			case 1:
				printf("\n"); //devo tenerlo se no non posso inserire valori dopo il label
				int num;
				char nome[40];
				printf("Inserisci il nuovo numero di telefono: ");
				scanf("%d", &num);
				printf("A quale utente vuoi associare questo numero? ");
				scanf("%s", nome);
				
				strcpy(utenti[data], nome);
				numeri[data] = num;
				data++;

				break;
				
			case 2:
				for(int j = 0; j < data; j++) {
					printf("\n%s: %d", utenti[j], numeri[j]);
				}
				
				printf("\n");
				break;
				
			case 3:
				return 0;
				
			default:
				printf("\nScegli un numero tra 1 e 2!\n");
				break;
		}
	}
}
