package classTask1;

public class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    Point(){
        //this(0,0);
    }

    double distance(int x, int y){
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    //double distance(Point p){
        //return distance(p.x,p.y);
    }
