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

public class perco4 extends PApplet {


int[][] hor;
int[][] ver;
int[][] check;

public void setup() {
  size(400, 400);
  
  background(255);
  
  hor = new int[width][height];
  ver = new int[width][height];
  check = new int[width][height];
  
   for(int i=2; i<width-2; i+=2) {
    for(int j=2; j<height-2; j+=2) {
      hor[i+1][j]=PApplet.parseInt(random(2));
      stroke(255-255*hor[i+1][j]);
      line(i,j,i+2,j);
      ver[i][j+1]=PApplet.parseInt(random(2));
      stroke(255-255*ver[i][j+1]);
      line(i,j,i,j+2);
    }
  }
}

public void draw() {
  background(255);
  for(int i=2; i<width-2; i+=2) {
    for(int j=2; j<height-2; j+=2) {
      check[i][j]=0;
      if( random(1) <0.025f ) {
        hor[i+1][j]=PApplet.parseInt(random(2));
      }
      stroke(255-255*hor[i+1][j]);
      line(i,j,i+2,j);
      if( random(1) <0.025f ) {
        ver[i][j+1]=PApplet.parseInt(random(2));
      }
      stroke(255-255*ver[i][j+1]);
      line(i,j,i,j+2);
    }
  }
  noStroke();
  fill(255,0,0,127);
  rectMode(CENTER);
  rect(height/2,width/2,2,2);
  
  checkvertex(height/2,width/2,color(255,0,0,127));
  
  checkvertex(height/4,width/4,color(0,255,0,127));
  
  checkvertex(3*height/4,3*width/4,color(0,0,255,127));
  
  checkvertex(height/4,3*width/4,color(255,127,0,127));
  
  checkvertex(3*height/4,width/4,color(204,0,255,127));
}

public void checkvertex(int x, int y, int c) {
  noStroke();
  fill(c);
  rect(x,y,2,2);
  check[x][y]=1;
  
  if(hor[x+1][y]==1 && check[x+2][y]==0) {
    checkvertex(x+2,y,c);
  }
  if(ver[x][y-1]==1 && check[x][y-2]==0) {
    checkvertex(x,y-2,c);
  }
  if(hor[x-1][y]==1 && check[x-2][y]==0) {
    checkvertex(x-2,y,c);
  }
  if(ver[x][y+1]==1 && check[x][y+2]==0) {
    checkvertex(x,y+2,c);
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "perco4" });
  }
}
