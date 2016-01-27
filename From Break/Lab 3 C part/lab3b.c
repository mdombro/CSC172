#include<stdio.h>

main()
{
    int temps_F[101];
    int i;
    for (i = -50; i < 101; i++) {
      printf("%d degrees Celsius - %d degrees Fahrenheit\n", i, i*(9/5)+32);
    }
}
