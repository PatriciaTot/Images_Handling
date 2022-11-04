package image.color;

public class GrayColor {

  public static final GrayColor WHITE = new GrayColor(255);
  public static final GrayColor BLACK = new GrayColor(0);

  private final int grayLevel;
  private double alpha;

  public GrayColor(int grayLevel) {
	  
    this.grayLevel = grayLevel;
    this.alpha = 1;
  }
  
  /**
   * Gets the color's gray level.
   * @return the color's gray level
   */
  public int getGrayLevel() {	  
    return this.grayLevel;
  }
  
  /**
   * Gets the color's tranparency.
   * @return the color's transparency
   */
  public double getAlpha() {
	      return this.alpha;
  }
  
  /**
   * changes the value of the tranparency index.
   * @param a the new transparency index
   */
  public void setAlpha(double a) {
    this.alpha = a;
  }
  
  /**
   * Compares two colors
   * @param o an object to compare this color with
   * @return true if both gray levels and tranparency index are equal, false otherwise
   */
  public boolean equals(Object o) {	  
    if (o instanceof GrayColor) {   	
      GrayColor other = (GrayColor) o;
      return this.grayLevel == other.grayLevel && this.alpha == other.alpha;
    }
      return false;
  }
  
}
