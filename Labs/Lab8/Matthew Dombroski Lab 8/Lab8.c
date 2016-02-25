/*  
 LAB8 CS172: C POINTERS
 Lab partners: Greg Hunkins and Matt Dombroski
 Programmer: Greg Hunkins
 */

#include <stdio.h>
#include <time.h>

#define false 0
#define true 1

int mystrcmp(char *s, char*t);
void mystrcat(char *dest, char *source);
int mystrlen(char *s);
void mystrcpy(char *s, char *dest);

int main(int argc, char * argv[]) {
    //PART 1: print out the command line arguments
    char hello[30] = "Hello ";
    for (int i = 0; i < argc; i++) {
        //PART 5: test the methods using hello
        if (mystrcmp(argv[i], "Greg") || mystrcmp(argv[i], "Matt")) {
            mystrcat(hello, argv[i]);
            printf("%d: %s\n", i, hello);
            mystrcpy("Hello ", hello);
            continue;
        }
        printf("%d: %s\n", i, argv[i]);
    }
    
    //TESTING
    
    //test the mystrcmp
    printf("Comparing cat and cat: %d\n", mystrcmp("cat", "cat"));
    printf("Comparing cat1 and cat: %d\n", mystrcmp("cat1", "cat"));
    printf("Comparing cat and cat1: %d\n", mystrcmp("cat", "cat1"));
    //test mystrcat
    char dest[50] = "fat";
    char source[50] = "cat";
    mystrcat(dest, source);
    printf("Concatenated 'fat' and 'cat'. Result is: %s\n", dest);
    //test mystrcpy
    mystrcpy(source, dest);
    printf("Testing copy method, copying 'cat' into 'fatcat': %s\n", dest);
    
    //PART 6: playing with integer arrays
    int a[10];
    for (int i = 0; i < 10; i++) {
        a[i] = i*i;
        printf("Array index %d: %d\n", i, *(a+i));
    }
    
}


// PART 2: implment a mystrcmp
int mystrcmp(char *s, char*t) {
    int i = 0;
    while (s[i] != '\0' && t[i] != '\0') {
        if (s[i] != t[i]) return false;
        i++;
    }
    if (s[i] == t[i]) return true;
    else return false;
}

// PART 3: implement a mystrcat
//this code assumes char array dest has been declared large
//enough to store both dest and source concatenated
void mystrcat(char *dest, char *source) {
    for (int i = 0; i < mystrlen(source); i++) {
        dest[mystrlen(dest)] = source[i];
    }
}

// PART 4: implement a mystrcpy
void mystrcpy(char *s, char *dest) {
    //clear the destination string
    int dest_len = mystrlen(dest);
    for (int j = 0; j < dest_len; j++) {
        dest[j] = '\0';
    }
    //copy s over into dest
    for (int i = 0; i < mystrlen(s); i++) {
        dest[i] = s[i];
    }
}

//didn't know if we could use the regular strlen, so I wrote my own
//relies on the convention of ending strings with '\0'
int mystrlen(char *s) {
    int length = 0;
    while (s[length] != '\0') {
        length++;
    }
    return length;
}
 