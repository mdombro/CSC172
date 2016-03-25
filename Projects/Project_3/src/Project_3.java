import java.util.*;
import java.io.*;

public class Project_3 {
    public static void main(String[] args) throws IOException {
        BinarySearchTree tree = new BinarySearchTree();
        List<Lines> lines = new ArrayList<>();
        List<Point> intersections = new ArrayList<>();
        List<Lines> segments = new ArrayList<>();

        String input;
        List<String> nums = new ArrayList<>();
        List<String> points = new ArrayList<>();
        String coord = "";
        float x1, x2, y1, y2;
        try {
            InputStream in = new FileInputStream("lines.txt");
            InputStreamReader isr = new InputStreamReader(in); //, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            int numLines = Integer.parseInt( br.readLine() );
            boolean pointsFlag = false;
            while ((input = br.readLine()) != null) {
                //System.out.println(input);
                if (input.charAt(0) == 'p') {
                    //System.out.println("YO");
                    pointsFlag = true;
                    System.out.println("Tree in InOrder print format:");
                    tree.printPreOrder();
                    System.out.println();
                    continue;
                }
                if (pointsFlag == false) {
                    for (int i = 0; i < input.length(); i++) {
                        if (input.charAt(i) != ' ') {
                            coord += input.charAt(i);
                        } else {
                            nums.add(coord);
                            coord = "";
                        }
                    }
                    nums.add(coord);
                    coord = "";
                    x1 = Float.parseFloat(nums.get(0));
                    y1 = Float.parseFloat(nums.get(1));
                    x2 = Float.parseFloat(nums.get(2));
                    y2 = Float.parseFloat(nums.get(3));
                    //System.out.println(x1 + " " + x2 + " " + y1 + " " + y2);
                    nums.clear();
                    if (lines.size() > 0) {
                        intersections = getIntersections(new Lines(new Point(x1, y1), new Point(x2, y2)), lines); // intersections for the new line
                        segments = findSegments(intersections, new Lines(new Point(x1, y1), new Point(x2, y2)));  //
                        // for each segment
                        for (int o = 0; o < segments.size(); o++) {
                            tree.insert(segments.get(o), lines.size()+1);
                        }
                        lines.add(new Lines(new Point(x1, y1), new Point(x2, y2)));
                    }
                    else {  // just insert the first line
                        lines.add(new Lines(new Point(x1, y1), new Point(x2, y2)));
                        tree.insert(lines.get(0), lines.size());
                    }
                }
                if (pointsFlag == true) {
                    for (int i = 0; i < input.length(); i++) {
                        if (input.charAt(i) != ' ') {
                            coord += input.charAt(i);
                        } else {
                            points.add(coord);
                            coord = "";
                        }
                    }
                    points.add(coord);
                    coord = "";
                    x1 = Float.parseFloat(points.get(0));
                    y1 = Float.parseFloat(points.get(1));
                    x2 = Float.parseFloat(points.get(2));
                    y2 = Float.parseFloat(points.get(3));
                    Point p1 = new Point(x1, y1);
                    Point p2 = new Point(x2, y2);
                    points.clear();

                    System.out.println("Points being tested: ");
                    System.out.println(p1.x + " " + p1.y);
                    System.out.println(p2.x + " " + p2.y);

                    int id = tree.lookup(p1, p2);
                    if (id == 0) {
                        System.out.println("The points are in the same region");
                        System.out.println();
                    }
                    else if (id == -1) {
                        System.out.println("Looks like your tree is empty");
                    }
                    else {
                        System.out.println("The points are in different regions");
                        System.out.println("They are seperated by: " + lines.get(id-1).p1.x + " " + lines.get(id-1).p1.y + " " + lines.get(id-1).p2.x + " " + lines.get(id-1).p2.y);
                        System.out.println();
                    }
                }
            }
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Point> getIntersections(Lines ref, List<Lines> lines) { // pass the parent node
        List<Point> intscts = new ArrayList<>();
        // algorithm to compute intersections
        for (int i = 0; i < lines.size(); i++) {
            float slopeRef = (ref.p2.y-ref.p1.y)/(ref.p2.x-ref.p1.x);
            float slopeLine = (lines.get(i).p2.y-lines.get(i).p1.y)/(lines.get(i).p2.x-lines.get(i).p1.x);
            if (Math.abs(slopeLine - slopeRef) > 0.001) {
                float c, d;
                if (ref.p1.x == 0)
                    c = ref.p1.y;
                else
                    c = ref.p2.y;
                if (lines.get(i).p1.x == 0)
                    d = lines.get(i).p1.y;
                else
                    d = lines.get(i).p2.y;
                Point intersect;
                if ((ref.p2.x - ref.p1.x) == 0) {
                    intersect = new Point(ref.p2.x, slopeLine*ref.p2.x + d);
                }
                else if ((lines.get(i).p2.x - lines.get(i).p1.x) == 0) {
                    intersect = new Point(lines.get(i).p2.x, slopeRef*lines.get(i).p2.x + c);
                }
                else {
                    intersect = new Point((d-c)/(slopeRef-slopeLine), (slopeRef*d-slopeLine*c)/(slopeRef-slopeLine));
                }
                if (intersect.x >= 0.0 && intersect.x <= 1.0 && intersect.y > 0.0 && intersect.y < 1.0) {
                        intscts.add(intersect);
                }
            }
        }
        return intscts;
    }

    public static List<Lines> findSegments(List<Point> intscts, Lines endpts) {
        intscts.add(endpts.p1);
        intscts.add(endpts.p2);
        if (endpts.p1.x != endpts.p2.x) {  // sort by x coord
            boolean flag = true;
            Point tmp;
            while (flag) {
                flag = false;
                for (int i = 1; i < intscts.size()-1; i++) {
                    if (intscts.get(i - 1).x > intscts.get(i).x) {
                        tmp = intscts.get(i - 1);
                        intscts.set(i - 1, intscts.get(i));
                        intscts.set(i, tmp);
                        flag = true;
                    }
                }
            }
        }
        else {  // sort by y coord
            boolean flag = true;
            Point tmp;
            while (flag) {
                flag = false;
                for (int i = 1; i < intscts.size()-1; i++) {
                    if (intscts.get(i - 1).y > intscts.get(i).y) {
                        tmp = intscts.get(i - 1);
                        intscts.set(i - 1, intscts.get(i));
                        intscts.set(i, tmp);
                        flag = true;
                    }
                }
            }
        }
        List<Lines> segs = new ArrayList<>();
        for (int o = 0; o < intscts.size()-1; o++) {
            segs.add(new Lines( new Point(intscts.get(o).x, intscts.get(o).y), new Point(intscts.get(o+1).x, intscts.get(o+1).y) ));
        }
        return segs;
    }
}
