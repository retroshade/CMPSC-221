/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author captj_000
 * Ryan Mysliwiec
 */
public abstract class Shapes {

    //declarations of private variable
    //will be made avaiable to all classes that extend Shapes
    private double base;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Instantiate variables of each type of shape class
        Circle circle = new Circle(4.0);
        Square square = new Square(3.0);
        Triangle triangle = new Triangle(2.0, 4.0, 3.0, 4.0, 5.0);
        Sphere sphere = new Sphere(4.0);
        Cube cube = new Cube(5.0);  
        Tetrahedron tetra = new Tetrahedron(3.0);
        
        //declare an array of shapes with six indeces
        Shapes[] shapes = new Shapes[6];
        
        //add each variable to the array
        shapes[0] = circle;
        shapes[1] = square;
        shapes[2] = triangle;
        shapes[3] = sphere;
        shapes[4] = cube;
        shapes[5] = tetra;
        
        //loop while currentShape is still not null
        for(Shapes currentShape : shapes)
        {
            //if the currentShape is a two dimensional shape
            if(currentShape instanceof TwoDimensionalShapes)
            {
                //typecast shape1 as the same type as currentShape
                TwoDimensionalShapes shape1 = (TwoDimensionalShapes) currentShape;
                
                //print the area and perimeter
                System.out.println(shape1.toString());
            }
            
            //otherwise, if the currentShape is a three dimensional shape
            else if(currentShape instanceof ThreeDimensionalShapes)
            {
                //typecast shape2 as the same type as currentShape
                ThreeDimensionalShapes shape2 = (ThreeDimensionalShapes) currentShape;
                
                //print the area and the volume
                System.out.println(shape2.toString());
            }
        }
    }
    
    //abstract area method for use in subclasses
     public abstract double getArea();

     //Shapes constructor
     public Shapes(double base) {
         this.base = base;
     }
    /**
     * @return the base
     */
    public double getBase() {
        return base;
    }
    
}

//abstract two dimensoinal class
abstract class TwoDimensionalShapes extends Shapes {

    //two dimensional shape constructor
    public TwoDimensionalShapes(double base) {
        super(base);
    }
    
    //abstract perimeter method for use in subclasses
    public abstract double getPerimeter();
}

//abstract three dimensional class
abstract class ThreeDimensionalShapes extends Shapes {

    //three dimensional class constructor
    public ThreeDimensionalShapes(double base) {
        super(base);
    }
    
    //abstract volume method for use in sbubclasses
    public abstract double getVolume();
}

//circle class that is two dimensional shape
class Circle extends TwoDimensionalShapes {

    //circle constructor
    public Circle(double base) {
        super(base);
    }
    
    //override of getArea method
    @Override
    public double getArea(){
        return Math.PI*Math.pow(getBase(), 2);
    }
     
    //override of getPerimeter method
    @Override
    public double getPerimeter() {
        return 2*Math.PI*getBase();
    }
    
    //override of toString method
    @Override
    public String toString()
    {
        return String.format("Area of the circle: %.4f\nPerimeter of the circle: %.4f\n\n", 
                getArea(), getPerimeter());
    }
}

//square class that is two dimensional shape
class Square extends TwoDimensionalShapes {

    //square constructor
    public Square(double base) {
        super(base);
    }
     
    //override of getArea method
    @Override
    public double getArea(){
        return Math.pow(getBase(), 2);
    }
     
    //override of getPerimeter method
    @Override
    public double getPerimeter() {
        return 4*getBase();
    }

    //override of toString method
    @Override
    public String toString()
    {
        return String.format("Area of the square: %.4f\nPerimeter of the square: %.4f\n\n", 
                getArea(), getPerimeter());
    }
}

//triangle class that is two dimensional shape
class Triangle extends TwoDimensionalShapes {
    
    //declarations of private variables
    private double height;
    private double side1;
    private double side2;
    private double side3;

    //triangle constructor
    public Triangle(double base, double height, double side1, double side2, double side3) {
        super(base);
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    //override of getArea method
    @Override
    public double getArea(){
        return .5*getBase()*getHeight();
    }
     
    //override of getPerimeter method
    @Override
    public double getPerimeter() {
        return getSide1()+getSide2()+getSide3();
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the side1
     */
    public double getSide1() {
        return side1;
    }

    /**
     * @return the side2
     */
    public double getSide2() {
        return side2;
    }

    /**
     * @return the side3
     */
    public double getSide3() {
        return side3;
    }
    
    //override of toString method
    @Override
    public String toString()
    {
        return String.format("Area of the triangle: %.4f\nPerimeter of the triangle: %.4f\n\n", 
                getArea(), getPerimeter());
    }
}

//sphere class that is three dimensional shape
class Sphere extends ThreeDimensionalShapes {
    
    //sphere constructor
    public Sphere(double base) {
        super(base);
    }
        
    //override of getArea method
    @Override
    public double getArea(){
        return 4*Math.PI*Math.pow(getBase(), 2);
    }
     
    //override of getPerimeter method
    @Override
    public double getVolume() {
        return (4.0/3.0)*Math.PI*Math.pow(getBase(), 3);
    }

    //override of toString method
    @Override
    public String toString()
    {
        return String.format("Area of the sphere: %.4f\nVolume of the sphere: %.4f\n\n", 
                getArea(), getVolume());
    }
}

//cube class that is three dimensional shape
class Cube extends ThreeDimensionalShapes {
    
    //cube constructor
    public Cube(double base) {
        super(base);
    }
      
    //override of getArea method
    @Override
    public double getArea(){
        return 6*Math.pow(getBase(), 2);
    }
     
    //override of getPerimeter method
    @Override
    public double getVolume() {
        return Math.pow(getBase(), 3);
    }
    
    //override of toString method
    @Override
    public String toString()
    {
        return String.format("Area of the cube: %.4f\nVolume of the cube: %.4f\n\n", 
                getArea(), getVolume());
    }
}

//tetrahedron class that is three dimensional shape
class Tetrahedron extends ThreeDimensionalShapes {
    
    //tetrahedron constructor
    public Tetrahedron(double base) {
        super(base);
    }
     
    //override of getArea method
    @Override
    public double getArea(){
        return Math.sqrt(3.0)*Math.pow(getBase(), 2);
    }
     
    //override of getPerimeter method
    @Override
    public double getVolume() {
        return Math.pow(getBase(), 3)/(6*Math.sqrt(2));
    }

    //override of toString method
    @Override
    public String toString()
    {
        return String.format("Area of the tetrahedron: %.4f\nVolume of the tetrahedron: %.4f\n\n", 
                getArea(), getVolume());
    }
}