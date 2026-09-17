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

public class circle_squares extends PApplet {


int[] tree;
float[][] treeposx;
float[][] treeposy;
float[] prob;
int treeheight;
int maxheight;
int maxbreadth;
float timestep;
int temp;
int temp2;
int temp3;
float tempf;

public void setup() {
  size(600,600);
  background(255);
  strokeWeight(0);
  
  treeheight=0;
  maxheight = 100;
  maxbreadth = 1000;
  timestep = 0.04f;
  
  tree = new int[maxheight+1];
  treeposx = new float[maxheight+1][maxbreadth+10];
  treeposy = new float[maxheight+1][maxbreadth+10];
  prob = new float[maxheight+1];
  
  tree[0] = 1;
  treeposx[0][0]=0.5f;
  treeposy[0][0]=0.5f;
  for( int i=0; i<=maxheight ; i++ ) {
    prob[i] = 1/(float)(i+1);
  }
  
  rectMode(CENTER);
  
}

public void draw() {
  for( int i=0 ; i<=treeheight ; i++ )
  {
    temp = tree[i];
    while( temp >= 4 )
    {
      if( random(1) < timestep*prob[i] )
      {
        temp2 = PApplet.parseInt(random(tree[i]));
        treeposx[i][temp2] = treeposx[i][tree[i]-1];
        treeposy[i][temp2] = treeposy[i][tree[i]-1];
        
        temp3 = PApplet.parseInt(random(tree[i]));
        while( temp3 == temp2 ) {
          temp3 = PApplet.parseInt(random(tree[i]));
        }
        treeposx[i][temp3] = treeposx[i][tree[i]-2];
        treeposy[i][temp3] = treeposy[i][tree[i]-2];
        
        temp2 = PApplet.parseInt(random(tree[i]));
        while( temp3 == temp2 ) {
          temp2 = PApplet.parseInt(random(tree[i]));
        }
        treeposx[i][temp2] = treeposx[i][tree[i]-3];
        treeposy[i][temp2] = treeposy[i][tree[i]-3];
        
        temp3 = PApplet.parseInt(random(tree[i]));
        while( temp3 == temp2 ) {
          temp3 = PApplet.parseInt(random(tree[i]));
        }
        treeposx[i][temp3] = treeposx[i][tree[i]-4];
        treeposy[i][temp3] = treeposy[i][tree[i]-4];
        
        treeposx[i-1][tree[i-1]] = random(1);
        treeposy[i-1][tree[i-1]] = random(1);
        tree[i] = tree[i]-4;
        tree[i-1]++;
        
      }
      temp = temp - 4;
    }
    temp = tree[i];
    while( temp > 0 )
    {
      if( random(1) < timestep*prob[i]/4 && i<maxheight && tree[i+1] <= maxbreadth -4)
      {
        treeposx[i+1][tree[i+1]] = random(1);
        treeposy[i+1][tree[i+1]] = random(1);
        treeposx[i+1][tree[i+1]+1] = random(1);
        treeposy[i+1][tree[i+1]+1] = random(1);
        treeposx[i+1][tree[i+1]+2] = random(1);
        treeposy[i+1][tree[i+1]+2] = random(1);
        treeposx[i+1][tree[i+1]+3] = random(1);
        treeposy[i+1][tree[i+1]+3] = random(1);
        tree[i]--;
        tree[i+1] = tree[i+1]+4;
        if( i==treeheight )
        {
          treeheight++;
        }
      }
      temp--;
    }
  }
  background(255);
  for( int i=0 ; i<=treeheight ; i++ ) {
    fill(255, max(255-30*max(i-1,0), 0), 0);
    for( int j=1 ; j<=tree[i] ; j++ )
    {
      rect(width*treeposx[i][j-1],height*treeposy[i][j-1],width*pow(2,-i)/sqrt(2),height*pow(2,-i)/sqrt(2));
    }
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "circle_squares" });
  }
}
