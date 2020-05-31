#include <stdio.h>
#include <string.h>

char* divide(char genFunc[], char mess[]){
    int i=0;
    int messLen = strlen(mess);
    int genFunc = strlen(genFunc);
    
    while(i<messLen){
        
    }
    return  mess;
}

int main(){
    char genFunc[] = "1011";
    char mess[] = "110101";    
        
    int len = strlen(genFunc);

    for(int i=1; i<len; i++)
        strcat(mess, "0");    

    char* rem = divide(genFunc, mess);

    //printf("%s", rem);
    return 0;
}