/**
 * Created by matthew on 3/23/16.
 */
public class Lines {
    Point p1;
    Point p2;
    Lines(Point ps, Point pe) {
        p1 = ps;
        p2 = pe;
    }

    public Point midpoint() {
        return new Point((p1.x+p2.x)/2, (p1.y+p2.y)/2);
    }

}
