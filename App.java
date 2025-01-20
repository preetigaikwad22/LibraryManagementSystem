class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double areaOfCircle() {
        return 3.14 * radius * radius;
    }
}

class Cylinder extends Circle{
    double height;

    Cylinder(double radius, double height){
        super(radius);
        this.height=height;
    }

    public double getHeight(){
        return height;
    }

    public double volumeOfCylinder(){
        return areaOfCircle() * height;
    }
}

public class App {
    public static void main(String[] args) {
        Cylinder myCylinder = new Cylinder(5, 10);

        System.out.println("Radius: "+myCylinder.getRadius());
        System.out.println("Height: "+myCylinder.getHeight());
        System.out.println("Area of Circle: "+myCylinder.areaOfCircle());
        System.out.println("Volume of Cylinder: "+myCylinder.volumeOfCylinder());
    }
}