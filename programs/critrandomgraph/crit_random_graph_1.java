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

public class crit_random_graph_1 extends PApplet {


int noverts;
int noedges;
int edge[][];
float angle;
float xpos[];
float ypos[];
float radius;
int comp1[];
int getc1[];
int temp;
float timestep;
int greentime;
int time;
PFont arfont;

public void setup()
{
  size(600, 600);
  background(255);
  arfont = loadFont("ArialMT-12.vlw"); 
  textFont(arfont); 
  radius = 280;
  timestep = 0.01f;
  noverts = 501;
  noedges = (noverts * (noverts - 1)) / 2;
  edge = new int[noverts+1][noverts+1];
  xpos = new float[noverts+1];
  ypos = new float[noverts+1];
  comp1 = new int[noverts+1];
  getc1 = new int[noverts+1];
  time=0;
  greentime=0;
  
  for( int i=1 ; i<= noverts ; i++ )
  {
    for( int j=1 ; j<i ; j++ )
    {
      if( random(1) < 1 / (float)noverts )
      {
        edge[i][j]=1;
      }
    }
  }
  
  strokeWeight(6);
  for( int i=1 ; i<=noverts ; i++ )
  {
    angle = (i-1)*2*PI / (float)noverts;
    xpos[i] = width/2 + radius*sin(angle);
    ypos[i] = height/2 - radius*cos(angle);
    point(xpos[i],ypos[i]);
  }
  
  strokeWeight(2);
  for( int i=1 ; i<= noverts ; i++ )
  {
    for( int j=1 ; j<i ; j++ )
    {
      if( edge[i][j]==1 )
      {
        line(xpos[i],ypos[i],xpos[j],ypos[j]);
      }
    }
  }
}

public void draw()
{
  background(255);
  stroke(0);
  for( int i=1 ; i<=noverts ; i++ )
  {
    getc1[i]=0;
    comp1[i]=0;
  }
  
  for( int i=1 ; i<= noverts ; i++ )
  {
    for( int j=1 ; j<i ; j++ )
    {
      if( random(1) < timestep )
      {
        if( random(1) < 1 / (float)noverts )
        {
          edge[i][j]=1;
        }
        else
        {
          edge[i][j]=0;
        }
      }
    }
  }
  strokeWeight(6);
  for( int i=1 ; i<=noverts ; i++ )
  {
    angle = (i-1)*2*PI / (float)noverts;
    xpos[i] = width/2 + radius*sin(angle);
    ypos[i] = height/2 - radius*cos(angle);
    point(xpos[i],ypos[i]);
  }
  
  strokeWeight(2);
  for( int i=1 ; i<= noverts ; i++ )
  {
    for( int j=1 ; j<i ; j++ )
    {
      if( edge[i][j]==1 )
      {
        line(xpos[i],ypos[i],xpos[j],ypos[j]);
      }
    }
  }
  
  stroke(255,0,0);
  strokeWeight(4);
  getc1[1]=1;
  comp1[1]=1;
  temp=2;
  
  for( int i=1 ; i<=noverts ; i++ )
  {
    if( getc1[i]>0 )
    {
      for( int j=1 ; j<=noverts ; j++ )
      {
        if( edge[getc1[i]][j]==1 || edge[j][getc1[i]]==1 )
        {
          line(xpos[getc1[i]],ypos[getc1[i]],xpos[j],ypos[j]);
          if( comp1[j]==0 )
          {
            comp1[j]=1;
            getc1[temp]=j;
            temp++;
          }
        }
      }
    }
  }
  
  if( comp1[2]==1 )
  {
    greentime++;
    temp=2;
    stroke(0,255,0);
    for( int i=1 ; i<=noverts ; i++ )
    {
      if( getc1[i]>0 )
      {
        for( int j=1 ; j<=noverts ; j++ )
        {
          if( edge[getc1[i]][j]==1 || edge[j][getc1[i]]==1 )
          {
            line(xpos[getc1[i]],ypos[getc1[i]],xpos[j],ypos[j]);
            if( comp1[j]==0 )
            {
              comp1[j]=1;
              getc1[temp]=j;
              temp++;
            }
          }
        }
      }
    }
  }
  time++;
  fill(0);
  text("The proportion of green time is " + greentime/(float)time, 7,20);
}



  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "crit_random_graph_1" });
  }
}
