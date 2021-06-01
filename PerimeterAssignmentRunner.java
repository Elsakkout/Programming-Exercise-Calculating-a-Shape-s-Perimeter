import edu.duke.*;
import java.io.File;
public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        for (Point Pt : s.getPoints()){
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length = getPerimeter(s);
        int count = getNumPoints(s);
        double avrlength = length/count;
        return avrlength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double lrgside = 0.0;
        
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            lrgside = Double.max(lrgside, currDist);
            prevPt = currPt;
        }
        
        return lrgside;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double lrgX = 0.0;
        
        for (Point Pt : s.getPoints()){
            double getX = Pt.getX();
            lrgX = Double.max(lrgX, getX);
            
        }
        
        return lrgX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double lrgpr = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double calcpr = getPerimeter(s);
            for (Point Pt : s.getPoints()){
                lrgpr = Double.max(lrgpr, calcpr);
            }
        }
        return lrgpr;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double lrgpr = 0.0;
        File lrgF = null;    // replace this code
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double calcpr = getPerimeter(s);
            if (calcpr > lrgpr){
                lrgpr = calcpr;
                lrgF = f;
            }
        }
        return lrgF.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int count = getNumPoints(s);
        System.out.println("Number of Points : " + count);
        double average = getAverageLength(s);
        System.out.println("Average of Sides : " + average);
        double large = getLargestSide(s);
        System.out.println("Largest Side = " + large);
        double largeX = getLargestX(s);
        System.out.println("Largest X = " + largeX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double lrgpr = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter = " + lrgpr);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String LargeF = getFileWithLargestPerimeter();
        System.out.println("Largest File Name = " + LargeF);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
