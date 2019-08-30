#include<sys/types.h>
#include<unistd.h>
#include<stdlib.h>
#include<stdio.h>

int main(){
    pid_t cpid=0;
    if(fork()==0){
        printf("In child process\n");
        printf("Exiting..\n");
        exit(0);
    }
    else{
        printf("In Parent Process\n");
        cpid=wait(NULL);
    }
    printf("Parent Process: %d\n", getpid());
    printf("Child Process: %d\n", cpid);
    return 0;
}