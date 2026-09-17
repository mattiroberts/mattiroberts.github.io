Rectangle[] rectangle;
int numrects;
float speed;
int maxrects;

void setup() {
  
  size(600, 600);
  background(255);
  rectMode(CORNERS);
  speed = 1;
  maxrects = 100000;
  strokeWeight(0.2);
  
  rectangle = new Rectangle[maxrects+1];
  
  rectangle[1] = new Rectangle(20, height-20, width-20, 20,1);
  numrects=1;
  
  
}
  

void draw() {
  for( int i=1 ; i<=numrects ; i++ ) {
    rectangle[i].sample();
  }
}


//void keyPressed() {
//  loop();
//}



class Rectangle {
  float leftX, topY, rightX, bottomY;
  float ratio;
  float area;
  int num;
  float randno;
  
  Rectangle(float tempLeftX, float tempTopY, float tempRightX, float tempBottomY, int tempNum) {
    leftX = tempLeftX; topY = tempTopY; rightX = tempRightX; bottomY = tempBottomY;
    num = tempNum;
    ratio = (rightX-leftX)/(topY-bottomY);
    area = (rightX-leftX)*(topY-bottomY);
    display();
  }
  
  void sample() {
    if( random(1) < 0.01 * speed * max(ratio,1/ratio) && numrects < maxrects && area>1 ) {
      splitrect();
      display();
//      noLoop();
    }
  }
  
  void display() {
    if(ratio>=1) { fill(255,255/ratio,0); }
    else { fill(255*ratio,255,0); }
    rect(leftX,topY,rightX,bottomY);
  }
  
  void splitrect() {
    randno = random(1);
    if( ratio>=1 ) {
      rectangle[numrects+1] = new Rectangle(leftX + randno*(rightX - leftX), topY, rightX, bottomY, numrects+1);
      numrects++;
      rightX = leftX + randno*(rightX - leftX);
      ratio = (rightX-leftX)/(topY-bottomY);
      area = (rightX-leftX)*(topY-bottomY);
    }
    else {
      rectangle[numrects+1] = new Rectangle(leftX, topY, rightX, bottomY + randno*(topY - bottomY), numrects+1);
      numrects++;
      topY = bottomY + randno*(topY - bottomY);
      ratio = (rightX-leftX)/(topY-bottomY);
      area = (rightX-leftX)*(topY-bottomY);
    }
  }
  
}




