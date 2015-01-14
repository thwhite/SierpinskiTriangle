int bound, maxSize, xPos, yPos, zoom, xAxis, yAxis;

public void setup() {
	size(800, 800, P3D);
	background(255);
	bound = 5;
	xPos = 0;
	yPos = 750;
	maxSize = 6400;
	zoom = -2000;
	xAxis = 55;


	//translate(100, 100);
	//translate(width/2, height/2);
	
}
public void draw() {
	fill(0);
	background(255);
	rotateX(radians(xAxis));
	translate(0, 0, zoom);
	sierpinski(xPos, yPos, maxSize);
	
	System.out.println(zoom);
	//bound += 2;
}
public void mouseDragged() {//optional
}
public void sierpinski(int x, int y, int len) {
	//fill(  (int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)  );
	if (len > bound) {
		sierpinski(x, y, len/2);
		sierpinski(x + len/2, y, len/2);
		sierpinski(x + len/4, (int)(y - (len/2)*(sqrt(3)/2)), len/2);
	} else {
		triangle(x, y, x + len, y, x + len/2, y - (len)*(sqrt(3)/2));
	}
}
public void mousePressed() {
	if (mouseButton == LEFT && bound < maxSize) {bound *= 2;}
	if (mouseButton == RIGHT && bound > 1) {bound /= 2;}
	if (mouseButton == CENTER) {}
}
public void keyPressed() {
	if (key == 'd') {xPos -= 5;}
	if (key == 'a') {xPos += 5;}
	if (key == 's') {yPos -= 5;}
	if (key == 'w') {yPos += 5;}
	if (key == 'q') {zoom += 20;}
	if (key == 'e') {zoom -= 20;}
	if (key == 'r') {xAxis += 5;}
	if (key == 'f') {xAxis -= 5;}
}

/*sierpinski(x, y, x + len/2, y, x + len/4, y - (len/2)*(sqrt(3)/2));
		triangle(x + len/2, y, x + len, y, x + 3*len/4, y - (len/2)*(sqrt(3)/2));
		triangle(x + len/4, y - (len/2)*(sqrt(3)/2), x + 3*len/4, y - (len/2)*(sqrt(3)/2), x + len/2, y - (len)*(sqrt(3)/2));*/


// Zoom speed etc is attatched to how far you are scrolled out.