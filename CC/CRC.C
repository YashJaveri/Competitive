#include <stdio.h>
#include <string.h>

int main(){
    char genFunc[] = "1011";
    char mess[] = "110101";    
        
    int len = strlen(genFunc);

    for(int i=1; i<len; i++)
        strcat(mess, "0");    

    char *rem = divide(genFunc, mess);

    printf(rem);
    return 0;
}

char *divide(char genFunc[], char mess[]){
    char *test = "Hello";
    return  test;
}