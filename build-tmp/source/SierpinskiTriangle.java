import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

int bound, maxSize, xPos, yPos, zoom, xAxis, yAxis, zoomMod;
boolean menu, display, starWars;

public void setup() {
	size(900, 900, P3D);
	background(255);
	bound = 1000;
	xPos = -15000;
	yPos = 3200;
	maxSize = 6400;
	zoom = -5490;
	xAxis = 0;

	menu = true;
	display = false;
	starWars = false;
	frameRate(5);
	
	
}
public void draw() {
	if (menu) {
		background(255);
		textSize(80);
		stroke(0);
		fill(0);
		text("CONTROLS", width/2, 200);
		textSize(20);
		textAlign(CENTER);
		text("Left Mouse Button to simplify figure, Right to add more triangles.", width/2, 300);
		text("WASD to move the screen.", width/2, 400);
		text("Q/E to zoom in and out.", width/2, 500);
		text("R/F to rotate triangle away from you.", width/2, 600);
		text("===Press Space to continue.===", width/2, 700);

	} else if (display) {
		
		background(255);

		if (starWars) {
			xAxis = 65;
			zoom = -300;
			yPos -= 100;
			background(0);
		}

		zoomMod = zoom/4;
		if (zoom > 500) {zoom = 500;}
		if (zoom < -16000) {zoom = -4000;}

		rotateX(radians(xAxis));
		
		translate(0, 0, zoom);
		sierpinski(xPos, yPos, maxSize);
	
		
	}
	
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
		if (Math.random() > 0.99f) {
			fill( (int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255) );
		}
		triangle(x, y, x + len, y, x + len/2, y - (len)*(sqrt(3)/2));
	}
}
public void mousePressed() {
	if (mouseButton == LEFT && bound < maxSize) {bound *= 2;}
	if (mouseButton == RIGHT && bound > 1) {bound /= 2;}
	if (mouseButton == CENTER) {}
}
public void keyPressed() {
	if (key == 'd') {xPos -= zoomMod;}
	if (key == 'a') {xPos += zoomMod;}
	if (key == 's') {yPos -= zoomMod;}
	if (key == 'w') {yPos += zoomMod;}
	if (key == 'q') {zoom += 20;}
	if (key == 'e') {zoom -= 20;}
	if (key == 'r') {xAxis += 5;}
	if (key == 'f') {xAxis -= 5;}
	if (keyCode == 32) {menu = !menu; display = !menu; 
		bound = 1000;
		xPos = -3000;
		yPos = 3200;
		maxSize = 6400;
		zoom = -5490;
		xAxis = 0;
		starWars = false;
		//popMatrix();
	}
	if (key == 'z') {pushMatrix(); starWars = !starWars;}
	if (key == 'x') {popMatrix();}
}

/*sierpinski(x, y, x + len/2, y, x + len/4, y - (len/2)*(sqrt(3)/2));
		triangle(x + len/2, y, x + len, y, x + 3*len/4, y - (len/2)*(sqrt(3)/2));
		triangle(x + len/4, y - (len/2)*(sqrt(3)/2), x + 3*len/4, y - (len/2)*(sqrt(3)/2), x + len/2, y - (len)*(sqrt(3)/2));*/


// Zoom speed etc is attatched to how far you are scrolled out.
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
