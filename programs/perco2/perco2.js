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
  if (cycler == 2) {
    cycler = 1;
  } else {
    cycler++;
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
}