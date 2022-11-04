package image;

import image.color.GrayColor;

public class Pixel {

  private GrayColor color ;

  public Pixel(GrayColor color) {	  
    this.color = color ;
  }
  
  public GrayColor getColor() {
    return this.color;
  }
  
  public void setColor(GrayColor newColor) {
    this.color = newColor ;
  }

  public boolean equals(Object o) {
    if (o instanceof Pixel){
      Pixel other = (Pixel) o;
      return this.color.equals(other.color);
    }
    else {
      return false;
    }
  }
  
  public int colorLevelDifference(Pixel pixel) {
    return Math.abs(this.getColor().getGrayLevel() - pixel.getColor().getGrayLevel());
  }

}
