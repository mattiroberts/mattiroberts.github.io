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

public class brw_lattice extends PApplet {


int timegone;
int latticesize;
int maxnoparts;
int[][] partsnow;
int[][] partsever;
int noparts;
int[] partposx;
int[] partposy;
int[] partalive;
float randomno;
float widthratio;
float heightratio;
int nopartsold;

public void setup() {
  size(800, 600);
  
  background(255);
  
  latticesize=100;
  maxnoparts=2000000;
  
  noparts=1;
  partsnow = new int[2*latticesize+10][2*latticesize+10];
  partsever = new int[2*latticesize+10][2*latticesize+10];
  partposx = new int[maxnoparts+10];
  partposy = new int[maxnoparts+10];
  partalive = new int[maxnoparts+10];
  partsnow[latticesize+1][latticesize+1]=1;
  partsever[latticesize+1][latticesize+1]=1;
  partposx[1]=0;
  partposy[1]=0;
  partalive[1]=1;
  heightratio = height/(2*(float)latticesize+10);
}

public void draw()
{
  background(255);
  
  nopartsold=noparts;
  for( int i=1; i<=nopartsold; i++ )
  {
    if( partposx[i] < latticesize + 2 && partposx[i] > -latticesize-2 && partposy[i] < latticesize + 2 && partposy[i] > -latticesize-2 ) {
      partsnow[latticesize+1+partposx[i]][latticesize+1+partposy[i]]--;  //the original particle is no longer at its old position
    }
    
    if( partalive[i]==1) {
      if( random(1) > 2- 3/(2*sqrt(2)) && noparts<=maxnoparts-4 ) {        //with prob 2-3/2sqrt2, we have a child
        noparts += 1;
        partalive[noparts]=1;
        randomno = random(1);                 //assign the position of the child
        if( randomno < 1/(float)3 ) {
          if( partposx[i] >=0 ) {
            partposx[noparts]=partposx[i]+1;
          } else {
            partposx[noparts]=partposx[i]-1;
          }
          partposy[noparts]=partposy[i];
        } else if( randomno < 1/(float)2 ) {
          if( partposx[i] >= 0 ) {
            partposx[noparts]=partposx[i]-1;
          } else {
            partposx[noparts]=partposx[i]+1;
          }
          partposy[noparts]=partposy[i];
        } else if( randomno < 5/(float)6 ) {
          partposx[noparts]=partposx[i];
          if( partposy[i] >= 0 ) {
            partposy[noparts]=partposy[i]+1;
          } else {
            partposy[noparts]=partposy[i]-1;
          }
        } else {
          partposx[noparts]=partposx[i];
          if( partposy[i] >= 0 ) {
            partposy[noparts]=partposy[i]-1;
          } else {
            partposy[noparts]=partposy[i]+1;
          }
        }
        if( partposx[noparts] < latticesize + 2 && partposx[noparts] > -latticesize-2 && partposy[noparts] < latticesize + 2 && partposy[noparts] > -latticesize-2) {
          partsnow[latticesize+1+partposx[noparts]][latticesize+1+partposy[noparts]]++;
          partsever[latticesize+1+partposx[noparts]][latticesize+1+partposy[noparts]]++;
        }
      }
    }
    
    randomno = random(1);                 //reassign the position of the original particle
    if( randomno < 1/(float)3 ) {
          if( partposx[i] >= 0 ) {
            partposx[i]=partposx[i]+1;
          } else {
            partposx[i]=partposx[i]-1;
          }
          partposy[i]=partposy[i];
        } else if( randomno < 1/(float)2 ) {
          if( partposx[i] >= 0 ) {
            partposx[i]=partposx[i]-1;
          } else {
            partposx[i]=partposx[i]+1;
          }
          partposy[i]=partposy[i];
        } else if( randomno < 5/(float)6 ) {
          partposx[i]=partposx[i];
          if( partposy[i] >= 0 ) {
            partposy[i]=partposy[i]+1;
          } else {
            partposy[i]=partposy[i]-1;
          }
        } else {
          partposx[i]=partposx[i];
          if( partposy[i] >= 0 ) {
            partposy[i]=partposy[i]-1;
          } else {
            partposy[i]=partposy[i]+1;
          }
        }
    if( partposx[i] < latticesize + 2 && partposx[i] > -latticesize-2 && partposy[i] < latticesize + 2 && partposy[i] > -latticesize-2) {
      partsnow[latticesize+1+partposx[i]][latticesize+1+partposy[i]]++;
      partsever[latticesize+1+partposx[i]][latticesize+1+partposy[i]]++;
    }
  }
  
//  for( int i=-latticesize ; i<=latticesize ; i++ ) {
//    for( int j=-latticesize ; j<=latticesize ; j++ ) {
//      if( partsever[1+latticesize+i][1+latticesize+j] > 0 ) {
//        stroke(0,0,255);
//        strokeWeight(5*log(2+partsever[1+latticesize+i][1+latticesize+j]));
//        point(width/2 + i*heightratio, height/2 + j*heightratio);
//      }
//    }
//  }
  for( int i=-latticesize ; i<=latticesize ; i++ ) {
    for( int j=-latticesize ; j<=latticesize ; j++ ) {
      if( partsnow[1+latticesize+i][1+latticesize+j] > 0 ) {
        stroke(255,0,0);
        strokeWeight(5*log(2+partsnow[1+latticesize+i][1+latticesize+j]));
        point(width/2 + i*heightratio, height/2 + j*heightratio);
      }
    }
  }
  if( noparts > maxnoparts-4 ) {
    noLoop();
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "brw_lattice" });
  }
}
