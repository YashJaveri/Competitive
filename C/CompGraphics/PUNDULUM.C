#include<stdio.h>
#include<conio.h>
#include<graphics.h>

int direction(int difference)
{
    if(difference > 0)
	return 1;
    else if(difference < 0)
	return -1;
    else
	return 0;
}

void bress(int x0, int x1, int y0, int y1){
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
	p = p + 2*dy;
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

void flood(int x, int y, int new, int old){
int curr = getpixel(x, y);

if(curr==old){
	putpixel(x, y, new);
	delay(5);
	flood(x+1, y+1, new, old);
	flood(x, y+1, new, old);
	flood(x-1, y+1, new, old);
	flood(x+1, y-1, new, old);
	flood(x, y-1, new, old);
	flood(x-1, y-1, new, old);
	flood(x+1, y, new, old);
	flood(x-1, y, new, old);
}
}

void main(){
int gd=DETECT, gm, direct, j, k, i, xc=250, yc=25=, R=100, r=10;
clrscr();
initgraph(&gd, &gm, "..\\bgi");
for(i=0; i<=3; i++){
	direct=(i%2==0)?+1:(-1);
	for(j=0; j<=60; j++){
		cleardevice();
		midCircle(xc+R*direct*sin(j*3.142/180), yc+90*cos(j*3.142/18-), r);
		bress(xc, yc, xc+90*direct*sin(j*3.142/180), yc+90*cos(j*3.142/180));
		delay(20);
		for(k=60 ; k>0; k-){
			cleardevice();
			midCircle(xc+R*direct*sin(j*3.142/180), yc+90*cos(j*3.142/18-), r);
			bress(xc, yc,xc+90*direct*sin(j*3.142/180), yc+90*cos(j*3.142/180));
		}
	}
}