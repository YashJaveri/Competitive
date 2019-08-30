#include<graphics.h>
#include<conio.h>
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

void main(){
int gd=DETECT, gm;
int x1[4] = {100, 150, 240 , 350};
int y1[4] = {100, 275, 300, 200};
int x2[4] = {100, 50, 300 , 350};
int y2[4] = {100, 350, 380, 200};
clrscr();
initgraph(&gd, &gm, "..\\bgi");

bezier(x1, y1);
bezier(x2, y2);
getch();
closegraph();
}