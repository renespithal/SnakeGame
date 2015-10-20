package Model;

public class Layout {
	
	  private int blockSize;
	  private int screenWidth;
	  private int screenHeight;
	  
	  public Layout(int screenWidth, int screenHeight)
	  {
		  this.blockSize = 15;
		  this.screenWidth = screenWidth/blockSize*blockSize;
		  this.screenHeight = screenHeight/blockSize*blockSize;
	  }
	  
	  public int getBlockSize()
	  {
		  return this.blockSize;
	  }

}
