public void setup() {
	size(800, 800);
	background(255);

}
public void draw() {
	fill(0);
	sierpinski(0, 750, 800);
}
public void mouseDragged() {//optional
}
public void sierpinski(int x, int y, int len) {
	fill(  /*(int)(Math.random()*255)*/ 0  );
	if (len > 5) {
		sierpinski(x, y, len/2);
		sierpinski(x + len/2, y, len/2);
		sierpinski(x + len/4, (int)(y - (len/2)*(sqrt(3)/2)), len/2);
	} else {
		triangle(x, y, x + len, y, x + len/2, y - (len)*(sqrt(3)/2));
	}
}


/*sierpinski(x, y, x + len/2, y, x + len/4, y - (len/2)*(sqrt(3)/2));
		triangle(x + len/2, y, x + len, y, x + 3*len/4, y - (len/2)*(sqrt(3)/2));
		triangle(x + len/4, y - (len/2)*(sqrt(3)/2), x + 3*len/4, y - (len/2)*(sqrt(3)/2), x + len/2, y - (len)*(sqrt(3)/2));*/