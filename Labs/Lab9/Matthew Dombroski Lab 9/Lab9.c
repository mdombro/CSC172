#include <stdio.h>

#define TRUE 1
#define FALSE 0
#define NULL 0
typedef int BOOLEAN;

struct Node {
    int value;
    struct Node **next;
};

void insert(int x, struct Node **pL) {
    if ((*pL) == NULL) {
        (*pL) = (struct Node*)malloc(sizeof(struct Node*));
        (*pL)->value = x;
        (*pL)->next = NULL;
    }
    else {
        insert(x,&((*pL)->next));
    }
}

void printList(struct Node *L) {
    if (L != NULL) {
        printf("Element : %d \n", L->value);
        printList(L->next);
    }
}

BOOLEAN lookup (int x, struct Node *L) {
    if (L == NULL) {
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

void delete(int x, struct Node **pL) {
    if ((*pL) != NULL) {
        if (x == (*pL)->value) {
            (*pL) = (*pL)->next;
            //free((*pL)->next);
        }
        else {
            delete(x, &((*pL)->next));
        }
    }
}

int main() {
    struct Node **head = (struct Node*)malloc(sizeof(struct Node));
    int i;
    for (i = 1; i < 20; i += 2)
        insert(i,&head);

    printf("Filled linked list: \n");
    printList(head);

    printf("\nCan we lookup elements in the list?  \n");
    for (i = 0; i < 20; i++)
        printf("%d %s FOUND\n",i,((lookup(i,head) == TRUE) ? "": "NOT"));

    for (i = 0; i < 20; i += 3)
        delete(i,&head);
    printf("\nList after deleting every other element: \n");
    printList(head);
    return 0;
}
