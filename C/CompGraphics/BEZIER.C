#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<stdlib.h>
#include<dos.h>
#include<math.h>

void bezier(int x[4], int y[4]){
int i;
double t;

for(t = 0.0; t<1.0; t += 0.0005){
	double xt = pow(1-t, 3)*x[0] + 3*pow(1-t, 2)*pow(t, 1)*x[1]
		+ 3*pow(1-t, 1)*pow(t, 2)*x[2] + x[3]*pow(t,3);
	double yt = pow(1-t, 3)*y[0] + 3*pow(1-t, 2)*pow(t, 1)*y[1]
		+ 3*pow(1-t, 1)*pow(t, 2)*y[2] + y[3]*pow(t,3);
	putpixel(xt, yt, WHITE);
}
for(i=0; i<4; i++)
	putpixel(x[i], y[i], YELLOW);
}

void DDA(int x0, int x1, int y0, int y1){
int dx = x1-x0, i=0;
int dy = y1-y0;
int steps = abs(dx) > abs(dy) ? dx:dy;

float Xinc = dx/(float)steps, X = x0;
float Yinc = dy/(float)steps, Y = y0;

for(i=0; i<=abs(steps); i++){
	putpixel(X, Y, WHITE);
	X += Xinc;
	Y += Yinc;
}
}

void main(){
int x1[4] = {100, 200, 300, 350}, x2[4] = { 100, 200, 300, 350};
int y1[4] = {200, 350, 150, 150}, y2[4] = {200, 50, 250, 250};
int i, gm, gd=DETECT;
clrscr();

initgraph(&gd, &gm, "..\\bgi");

bezier(x1, y1);
bezier(x2, y2);
circle(130, 190, 4);
DDA(350, 350, 150, 250);
getch();
closegraph();
}