public class Lab6
{
  public static void fill(GridDisplay display, Color c)
  {
    int row;
    int col;
    int numRows;
    numRows=display.getNumRows();
    int numCols;
    numCols=display.getNumCols();  
    
    Location location;
    
    for (row=0; row<numRows; row=row+1)
    {
      for(col=0; col<numCols; col=col+1)
      {
        location=new Location(row, col);
        display.setColor(location, c);
      }
    }
  }

  public static void onlyRed(GridDisplay display)
  {
    int row;
    int col;
    Location location;
    int NumRows;
    NumRows=display.getNumRows();
    int NumCols;
    NumCols=display.getNumCols();
    
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumCols; col=col+1)
      {
        location=new Location(row, col);     
        display.setColor(location, new Color(display.getColor(location).getRed(), 0, 0));
      }
    }    
  }
  
  public static void negate(GridDisplay display)
  {
    int row;
    int col;
    Location location;
    int NumRows;
    NumRows=display.getNumRows();
    int NumCols;
    NumCols=display.getNumCols();
    int x;
    x=255;
    int red;
    int green;
    int blue;
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumCols; col=col+1)
      {
        location=new Location(row, col);
        red=display.getColor(location).getRed();
        green=display.getColor(location).getGreen();
        blue=display.getColor(location).getBlue();
        display.setColor(location, new Color(x-red, x-green, x-blue));
      }
    }
    
  }
  
  public static void grayScale(GridDisplay display)
  {
    int row;
    int col;
    Location location;
    int NumRows;
    NumRows=display.getNumRows();
    int NumCols;
    NumCols=display.getNumCols();
    int red;
    int green;
    int blue;
    int average;
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumCols; col=col+1)
      {
        location=new Location(row, col);
        red=display.getColor(location).getRed();
        green=display.getColor(location).getGreen();
        blue=display.getColor(location).getBlue();
        average=(red+green+blue)/3;
        
        display.setColor(location, new Color(average, average, average));
      }
    }
  }
  
  public static void reduceColors(GridDisplay display, int span)
  {
    int row;
    int col;
    Location location;
    int NumRows;
    NumRows=display.getNumRows();
    int NumCols;
    NumCols=display.getNumCols();
    int red, green, blue;
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumCols; col=col+1)
      {
        location=new Location(row, col);
        red=display.getColor(location).getRed();
        green=display.getColor(location).getGreen();
        blue=display.getColor(location).getBlue();
        red=red/span*span;
        green=green/span*span;
        blue=blue/span*span;
        display.setColor(location, new Color(red, green, blue));
      }
    }
  
  }
  
  public static void tint(GridDisplay display, double redCoeff, double greenCoeff, double blueCoeff)
  {
    int row;
    int col;
    Location location;
    int NumRows;
    NumRows=display.getNumRows();
    int NumCols;
    NumCols=display.getNumCols();
    int red, green, blue;
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumCols; col=col+1)
      {
        location=new Location(row, col);
        red=display.getColor(location).getRed();
        green=display.getColor(location).getGreen();
        blue=display.getColor(location).getBlue();
        red=(int)(red*redCoeff);
        green=(int)(green*greenCoeff);
        blue=(int)(blue*blueCoeff);
        if(red>255) red=255;
        if(green>255) green=255;
        if(blue>255) blue=255;
        display.setColor(location, new Color(red, green, blue));
      }
    }
  }
  
  public static void flip(GridDisplay display)
  {
   int row, col;
    Location locationOne, locationTwo;
    int NumRows;
    NumRows=display.getNumRows();
    int NumCols;
    NumCols=display.getNumCols();
    int red, green, blue;
    int redTwo, greenTwo, blueTwo;
    
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumCols/2; col=col+1)
      {
        locationOne=new Location(row, col);
        red=display.getColor(locationOne).getRed();
        green=display.getColor(locationOne).getGreen();
        blue=display.getColor(locationOne).getBlue();
        
        locationTwo=new Location(row, NumCols-col-1);
        redTwo=display.getColor(locationTwo).getRed();
        greenTwo=display.getColor(locationTwo).getGreen();
        blueTwo=display.getColor(locationTwo).getBlue();
        
        display.setColor(locationOne, new Color(redTwo, greenTwo, blueTwo));
        display.setColor(locationTwo, new Color(red, green, blue));
      }
    }
  }
}