import java.util.*;

public class Planets {
  
  //attributes
  private PShape shape;
  private PImage shape_img;
  private float x, y, z;
  
  //constructor
  public Planets(float x, float y) {
    this.shape = new PShape();
    this.shape_img = new PImage();
    this.x = x;
    this.y = y;
    this.z = 0.0;
  }
  
  //constructor
  public Planets(float x, float y, float z) {
    this.shape = new PShape();
    this.shape_img = new PImage();
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  //the Sun
  public PShape sun() {
    
    //attributes
    noStroke();
    fill(255, 245, 225);
    lights();
    
    //shaping
    this.shape_img = loadImage("2k_sun.jpg");
    this.shape = createShape(SPHERE, 50);
    this.shape.setTexture(this.shape_img);
    return this.shape;
  }
  
  //the Earth
  public PShape earth() {
    
    //attributes
    noStroke();
    fill(85, 100, 130);
    lights();
    
    //shaping
    this.shape_img = loadImage("2k_earth_daymap.jpg");
    this.shape = createShape(SPHERE, 15);
    this.shape.setTexture(this.shape_img);
    return this.shape;
  }
  
  public float getX() {
    return this.x;
  }
  
  public float getY() {
    return this.y;
  }
  
  public float getZ() {
    return this.z;
  }
}
