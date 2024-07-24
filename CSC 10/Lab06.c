/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/
//Youssef Boujebha
#include <stdio.h>

int main()
{
   int a = 0;
   int b = 1;
   int c = 1;
   
    printf("Enter positive (non zero) integer for factorial:\n");
    
    scanf("%d",&a);

   while(c <= a){
       b = b*c;
       c = c + 1;
   }
   
   if(a <= 0){
    printf("Choice must be greater than 0!\n");

}
    printf("!%d = %d",a,b);
    return 0;
}
