#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 100

typedef enum Bool {false, true} Bool;

struct Node {
    int key;
    char data[SIZE];
    struct Node* next;
};

struct Node* addHead(struct Node* n, int value, char s[]) {
    struct Node* new_head = malloc(sizeof(struct Node));
    new_head->key = value;
    for (int i = 0; i < SIZE; i++) {
        new_head->data[i] = s[i];
    }
    new_head->next = n;

    return new_head;
}

void printListNoLast(struct Node* n) {
    while (n->next != NULL) {
        printf("%d %s\n", n->key, n->data);
        n = n->next;
    }
}

struct Node* searchNode(struct Node* n, int value) {
    while (n != NULL && n->key != value) {
        n = n->next;
    }

    return n;
}

int main(void) {
    struct Node* first = malloc(sizeof(struct Node));
    first->key = NULL;
    for (int i = 0; i < SIZE; i++) {
        first->data[i] = NULL;
    }
    first->next = NULL;

    int x;
    char s[SIZE];
    Bool bool = true;
    while (bool) {
        scanf("%d, %s", &x, s);
        if (strcmp(s, "end") != 0) {
            first = addHead(first, x, s);
        } else {
            bool = false;
        }
    }

    printf("\n");
    printListNoLast(first);
    printf("\n");

    struct Node* result = searchNode(first, 3);
    printf("%s", result->data);

    return 0;
}
