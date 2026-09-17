// Draws the Poisson lilypad limit for the Pareto BRWRE

Lilypad[] lilypad;
int intw, inth;
float smallestpot=0.05;
float biggestpot=0;
float alpha=1.8;
float temppot;
int i,j;
float[][] potarr;
int[][] listarr;
int[] listx;
int[] listy;
int counter=0;
float q;
float scale=0.02;

float heightrv() {
  return scale*pow(random(1),-1/alpha);
}

void setup() {
  
  size(1000, 600);
  intw=1000; inth=600;
  background(255);
  
  potarr = new float[intw+5][inth+5];
  listarr = new int[intw+5][inth+5];
  listx = new int[10*intw+5];
  listy = new int[10*intw+5];
  lilypad = new Lilypad[10*intw+5];
  q = 5;
  
  //arfont = loadFont("ArialMT-12.vlw"); 
  //textFont(arfont); 
  
  rectMode(CENTER);
  
  temppot = heightrv();
  counter=1;
  potarr[intw/2][inth/2]=temppot;
  listarr[intw/2][inth/2]=counter;
  listx[counter] = intw/2;
  listy[counter] = inth/2;
  lilypad[counter] = new Lilypad(intw/2,inth/2,temppot/q);
  
  
  for( i=1 ; i<= intw ; i++ ) {
    for( j=1 ; j<=inth ; j++ ) {
      temppot = heightrv();
      if( temppot > smallestpot + scale*0.1*abs(i-intw/2) + scale*0.1*abs(j-inth/2) && counter < 10*intw && (i!=intw/2 || j!=inth/2)) {
        counter++;
        if( temppot > biggestpot ) { biggestpot = temppot; }
        potarr[i][j]=temppot;
        listarr[i][j]=counter;
        listx[counter] = i;
        listy[counter] = j;
        lilypad[counter] = new Lilypad(i,j,temppot/q);
      }
    }
  }
  
  for( i=1 ; i<=intw ; i++ ) {
    for( j=1 ; j<=inth ; j++ ) {
      if( listarr[i][j]>0 ) {
        //stroke(255-255*pow(potarr[i][j],0.2)/pow(biggestpot,0.2));
        point( i , j );
      }
    }
  }
  
  lilypad[1].starter=1;
  
}

void draw() {
  background(255);
  
  for( i=1 ; i<=counter ; i++ ) {
    stroke(255-255*pow(q*lilypad[i].speed,0.2)/pow(biggestpot,0.2));
    point(listx[i],listy[i]);
  }
  
  noStroke();
  
  for( i=1 ; i<= counter ; i++ ) {
    lilypad[i].move();
    lilypad[i].checkHit();
  }
}




class Lilypad {
  int posX, posY;
  float speed;
  color clr;
  float size;
  float oldsize;
  int stopper=0;
  int starter=0;
  
  Lilypad(int tempPosX, int tempPosY, float tempSpeed) {
    posX = tempPosX; posY = tempPosY; speed = tempSpeed;
    clr = color(random(255),random(255),random(255),60);
    size = 0;
  }
  
  void move() {
    if( stopper == 1 ) { quad(posX+size,posY,posX,posY+size,posX-size,posY,posX,posY-size); return; }
    if( starter == 0 ) { return; }
    if( size > intw && size > inth ) { stopper = 1; }
    oldsize = size;
    size += speed;
    fill(clr);
    stroke(0,0,0,40);
    quad(posX+size,posY,posX,posY+size,posX-size,posY,posX,posY-size);
  }
  
  void checkHit() {
    if( stopper == 1 || starter==0 ) { return; }
    for( int k=1 ; k<= counter ; k++ ) {
      if( lilypad[k].stopper==0 && lilypad[k].starter==0 && abs(lilypad[k].posX - posX)+abs(lilypad[k].posY - posY) < size ) {
        lilypad[k].starter=1;
      }
    }
  }
}