package image ;

import image.color.GrayColor;

public class Image implements ImageInterface {
	
	private int width;	
	private int height;
	private Pixel[][] pixels ;
	
	public Image(int width, int height) {
	    this.width = width;
	    this.height = height;
	    this.pixels = new Pixel[width][height];
	    for(int i = 0 ; i < width ; i++){
	      for(int j = 0; j < height; j++) {
	        this.pixels[i][j] = new Pixel(GrayColor.WHITE);
	      }
	    }
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public Pixel getPixel(int x, int y) throws UnknownPixelException {
		
		if ( (x >= 0 && x <= this.width) && (y >= 0 && y <= this.height) ) {
		      return this.pixels[x][y];
		}
		else {
			throw new UnknownPixelException("this pixel does not exist");
		}
	}
	
	/**
	 * changes the color of the pixel of coordinates (x,y) by assigning it the color color
	 * @param x horizontal coordinate
	 * @param y vertical coordinate
	 * @param color the gray color to replace the original color
	 * @throws UnknownPixelException if the pixel of coordinates (x, y) does not exist
	 */
	public void changeColorPixel(int x, int y, GrayColor color) throws UnknownPixelException {
		
		if (  x < 0 || x > this.width || y < 0 || y > this.height ) {
			throw new UnknownPixelException("this pixel does not exist");
		}
		else {
			Pixel pixel = this.getPixel(x, y);
			pixel.setColor(color) ;
		}
	}
	
	/**
	 * draws a full rectangle in the image
	 * @param x horizontal coordinate of the starting point
	 * @param y vertical coordinate of the starting point
	 * @param width of the rectangle
	 * @param height of the rectangle
	 * @param color of the rectangle
	 */
	public void fillRectangle(int x, int y, int width, int height, GrayColor color) {
		
		for (int i = x; i < x + width; i++) {
			for (int j = y; j < y + height; j++) {
				this.changeColorPixel(i, j, color);
			}
		}
	}
	
	public Image negative() {
		  Image image = new Image(this.getWidth() , this.getHeight()) ;
		  for (int x = 0 ; x < this.getWidth() ; x++) {
			  for (int y = 0; y < this.getHeight() ; y++) {
				  image.changeColorPixel(x, y, new GrayColor(255 - getPixel(x , y).getColor().getGrayLevel()));
			  }
		  }
		  return image ;
		  
	  }
	
	/**
	   * Creates a new image by extraction of the edges of the previous one.
	   * @param threshold
	   * @return the new image
	   */
	  public Image edgeExtraction(int threshold){
	    Image result = new Image(this.getWidth(), this.getHeight()) ;
	    for(int x = 0; x < this.getWidth() - 1; x++){
	      for(int y = 0; y < this.getHeight() - 1; y++){
	        if((this.getPixel(x , y).getColor().getGrayLevel() - this.getPixel(x+1 , y).getColor().getGrayLevel() >= threshold || this.getPixel(x,y).getColor().getGrayLevel() - this.getPixel(x, y+1).getColor().getGrayLevel() >= threshold)) {
	          result.changeColorPixel(x, y, GrayColor.BLACK);
	        }
	      }
	    }
	    return result;
	  }

	  /**
	   * Produces a new image obtained from the starting one using a limited number of gray levels.
	   * @param nbGrayLevels
	   * @return the new image obtained
	   */
	  public Image decreaseNbGrayLevels(int nbGrayLevels){
	    int t = 256/nbGrayLevels;
	    Image result = new Image(this.getWidth(), this.getHeight());
	    for(int x = 0; x < this.getWidth(); x++){
	      for(int y = 0; y < this.getHeight(); y++) {
	    	  Pixel pixel = this.getPixel(x , y) ;
	    	  int level1 = pixel.getColor().getGrayLevel() ;
	    	  int level2 = 0 ;
	    	  while(level2 < level1 - t) {
	    		  level2 = level2 + t ;
	    	  }
	        GrayColor color = new GrayColor(level2) ;
	        result.changeColorPixel(x, y, color);
	      }
	    }
	    return result;
	  }

}
