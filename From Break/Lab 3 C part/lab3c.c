#include <stdio.h>

int main() {
  FILE *ptr;
  char buf[1000];
  int i = 0;
  char vowels[] = {'a','e','i','o','u','A','E','I','O','U'};
  int o = 0;
  int vowel_count = 0;

  ptr = fopen("part3.txt","r");

  if (!ptr) {
    return 1;
  }

  while (fgets(buf, 1000, ptr) != NULL) {
    while (buf[i] != 0) {
        for (o = 0; o < 10; o++) {
          if (buf[i] == vowels[o]) {
            vowel_count++;
          }
        }
      i++;
    }
    i = 0;
    printf("%s", buf);
  }
  
  printf("There are %d vowels in the text file\n", vowel_count);

  fclose(ptr);

  return 0;
}
