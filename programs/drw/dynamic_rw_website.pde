int[] xvec;
int maj;
int swi;
int swidir;
int oldmaj;
int oldswi;
int join;
int endtime;
float eps;
float scaler;
int stopper;
PFont arfont;

void setup() {
  size(800, 600);
  background(255);
  strokeWeight(2);
  
  arfont = loadFont("ArialMT-12.vlw");
  textFont(arfont); 
  textSize(16);
  
  endtime = 100;
  eps = 0.02;
  
  scaler = 0.95*width/(float)endtime;
  
  xvec = new int[endtime+5];
  
  for( int i=1 ; i<=endtime ; i++ ) {
    xvec[i] = 2*round(random(1))-1;
  }
  
  stroke(127);
  line( 0.025*width, height/4, 0.025*width + endtime*scaler, height/4 );
  line( 0.025*width, 3*height/4, 0.025*width + endtime*scaler, 3*height/4 );
  stroke(0);
  
  
  
  maj=0;
  for( int i=1 ; i<=endtime ; i++ ) {
    line( 0.025*width + scaler*i, height/4 - sqrt(scaler)*maj, 0.025*width + scaler*(i+1), height/4 - sqrt(scaler)*(maj + xvec[i]) );
    maj = maj + xvec[i];
  }
  
  stroke(255,0,0);
  swi=0;
  swidir=1;
  for( int i=1 ; i<=endtime ; i++ ) {
    line( 0.025*width + scaler*i, 3*height/4 - sqrt(scaler)*swi, 0.025*width + scaler*(i+1), 3*height/4 - sqrt(scaler)*(swi + swidir*xvec[i]) );
    swi = swi + swidir*xvec[i];
    swidir = swidir*xvec[i];
  }
  
}

void keyReleased() {
  stopper = 1 - stopper;
  if( stopper == 1 ) { loop(); }
  if( stopper == 0 ) { noLoop(); }
}

void draw()
{
  background(255);
  stroke(127);
  line( 0.025*width, height/4, 0.025*width + endtime*scaler, height/4 );
  line( 0.025*width, 3*height/4, 0.025*width + endtime*scaler, 3*height/4 );
  stroke(0);
  fill(0);
  text("The dynamical compass random walk:", 20,50);
  text("The dynamical switch random walk:", 20, 360);
  
  for( int i=1 ; i<=endtime ; i++ ) {
    if( random(1) < eps ) {
      xvec[i] = 2*round(random(1))-1;
    }
  }
  
  maj=0;
  for( int i=1 ; i<=endtime ; i++ ) {
    line( 0.025*width + scaler*i, height/4 - sqrt(scaler)*maj, 0.025*width + scaler*(i+1), height/4 - sqrt(scaler)*(maj + xvec[i]) );
    maj = maj + xvec[i];
  }
  
  stroke(255,0,0);
  swi=0;
  swidir=1;
  for( int i=1 ; i<=endtime ; i++ ) {
    line( 0.025*width + scaler*i, 3*height/4 - sqrt(scaler)*swi, 0.025*width + scaler*(i+1), 3*height/4 - sqrt(scaler)*(swi + swidir*xvec[i]) );
    swi = swi + swidir*xvec[i];
    swidir = swidir*xvec[i];
  }
}
