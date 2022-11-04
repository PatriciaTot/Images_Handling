import org.junit.* ;

import static org.junit.Assert.* ;

import image.* ;
import image.Pixel;
import image.color.GrayColor;

public class ImageTest {
	
	@Test
	public void testGetWidth() {	
		Image image = new Image(20 , 5) ;
		assertEquals(20 , image.getWidth()) ;
	}
	
	@Test
	public void testGetHeight() {		
		Image image = new Image(20 , 5) ;
		assertEquals(5 , image.getHeight()) ;
	}
	
	@Test
	public void testGetPixel() {
		Image image = new Image(20 , 5) ;
	    Pixel pixel = new Pixel(GrayColor.WHITE) ;
		for(int x = 0; x < 20 ; x++) {
			for(int y = 0; y < 5 ; y++){
		         assertEquals(pixel.getColor().getGrayLevel(), image.getPixel(x, y).getColor().getGrayLevel()) ;
		    }
		}
	}
	
	@Test
	public void colorOfThePixelIschangedWhenThePixelExists() {
	     Image image = new Image(20, 20) ;
	     Pixel pixel = image.getPixel(8, 4) ;
	     assertEquals(GrayColor.WHITE , pixel.getColor()) ;
	     image.changeColorPixel(8, 4, GrayColor.BLACK) ;
	     assertEquals(GrayColor.BLACK , pixel.getColor()) ;
	}
	
	@Test (expected = UnknownPixelException.class)
	public void testChangeColorPixelThrowsExceptionWhenPixelDoesntExist() {
		Image image = new Image(20, 20) ;
		int x = image.getWidth() * 2 ;
		int y = image.getHeight() * 2 ;
		image.changeColorPixel(x, y, GrayColor.BLACK) ;
	}
	
	@Test
	public void RectangleIsFilled() {
		Image image = new Image(100 , 100) ;
		image.fillRectangle(15, 5, 20, 15, GrayColor.BLACK) ;
		for(int x = 15; x < 35; x++) {
			for(int y = 5; y < 20; y++) {
				assertEquals(GrayColor.BLACK , image.getPixel(x,y).getColor());
			}
		}
	}
	
}
