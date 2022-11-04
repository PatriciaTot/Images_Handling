package image;

import image.util.* ;
import image.color.*;

public class ImageMain {
	
	private static final String LAMP_IMAGE = "/images/lamp.pgm";
	private static final String CAT_IMAGE = "/images/chat.pgm";

	public static void main(String [] args) {
		
		Image image1 = new Image(200, 150) ;
		
		GrayColor color1 = new GrayColor(100) ;
		GrayColor color2 = new GrayColor(200) ;
		
	    image1.fillRectangle(20, 30, 30, 50, GrayColor.BLACK) ;
	    image1.fillRectangle(50, 100, 40, 40, color1) ;
	    image1.fillRectangle(90, 20, 70, 50, color2) ;
	    
	    ImageDisplayer displayer1 = new ImageDisplayer() ;
	    displayer1.display(image1, "3 rectangles", 100, 100);
	    
	    Image image2 = ImageLoader.loadPGM(CAT_IMAGE) ;
	    Image imageNegative = image2.negative() ;
	    ImageDisplayer displayer2 = new ImageDisplayer() ;
	    displayer2.display(image2, "cat", 100, 100) ;
	    displayer2.display(imageNegative, "Negative", 200, 150) ;
	    
	    Image lampImg = ImageLoader.loadPGM(LAMP_IMAGE) ;
	    Image lampEdge = lampImg.edgeExtraction(1) ;
	    ImageDisplayer displayer3 = new ImageDisplayer() ;
	    displayer3.display(lampImg, "Lamp", 100, 100) ;
	    displayer3.display(lampEdge, "Edge", 200, 150) ;
	    
	    
	    Image lampImg2 = ImageLoader.loadPGM(args[0]);
	    Image lamplev = lampImg2.decreaseNbGrayLevels(Integer.parseInt(args[1]));
	    ImageDisplayer displayer4 = new ImageDisplayer() ;
	    displayer4.display(lampImg2, "Lamp", 100, 100);
	    displayer4.display(lamplev, "lev", 75, 75);
	    
	}	
}
