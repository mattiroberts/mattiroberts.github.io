// Draws the lilypad limit for the Pareto BRWRE, and includes ALL lilypads.

color[][] circol;
float epsilon = 1;
int xrad = 52;
int yrad = 30;
float[][] skyline;
float highest;
float[][] hit;
float maxhit;
float xscale;
float curtime;
float timestep = 0.001;
int[][] active;
PFont arfont;

float heightrv() {
  return (-1)*epsilon/log(random(1));
}

float l1dist(float x1, float y1, float x2, float y2)
{
  return abs(y1 - y2) + abs(x1-x2);
}

void timer(int xpos, int ypos, float curtime)
{
  for( int i=0 ; i<= 2*xrad ; i++ ) {
    for( int j=0 ; j<= 2*yrad ; j++ ) {
      if( (hit[i][j] < 0.1) || (hit[i][j] > curtime + epsilon*l1dist(i,j,xpos,ypos)/skyline[xpos][ypos]) ) {
        hit[i][j] = hit[xpos][ypos]+epsilon*l1dist(i,j,xpos,ypos)/skyline[xpos][ypos];
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

void setup() {
  
  size(1000, 600);
  background(255);
  
  arfont = loadFont("ArialMT-12.vlw"); 
  textFont(arfont); 
  
  rectMode(CENTER);
  
  xscale = 560/(2*(float)yrad+1);
  
  circol = new color[2*xrad+11][2*yrad+11];
  skyline = new float[2*xrad+11][2*yrad+11];
  hit = new float[2*xrad+11][2*yrad+11];
  active = new int[2*xrad+11][2*yrad+11];
  
  hit[xrad][yrad] = 1;
  active[xrad][yrad] = 1;
  
  noStroke();
  fill(0);
  for(int i=0; i<=2*xrad; i++) {
    for(int j=0; j<=2*yrad; j++) {
      circol[i][j] = color(random(255),random(255),random(255),60);
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
      if( hit[i][j] < 0.1 ) { fill(255,0,0); }
      else { fill(255-230*pow(skyline[i][j],0.3)/pow(highest,0.3)); }
      rect(23+xscale*i, 23+xscale*j, xscale, xscale);
    }
  }
}

void draw() {
  background(255);
  noStroke();
  for(int i=0; i<=2*xrad; i++) {
    for(int j=0; j<=2*yrad; j++) {
      if( hit[i][j] < 0.1 ) { fill(255,0,0); }
      else { fill(255-230*pow(skyline[i][j],0.3)/pow(highest,0.3)); }
      rect(23+xscale*i, 23+xscale*j, xscale, xscale);
      
    }
  }
  stroke(0,0,0,40);
  for(int i=0; i<=2*xrad; i++) {
    for(int j=0; j<=2*yrad; j++) {
      if( (hit[i][j] < 1+curtime) ) {
        fill(circol[i][j]);
        quad(23+xscale*i + xscale*skyline[i][j]*(curtime-hit[i][j]+1)/epsilon, 23+xscale*j, 23+xscale*i, 23+xscale*j + xscale*skyline[i][j]*(curtime-hit[i][j]+1)/epsilon, 23+xscale*i - xscale*skyline[i][j]*(curtime-hit[i][j]+1)/epsilon, 23+xscale*j, 23+xscale*i, 23+xscale*j - xscale*skyline[i][j]*(curtime-hit[i][j]+1)/epsilon); 
        //ellipse(20+xscale*i,20+xscale*j,2*xscale*skyline[i][j]*(curtime-hit[i][j]+1)/epsilon,2*xscale*skyline[i][j]*(curtime-hit[i][j]+1)/epsilon);
      }
    }
  }
//  if( curtime > maxhit-1 ) { fill(0); text("The entire area was covered by time " + maxhit + ".", 4,12); }
  curtime += timestep;
}


