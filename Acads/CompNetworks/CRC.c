#include<stdio.h>

    int* send(int a[],int b[], int m, int n){

        static int ans[15];
        int i, j;

	    for(i=0;i<=m-1;i++)
		    a[n+i]=0;        
        
        for(i=0; i<m; i++){
            ans[i] = a[i];
        }

        for(j=0; j<n; j++){
            if(ans[0]==1){
			    for(i=0;i<m;i++)
				    ans[i]=ans[i]^b[i];                                 
            }
		    else{
			    for(i=0;i<m;i++){
                    //printf("Before xor: %d", ans[i]);
				    ans[i]=ans[i]^0;
                    //printf("After xor: %d", ans[i]);
                }            
                //printf("\n");
            }        

            if(j != n-1)
            {
                //printf("j: %d\n", j);                
                ans[i] = a[m+j];
                //printf("m+j+1: %d\n", a[m+j]);
                for(i=0; i<=m; i++)
                    ans[i] = ans[i+1];
            }            
        }      
        return ans;
    }

void main(){
    int n,m,i,a[15],b[15],data[20],ans[10],sum=0;
    int *p, *q;
    printf("Enter the no. message bits\n");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	
	printf("Enter the no. of bits in generating function:\n");
	scanf("%d",&m);
	for(i=0;i<m;i++)
		scanf("%d",&b[i]);
	for(i=0;i<n;i++)
		data[i]=a[i];
	p=send(a,b,m,n);

	printf("\nThe remainder is: ");
	for(i=1;i<m;i++){
        data[n-1+i] = p[i];	
		printf("%d",p[i]);
    }		
	
    printf("\nThe sent message is: ");
	for(i=0;i<m+n-1;i++)
		printf("%d",data[i] );
}