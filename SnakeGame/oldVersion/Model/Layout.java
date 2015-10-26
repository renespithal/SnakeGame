package Model;

public class Layout {
	
	  private int blockSize;
	  private int screenWidth;
	  private int screenHeight;
	  
	  public Layout()
	  {
		  this.blockSize = 20;
		  this.screenHeight=500/20*20;
		  this.screenWidth=500/20*20;
	  }
	  
	  public Layout(int screenWidth, int screenHeight)
	  {
		  this.blockSize = 20;
		  this.screenWidth = screenWidth/blockSize*blockSize;
		  this.screenHeight = screenHeight/blockSize*blockSize;
	  }
	  
	  public int getBlockSize()
	  {
		  return this.blockSize;
	  }
	  
	  public int getScreenWidth()
	  {
		  return screenWidth;
	  }

	  public int getScreenHeight()
	  {
		  return screenHeight;
	  }
}
