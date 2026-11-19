
int[] ypos;
int incr;
float xscaler;
float yscaler;
int counter;
int cycler;
int nosteps;
int[] bars;
float barscaler;

void setup() {
  size(1200, 900);
  background(255);
  
  nosteps = 80;
  ypos = new int[nosteps+5];
  bars = new int[2*nosteps+5];
  
  ypos[0]=0;
  counter = 0;
  barscaler = 1;
  
  xscaler = (width-200)/(float)(nosteps+7);
  yscaler = height/(float)(16*sqrt(nosteps+5));
  
  strokeWeight(4);
  point(50, height/2);
  
  cycler = 1;
  
}

void keyReleased() {
  if (cycler == 1) {
    cycler = 0;
    noLoop();
  } else {
    cycler=1;
    loop();
  }
}

void draw()
{
  background(255);
  strokeWeight(2);
  stroke(200);
  line(50,height/2,width-220,height/2);
  line(width-220,height/2,width-226,height/2-4);
  line(width-220,height/2,width-226,height/2+4);
  line(50,50,50,height-50);
  line(50,50,54,56);
  line(50,50,46,56);
  stroke(0);
  
  counter++;
  
  ypos[0]=0;
  
  for( int j=1 ; j<=nosteps ; j++ )
  {
    incr = floor(random(2));
    incr = 2*incr-1;
    if(random(1)<0.2) { incr = 4*incr; }
    
    ypos[j]=ypos[j-1]+incr;
    
    strokeWeight(2*yscaler/9);
    point(50, height/2);
    strokeWeight(2*yscaler/27);
    line(50+xscaler*(j-1), height/2+yscaler*ypos[j-1], 50+xscaler*j, height/2+yscaler*ypos[j]);
    strokeWeight(2*yscaler/9);
    point(50+xscaler*j, height/2+yscaler*ypos[j]);
    
  }
  
  println("" + ypos[nosteps]);
  
  bars[nosteps+ypos[nosteps]]++;
  if(bars[nosteps+ypos[nosteps]] > barscaler ) { barscaler++ ; }
  
  noStroke();
  fill(0,100,100);
  rect(width - 200,height/2-0.5*yscaler,bars[nosteps]*xscaler*10/max(barscaler,10),yscaler);
  for( int i=1 ; i<= nosteps ; i++ ) {
    rect(width - 200,height/2-(i+0.5)*yscaler,bars[nosteps-i]*xscaler*10/max(barscaler,10),yscaler);
    rect(width - 200,height/2+(i-0.5)*yscaler,bars[nosteps+i]*xscaler*10/max(barscaler,10),yscaler);
  }
  stroke(0);
  
  if( counter < 5 ) { cycler = 0; noLoop(); }
  
}