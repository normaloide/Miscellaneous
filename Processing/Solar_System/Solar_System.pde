import java.util.*;

//global
private PImage bg;
private final int width = 1280;
private final int height = 720;
private float theta = 0.0;
private float cpx = 50.0;
private boolean flag_z = false;

//Sun
private Planets sol = new Planets(this.width/2, this.height/2);
private float sun_rot = 0.0;

//Earth
private Planets gea = new Planets(200, this.height/2, 0);
private float gea_rot = 0.0;

public void setup() {

  //depends on pc (anti-aliasing)
  smooth(4);
  
  //canvas
  size(1280, 720, P3D);
  this.bg = (loadImage("8k_stars_milky_way.jpg"));
}

public void draw() {
  
  clear();
  
  //set World
  background(this.bg);
  worldLights();
  
  //creating the Sun
  createSun();
  
  /**
  * Pushing the Matrix and creating the Vector to add
  * Earth and its rotation around the Sun
  */
  pushMatrix();
  
  //Math.abs() because, if negative, the rotation will switch direction
  PVector v = new PVector(0, Math.abs(this.cpx), 0);
  rotate(theta, v.x, v.y, v.z);
  
  //position the Earth at the Sun height
  translate(v.x, -height/2, v.z);
  createEarth();
  popMatrix();
  
  //0.9 because of its 1 by 1 increment, at PVector(0,0,0) will lag
  if(flag_z == true) {
    cpx += 0.9;
  }
  
  if(flag_z == false) {
    cpx -= 0.9;
  }
  
  //n and -n as limits of magnitude
  if(cpx >= 50 || cpx <= -50) {
    flag_z = !flag_z;
  }

  theta += 0.002;  //speed of rotation around the Sun
}

public void worldLights() {
  pointLight(255, 255, 255, width/2, height/2, 0);  //sun as pointlight
  lightFalloff(0, 0, 1);  //light directed to planets
  ambientLight(255, 255, 255, width/2, height/2, 0);  //from the center of the Sun
}

public void createSun() {
    
    //position
    translate(this.sol.getX(), this.sol.getY(), this.sol.getZ());
    lights();

    //rotation
    rotateY(this.sun_rot);
    this.sun_rot += (0.001997/1.3);  // km/s : 1.3 ratio (1.99 km/s)
    
    //create the Sun
    shape(this.sol.sun());
}


public void createEarth() {

    //position
    translate(this.gea.getX(), this.gea.getY(), this.gea.getZ());
    
    //rotation
    rotateY(this.gea_rot);
    this.gea_rot += (0.000460/1.3);  // km/s : 1.3 ratio (0.46 km/s)
    
    //create the Sun
    shape(gea.earth());
}
