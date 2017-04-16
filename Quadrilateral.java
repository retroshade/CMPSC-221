/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Ryan Mysliwiec
rwm5592
CMPSC 221
9/16/15
10:11 PM
*/

package quadrilateral;

/**
 *
 * @author rwm5592
 */
public class Quadrilateral {

    /**
     * @param args the command line arguments
     */
    
    private Point TL;
    private Point TR;
    private Point BR;
    private Point BL;
    
    public Quadrilateral(Point TL, Point TR, Point BR, Point BL)
    {
        this.TL = TL;
        this.TR = TR;
        this.BR = BR;
        this.BL = BL;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Trapezoid coordinate points
        Point trapezoidTL = new Point(2.0, 4.0);
        Point trapezoidTR = new Point(5.0, 4.0);
        Point trapezoidBR = new Point(4.0, 2.0);
        Point trapezoidBL = new Point(3.0, 2.0);
       
        //Parallelogram coordinate points
        Point parallelogramTL = new Point(2.0, 4.0);
        Point parallelogramTR = new Point(5.0, 4.0);
        Point parallelogramBR = new Point(6.0, 2.0);
        Point parallelogramBL = new Point(3.0, 2.0);
       
        //Rectangle coordinate points
        Point rectangleTL = new Point(2.0, 4.0);
        Point rectangleTR = new Point(5.0, 4.0);
        Point rectangleBR = new Point(5.0, 2.0);
        Point rectangleBL = new Point(2.0, 2.0);
       
        //Square coordinate points
        Point squareTL = new Point(2.0, 4.0);
        Point squareTR = new Point(4.0, 4.0);
        Point squareBR = new Point(4.0, 2.0);
        Point squareBL = new Point(2.0, 2.0); 
        
        //define Trapezoid
        Trapezoid trap = new Trapezoid(trapezoidTL, trapezoidTR, trapezoidBR, trapezoidBL);
        System.out.printf("%s: %f\n", "The area of the trapezoid is", trap.trapArea());
        
        //define Parallelogram
        Parallelogram para = new Parallelogram(parallelogramTL, parallelogramTR, parallelogramBR, parallelogramBL);
        System.out.printf("%s: %f\n", "The area of the parallelogram is", para.parArea());
        
        //define Rectangle
        Rectangle rekt = new Rectangle(rectangleTL, rectangleTR, rectangleBR, rectangleBL);
        System.out.printf("%s: %f\n", "The area of the rectangle is", rekt.parArea());
        
        //define Square
        Square square = new Square(squareTL, squareTR, squareBR, squareBL);
        System.out.printf("%s: %f\n", "The area of the square is", square.parArea());
        
    }

    /**
     * @return the TL
     */
    public Point getTL() {
        return TL;
    }

    /**
     * @return the TR
     */
    public Point getTR() {
        return TR;
    }

    /**
     * @return the BR
     */
    public Point getBR() {
        return BR;
    }

    /**
     * @return the BL
     */
    public Point getBL() {
        return BL;
    }
    
}

class Trapezoid extends Quadrilateral 
{
    public Trapezoid(Point TL, Point TR, Point BR, Point BL)
    {
        super(TL, TR, BR, BL);
    }
    
    public double trapArea()
    {
        return .5*(getTR().getX()-getTL().getX()+getBR().getX()-getBL().getX())*(getTR().getY()-getBR().getY());
    }
}

class Parallelogram extends Quadrilateral 
{
    public Parallelogram(Point TL, Point TR, Point BR, Point BL)
    {
        super(TL, TR, BR, BL);
    }
    
   public double parArea()
   {
       return (getTR().getX()-getTL().getX())*(getTR().getY()-getBR().getY());
   }
}

class Rectangle extends Parallelogram 
{
    public Rectangle(Point TL, Point TR, Point BR, Point BL)
    {
        super(TL, TR, BR, BL);
    }
    
    @Override
    public double parArea()
    {
        //same as for parallelogram
        return (getTR().getX()-getTL().getX())*(getTR().getY()-getBR().getY());
    }
}

class Square extends Rectangle 
{
    public Square(Point TL, Point TR, Point BR, Point BL)
    {
        super(TL, TR, BR, BL);
    }
    
    @Override
    public double parArea()
    {
        return Math.pow(getTL().getX()-getTR().getX(),2);
    }
}

class Point
{
    private double x, y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }
}
