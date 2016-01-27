#include <stdio.h>

int factorial(int n) {
  if (n == 1)
    return 1;
  return n*factorial(n-1);
}

int power(int n, int k) {
  if (k == 0)
    return 1;
  return n*power(n, k-1);
}

int main() {
  int n = factorial(5);
  printf("%d\n",n);
  printf("%d\n", power(10, 10));
}
