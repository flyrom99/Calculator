public class Point implements Comparable {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point o) {
        this.x = o.x;
        this.y = o.y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Object k) {
        Point o = (Point) k;
        double sumSquare = Math.pow(this.x, 2) + Math.pow(this.y, 2);
        double oSumSquare = Math.pow(o.x, 2) + Math.pow(o.y, 2);
        if (this.x == o.x && this.y == o.y)
            return 0;
        else if (sumSquare > oSumSquare)
            return (int) sumSquare;
        else
            return (int) oSumSquare;
    }
}