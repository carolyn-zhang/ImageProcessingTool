import java.util.*;

public class ImageProcessor
{
  public static void main(String[] args)
  {
    System.out.println("type picture file name");
    String file = new Scanner(System.in).nextLine();
    GridDisplay d = new GridDisplay(file);

    waitForClick(d);
    
    System.out.println("negate");
    Lab6.negate(d);
    waitForClick(d);
    
    System.out.println("grayScale");
    d.load(file);
    Lab6.grayScale(d);
    waitForClick(d);
    
    System.out.println("reduceColors 14");
    d.load(file);
    Lab6.reduceColors(d, 14);
    waitForClick(d);
    
    System.out.println("reduceColors 42");
    d.load(file);
    Lab6.reduceColors(d, 42);
    waitForClick(d);
    
    System.out.println("reduceColors 127");
    d.load(file);
    Lab6.reduceColors(d, 127);
    waitForClick(d);
    
    System.out.println("tint less red");
    d.load(file);
    Lab6.tint(d, 0.4, 1, 1);
    waitForClick(d);

    System.out.println("tint more green");
    Lab6.tint(d, 1, 1.7, 1);
    waitForClick(d);

    System.out.println("tint more blue");
    Lab6.tint(d, 1, 1, 10);
    waitForClick(d);
    
    System.out.println("flip");
    Lab6.flip(d);
    waitForClick(d);

    //BONUS
    /*System.out.println("blend");
    Lab6Bonus.blendOrig(d, new GridDisplay("ocean.jpg"));
    waitForClick(d);*/

    System.out.println("green screen");
    Lab6Bonus.greenScreen(new GridDisplay("owl.jpg"), new GridDisplay("sky.jpg"));

    waitForClick(d);

    System.out.println("edge detection");
    Lab6Bonus.newEdgeDetection(d, 30);



  }
  
  public static void waitForClick(GridDisplay d)
  {
    while (d.checkLastLocationClicked() == null)
      d.pause(0.1);
  }
}