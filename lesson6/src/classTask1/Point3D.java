package classTask1;

public class Point3D extends Point {
    int z;
    Point3D(int x, int y, int z){
        super(x,y);
        this.z = z;
    }
    //
    @Override
    double distance(int x, int y){
        double dx = (this.x/z) - x;
        double dy = (this.y/z) - y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public static void main(String args[]){
        Point3D p = new Point3D(30,20,10);
        System.out.println(p.distance(p.x,p.y));
    }
}
