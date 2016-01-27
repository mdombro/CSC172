#include <stdio.h>

int main() {
  FILE *ptr;
  char buf[1000];
  int i = 0;
  char letters[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  int count[26] = { 0 };
  int o = 0;

  ptr = fopen("part3.txt","r");

  if (!ptr) {
    return 1;
  }

  while (fgets(buf, 1000, ptr) != NULL) {
    printf("%s", buf);
    while (buf[i] != 0) {
      if (buf[i] < 97) {
        buf[i] = buf[i]+32; //uppercase to lower
      }
      if (buf[i] >= 97 || buf[i] <= 122) {
        count[buf[i]-97]++;
      }
      i++;
    }
    i = 0;
  }

  for (o = 0; o < 26; o++) {
    printf("%c : %d\n", letters[o], count[o]);
  }


  fclose(ptr);

  return 0;
}
