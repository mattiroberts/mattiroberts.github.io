
int[][] hor;
int[][] ver;
int[][] check;

void setup() {
  size(600, 600);
  
  background(255);
  
  hor = new int[width][height];
  ver = new int[width][height];
  check = new int[width][height];
  
   for(int i=6; i<width-6; i+=6) {
    for(int j=6; j<height-6; j+=6) {
      hor[i+3][j]=int(random(2));
      stroke(255-255*hor[i+3][j]);
      line(i,j,i+6,j);
      ver[i][j+3]=int(random(2));
      stroke(255-255*ver[i][j+3]);
      line(i,j,i,j+6);
    }
  }
}

void draw() {
  background(255);
  for(int i=6; i<width-6; i+=6) {
    for(int j=6; j<height-6; j+=6) {
      check[i][j]=0;
      if( random(1) <0.001 ) {
        hor[i+3][j]=int(random(2));
      }
      stroke(255-255*hor[i+3][j]);
      line(i,j,i+6,j);
      if( random(1) <0.001 ) {
        ver[i][j+3]=int(random(2));
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

void checkvertex(int x, int y, color c) {
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

