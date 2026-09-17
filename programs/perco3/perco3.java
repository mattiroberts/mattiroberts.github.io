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

public class perco3 extends PApplet {


int[][] hor;
int[][] ver;
int[][] check;

public void setup() {
  size(600, 600);
  
  background(255);
  
  hor = new int[width][height];
  ver = new int[width][height];
  check = new int[width][height];
  
   for(int i=6; i<width-6; i+=6) {
    for(int j=6; j<height-6; j+=6) {
      hor[i+3][j]=PApplet.parseInt(random(2));
      stroke(255-255*hor[i+3][j]);
      line(i,j,i+6,j);
      ver[i][j+3]=PApplet.parseInt(random(2));
      stroke(255-255*ver[i][j+3]);
      line(i,j,i,j+6);
    }
  }
}

public void draw() {
  background(255);
  for(int i=6; i<width-6; i+=6) {
    for(int j=6; j<height-6; j+=6) {
      check[i][j]=0;
      if( random(1) <0.001f ) {
        hor[i+3][j]=PApplet.parseInt(random(2));
      }
      stroke(255-255*hor[i+3][j]);
      line(i,j,i+6,j);
      if( random(1) <0.001f ) {
        ver[i][j+3]=PApplet.parseInt(random(2));
      }
      stroke(255-255*ver[i][j+3]);
      line(i,j,i,j+6);
    }
  }
  noStroke();
  fill(255,0,0,127);
  rectMode(CENTER);
  rect(height/2,width/2,6,6);
  
  checkvertex(height/2,width/2,color(255,0,0,127));
  
  checkvertex(height/4,width/4,color(0,255,0,127));
  
  checkvertex(3*height/4,3*width/4,color(0,0,255,127));
  
  checkvertex(height/4,3*width/4,color(255,127,0,127));
  
  checkvertex(3*height/4,width/4,color(204,0,255,127));
}

public void checkvertex(int x, int y, int c) {
  noStroke();
  fill(c);
  rect(x,y,6,6);
  check[x][y]=1;
  
  if(hor[x+3][y]==1 && check[x+6][y]==0) {
    checkvertex(x+6,y,c);
  }
  if(ver[x][y-3]==1 && check[x][y-6]==0) {
    checkvertex(x,y-6,c);
  }
  if(hor[x-3][y]==1 && check[x-6][y]==0) {
    checkvertex(x-6,y,c);
  }
  if(ver[x][y+3]==1 && check[x][y+6]==0) {
    checkvertex(x,y+6,c);
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "perco3" });
  }
}
