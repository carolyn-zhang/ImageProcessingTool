public class Lab6Bonus
{
  
  public static void blendOrig(GridDisplay display, GridDisplay displayTwo)
  {
    int row, col;
    Location location;
    int NumRows;
    NumRows=display.getNumRows();
    int NumCols;
    NumCols=display.getNumCols();
    int red, green, blue;
    int redTwo, greenTwo, blueTwo;
    
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumCols; col=col+1)
      {
        location=new Location(row, col);
        red=display.getColor(location).getRed();
        green=display.getColor(location).getGreen();
        blue=display.getColor(location).getBlue();
        
        redTwo=displayTwo.getColor(location).getRed();
        greenTwo=displayTwo.getColor(location).getGreen();
        blueTwo=displayTwo.getColor(location).getBlue();
        
        display.setColor(location, new Color((red+redTwo)/2, (green+greenTwo)/2, (blue+blueTwo)/2));
        displayTwo.setColor(location, new Color((red+redTwo)/2, (green+greenTwo)/2, (blue+blueTwo)/2));
      }
    }

  }
    public static void blend(GridDisplay display, GridDisplay displayTwo)
  {
    int row, col;
    Location location;
    int NumRows, NumRowsTwo;
    NumRows=display.getNumRows();
    NumRowsTwo=displayTwo.getNumRows();
    int NumCols, NumColsTwo;
    NumCols=display.getNumCols();
    NumColsTwo=displayTwo.getNumCols();
    int red, green, blue;
    int redTwo, greenTwo, blueTwo;
    
    for (row=0; row<Math.min(NumRows, NumRowsTwo); row=row+1)
    {
      for(col=0; col<Math.min(NumCols, NumColsTwo); col=col+1)
      {
        location=new Location(row, col);
        red=display.getColor(location).getRed();
        green=display.getColor(location).getGreen();
        blue=display.getColor(location).getBlue();
        
        redTwo=displayTwo.getColor(location).getRed();
        greenTwo=displayTwo.getColor(location).getGreen();
        blueTwo=displayTwo.getColor(location).getBlue();
        
        display.setColor(location, new Color((red+redTwo)/2, (green+greenTwo)/2, (blue+blueTwo)/2));
      }
    }
  }
    
  
  public static void greenScreen(GridDisplay display, GridDisplay displayTwo)
  {
    int row, col;
    Location location;
    int NumRows;
    NumRows=display.getNumRows();
    int NumCols;
    NumCols=display.getNumCols();
    int red, green, blue;
    int redTwo, greenTwo, blueTwo;
    
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumCols; col=col+1)
      {
        location=new Location(row, col);
        red=display.getColor(location).getRed();
        green=display.getColor(location).getGreen();
        blue=display.getColor(location).getBlue();
        redTwo=displayTwo.getColor(location).getRed();
        greenTwo=displayTwo.getColor(location).getGreen();
        blueTwo=displayTwo.getColor(location).getBlue();
        if (green*1.0/(red+green+blue)>0.5)
        {
          display.setColor(location, new Color(redTwo, greenTwo, blueTwo));
        }
          
      }
    }
    
  }
  

  
  public static void newEdgeDetection(GridDisplay display, int threshold)
  {
    int row, col;
    Location location;
    int numRows;
    numRows=display.getNumRows();
    int numCols;
    numCols=display.getNumCols();
    GridDisplay displayTwo;
    displayTwo=new GridDisplay(numRows, numCols);
    int red, green, blue;
    int above, below, left, right, difference;
    
    for (row=1; row<numRows-1; row=row+1)
    {
      for(col=1; col< numCols-1; col=col+1)
      {
        location=new Location(row, col);
        
        above=(display.getColor(new Location(row-1,col)).getRed()+
          display.getColor(new Location(row-1,col)).getGreen()+
            display.getColor(new Location(row-1,col)).getBlue())/3;
        below=(display.getColor(new Location(row+1,col)).getRed()+
          display.getColor(new Location(row+1,col)).getGreen()+
            display.getColor(new Location(row+1,col)).getBlue())/3;
        left=(display.getColor(new Location(row,col-1)).getRed()+
          display.getColor(new Location(row,col-1)).getGreen()+
            display.getColor(new Location(row,col-1)).getBlue())/3;
        right=(display.getColor(new Location(row,col+1)).getRed()+
          display.getColor(new Location(row,col+1)).getGreen()+
            display.getColor(new Location(row,col+1)).getBlue())/3;
        difference=(above-below)*(above-below)+(left-right)*(left-right);
                                   
        if(difference>threshold)
        {
          displayTwo.setColor(location, new Color(0, 0, 0));
        }
        else
        {
          displayTwo.setColor(location, new Color(255, 255, 255));
        }
        
          
      }
    }
    
  }
  
  public static void autostereogram(GridDisplay display, GridDisplay displayThree, GridDisplay background)
  {
    int row, col;
    Location location, locationTwo;
    int NumRows, NumRowsThree;
    NumRows=display.getNumRows();
    NumRowsThree=displayThree.getNumRows();
    int NumCols, NumColsTwo, NumColsThree;
    NumCols=display.getNumCols();
    NumColsTwo=NumCols+300; System.out.println(NumColsTwo);
    NumColsThree=displayThree.getNumCols();
    GridDisplay displayTwo;
    displayTwo=new GridDisplay(NumRows, NumColsTwo); System.out.println(display.getNumCols());
    int red, green, blue, redThree, greenThree, blueThree;
    int redChange, greenChange, blueChange;
 
    
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<100; col=col+1)
      {
        location=new Location(row, col);
        red=display.getColor(location).getRed();
        green=display.getColor(location).getGreen();
        blue=display.getColor(location).getBlue();
        
        displayTwo.setColor(location, new Color(red, green, blue));
      }
    }  
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumColsTwo-100; col=col+1)
      {
        location=new Location(row, col);
        locationTwo=new Location(row, col+100);
        red=displayTwo.getColor(location).getRed();
        green=displayTwo.getColor(location).getGreen();
        blue=displayTwo.getColor(location).getBlue();
        
        displayTwo.setColor(locationTwo, new Color(red, green, blue));
      }
    }
    for (row=0; row<NumRowsThree-15; row=row+1)
    {
      for(col=0; col<NumColsThree-11; col=col+1)
      {
        location=new Location(row, col);
        locationTwo=new Location(row+120, col+100);
        redThree=displayThree.getColor(location).getRed();
        greenThree=displayThree.getColor(location).getGreen();
        blueThree=displayThree.getColor(location).getBlue();
        
        displayTwo.setColor(locationTwo, new Color(redThree, greenThree, blueThree));
      }
    }
    for (row=0; row<NumRows; row=row+1)
    {
      for(col=0; col<NumColsTwo-100; col=col+1)
      {
        location=new Location(row, col);
        locationTwo=new Location(row, col+80);
        
        red=displayTwo.getColor(location).getRed();
        green=displayTwo.getColor(location).getGreen();
        blue=displayTwo.getColor(location).getBlue();
        
        redChange=background.getColor(locationTwo).getRed();
        greenChange=background.getColor(locationTwo).getGreen();
        blueChange=background.getColor(locationTwo).getBlue();
        
        if(red<5 && green<5 && blue<5)
        {
        displayTwo.setColor(location, new Color(redChange, greenChange, blueChange));
        }
      }
    }

  }
    
}
  
  
  
