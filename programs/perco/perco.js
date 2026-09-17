let hor = [];
let ver = [];
let check = [];
let cycler = 1;
let scaler = 10;

function setup() {
  createCanvas(1200, 800);
  
  background(255);
  
  for( let i=1; i<=width/scaler; i++) {
    hor[i] = []; // create nested array
    ver[i] = [];
    check[i] = [];
  }
  
   for(let i=1; i<width/scaler-1; i++) {
    for(let j=1; j<height/scaler-1; j++) {
      hor[i+1][j]=int(random(2));
      stroke(255-255*hor[i+1][j]);
      line(scaler*i,scaler*j,scaler*(i+1),scaler*j);
      ver[i][j+1]=int(random(2));
      stroke(255-255*ver[i][j+1]);
      line(scaler*i,scaler*j,scaler*i,scaler*(j+1));
    }
  }
}

function keyReleased() {
  if (cycler == 3) {
    cycler = 1;
  } else {
    cycler++;
  }
}

function checkvertex(x, y, c) {
  noStroke();
  fill(c);
  rect(scaler*x,scaler*y,scaler,scaler);
  check[x][y]=1;
  
  if(x+1 <= width/scaler-1 && hor[x+1][y]==1 && check[x+1][y]==0) {
    checkvertex(x+1,y,c);
  }
  if(y-1>=0 && ver[x][y]==1 && check[x][y-1]==0) {
    checkvertex(x,y-1,c);
  }
  if(x-1>=0 && hor[x][y]==1 && check[x-1][y]==0) {
    checkvertex(x-1,y,c);
  }
  if(y+1 <= height/scaler-1 && ver[x][y+1]==1 && check[x][y+1]==0) {
    checkvertex(x,y+1,c);
  }
}

function draw() {
    if( cycler >= 2 ) {
    background(255);
    for(let i=1; i<width/scaler-1; i++) {
      for(let j=1; j<height/scaler-1; j++) {
        check[i][j]=0;
        if( random(1) <0.003 ) {
          hor[i+1][j]=int(random(2));
        }
        stroke(255-255*hor[i+1][j]);
        line(scaler*i,scaler*j,scaler*(i+1),scaler*j);
        if( random(1) <0.003 ) {
          ver[i][j+1]=int(random(2));
        }
        stroke(255-255*ver[i][j+1]);
        line(scaler*i,scaler*j,scaler*i,scaler*(j+1));
      }
    }
  }
  
  if( cycler == 3 ) {
    
    noStroke();
    fill(255,0,0,127);
    rectMode(CENTER);
    
    checkvertex(width/(2*scaler),height/(2*scaler),color(255,0,0,127));
    
    checkvertex(width/(4*scaler),height/(4*scaler),color(0,255,0,127));
    
    checkvertex(3*width/(4*scaler),3*height/(4*scaler),color(0,0,255,127));
    
    checkvertex(width/(4*scaler),3*height/(4*scaler),color(255,127,0,127));
    
    checkvertex(3*width/(4*scaler),height/(4*scaler),color(204,0,255,127));
  }
}