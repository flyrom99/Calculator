public class Point {
    double x;
    double y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public Point(Point o)
    {
        this.x = o.x;
        this.y = o.y;
    }
    public double getX()
    {
        return this.x;
    }
    public double getY()
    {
        return this.y;
    }
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
