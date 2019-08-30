#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>

int direction(int difference)
{
    if(difference > 0)
	return 1;
    else if(difference < 0)
	return -1;
    else
	return 0;
}

void bress(int x0, int y0, int x1, int y1){
int i, p, x, y, temp, s1, s2, swap, dx, dy;

x=x0;
y=y0;

s1 = direction(x1-x0);
s2 = direction(y1-y0);

dx = abs(x1-x0);
dy = abs(y1-y0);

swap = 0;

if(dx>dy){
   temp=dx;
   dx=dy;
   dy=temp;
   swap=1;
}

p = 2*dy - dx;

for(i=0; i<=dx; i++){
	putpixel(x, y, WHITE);
	while(p>=0){
		p = p-2*dx;
		if(swap)
			x+=s1;
		else
			y+=s2;
	}
	p=p+2*dy;
	if(swap)
		y+=s2;
	else
		x+=s1;
}
}

void midCircle(int xc, int yc, int r){
int xk, yk, i, p;

p=1-r;
xk=0;
yk=r;

while(xk<=yk){
		putpixel(xc+xk,yc+yk,RED);
		putpixel(xc+xk,yc-yk,RED);
		putpixel(xc-xk,yc-yk,RED);
		putpixel(xc-xk,yc+yk,RED);
		putpixel(xc+yk,yc+xk,RED);
		putpixel(xc+yk,yc-xk,RED);
		putpixel(xc-yk,yc+xk,RED);
		putpixel(xc-yk,yc-xk,RED);
		xk=xk+1;
		if(p>=0){
			p = p+2*xk-2*yk+3;
			yk-=1;
		}
		else
			p = p+2*xk+1;
}
}

void main(){
int gd=DETECT, gm;
    int i,j,r=30;
    char number[2];

    initgraph(&gd, &gm, "..\\bgi");
    i=0;

    while(!kbhit())
    {
	cleardevice();
	//bress(100, 100, 200, 200);
	midCircle(200,200,50);
	outtextxy(240, 200, "3");
	outtextxy(199, 235, "6");
	outtextxy(160, 200, "9");
	outtextxy(195, 155, "12");

	line(200,200,200+(int)(r*cos(i*M_PI/180)),200+(int)(r*sin(i*M_PI/180)));
	line(200,200,200+(int)(r/3*cos(i/60*M_PI/180)),200+(int)(r/3*sin(i/60*M_PI/180)));
	i+=6;
	delay(100);
    }
    getch();
    closegraph();
}
