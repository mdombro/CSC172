#include <stdio.h>

#define TRUE 1
#define FALSE 0
#define NULL 0
typedef int BOOLEAN;
typedef struct Node *List;

struct Node {
    int value;
    List *next;
};

void insert(int x, struct Node **pL) {
    if (*pL == NULL) {
        printf("Yo 1\n");
        (*pL) = (List)malloc(sizeof(struct Node));
        (*pL)->value = x;
        (*pL)->next = NULL;
    }
    else {
        printf("Yo 2\n");
        insert(x,&((*pL)->next));
    }
}

void printList(List L) {
    if (L != NULL) {
        printf("Element : %d \n", L->value);
        printList(L->next);
    }
}

BOOLEAN lookup (int x, List L) {
    if (L != NULL) {
        return FALSE;
    }
    else {
        if (x == L->value) {
            return TRUE;
        }
        else {
            return lookup(x, L->next);
        }
    }
}

int main() {
    struct List *head = (struct Node*)malloc(sizeof(struct Node));
    int i;
    for (i = 1; i < 20; i += 2)
        insert(i,&head);
    printList(head);
    printf("%d \n", lookup(17, head));
    return 0;
}
