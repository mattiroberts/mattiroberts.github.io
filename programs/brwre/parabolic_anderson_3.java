import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class parabolic_anderson_3 extends PApplet {

// Draws the lilypad limit for the Pareto BRWRE.

int[][] circol;
float epsilon = 1;
int xrad = 30;
int yrad = 30;
float[][] skyline;
float highest;
float[][] hit;
float maxhit;
float xscale;
float curtime;
float timestep = 0.001f;
int[][] active;
PFont arfont;

public float heightrv() {
  return (-1)*epsilon/log(random(1));
}

public void timer(int xpos, int ypos, float curtime)
{
  for( int i=0 ; i<= 2*xrad ; i++ ) {
    for( int j=0 ; j<= 2*yrad ; j++ ) {
      if( (hit[i][j] < 0.1f) || (hit[i][j] > curtime + epsilon*dist(i,j,xpos,ypos)/skyline[xpos][ypos]) ) {
        hit[i][j] = hit[xpos][ypos]+epsilon*dist(i,j,xpos,ypos)/skyline[xpos][ypos];
        if( skyline[i][j] > skyline[xpos][ypos] ) {
          timer(i,j,hit[i][j]);
          active[i][j]=1;
        }
        else {
          active[i][j]=0;
        }
      }
    }
  }
}

public void setup() {
  
  size(600, 600);
  background(255);
  
  arfont = loadFont("ArialMT-12.vlw"); 
  textFont(arfont); 
  
  rectMode(CENTER);
  
  xscale = 560/(2*(float)yrad+1);
  
  circol = new int[2*xrad+11][2*yrad+11];
  skyline = new float[2*xrad+11][2*yrad+11];
  hit = new float[2*xrad+11][2*yrad+11];
  active = new int[2*xrad+11][2*yrad+11];
  
  hit[xrad][yrad] = 1;
  active[xrad][yrad] = 1;
  
  noStroke();
  fill(0);
  for(int i=0; i<=2*xrad; i++) {
    for(int j=0; j<=2*yrad; j++) {
      circol[i][j] = color(random(255),random(255),random(255),40);
      skyline[i][j] = heightrv();
      highest = max(highest, skyline[i][j]);
    }
  }
  timer(xrad,yrad,1);
  for(int i=0; i<=2*xrad; i++) {
    for(int j=0; j<=2*yrad; j++) {
      maxhit = max(maxhit,hit[i][j]);
    }
  }

  for(int i=0; i<=2*xrad; i++) {
    for(int j=0; j<=2*yrad; j++) {
      if( hit[i][j] < 0.1f ) { fill(255,0,0); }
      else { fill(255-230*pow(skyline[i][j],0.3f)/pow(highest,0.3f)); }
      rect(20+xscale*i, 20+xscale*j, xscale, xscale);
    }
  }
}

public void draw() {
  background(255);
  noStroke();
  for(int i=0; i<=2*xrad; i++) {
    for(int j=0; j<=2*yrad; j++) {
      if( hit[i][j] < 0.1f ) { fill(255,0,0); }
      else { fill(255-230*pow(skyline[i][j],0.3f)/pow(highest,0.3f)); }
      rect(20+xscale*i, 20+xscale*j, xscale, xscale);
      
    }
  }
  stroke(0,0,0,40);
  for(int i=0; i<=2*xrad; i++) {
    for(int j=0; j<=2*yrad; j++) {
      if( (hit[i][j] < 1+curtime) && (active[i][j]==1) ) {
        fill(circol[i][j]);
        ellipse(20+xscale*i,20+xscale*j,2*xscale*skyline[i][j]*(curtime-hit[i][j]+1)/epsilon,2*xscale*skyline[i][j]*(curtime-hit[i][j]+1)/epsilon);
      }
    }
  }
  if( curtime > maxhit-1 ) { fill(0); text("The entire area was covered by time " + maxhit + ".", 4,12); }
  curtime += timestep;
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "parabolic_anderson_3" });
  }
}
