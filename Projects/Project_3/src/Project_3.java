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
        String coord = "";
        float x1, x2, y1, y2;
        try {
            InputStream in = new FileInputStream("lines.txt");
            InputStreamReader isr = new InputStreamReader(in); //, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            int numLines = Integer.parseInt( br.readLine() );
            while ((input = br.readLine()) != null) {
                System.out.println(input);
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
                System.out.println(x1 + " " + x2 + " " + y1 + " " + y2);
                nums.clear();
                if (lines.size() > 0) {
                    intersections = getIntersections(new Lines(new Point(x1, y1), new Point(x2, y2)), lines); // intersections for the new line
                    segments = findSegments(intersections, new Lines(new Point(x1, y1), new Point(x2, y2)));  //
                    // for each segment
                    for (int o = 0; o < segments.size(); o++) {
                        //System.out.println("Which segment: " + o);
                        tree.insert(segments.get(o));
                    }
                    lines.add(new Lines(new Point(x1, y1), new Point(x2, y2)));
                }
                else {  // just insert the first line
                    lines.add(new Lines(new Point(x1, y1), new Point(x2, y2)));
                    tree.insert(lines.get(0));
                }
            }
            tree.printPreOrder();
            //System.out.println(tree.parentNode.line.p1.x + " " + tree.parentNode.line.p1.y + " " + tree.parentNode.line.p2.x + " " + tree.parentNode.line.p2.y);
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Point> getIntersections(Lines ref, List<Lines> lines) { // pass the parent node
        List<Point> intscts = new ArrayList<>();
        // algorithm to compute intersections
        Point ix = new Point(0,0);
        for (int i = 0; i < lines.size(); i++) {
            // check to see if lines intersect
            if (((ref.p1.x - ref.p2.x) * (lines.get(i).p1.y - lines.get(i).p2.y) - (ref.p1.y - ref.p2.y) * (lines.get(i).p1.x - lines.get(i).p2.x)) > 0.01) {
                ix.setPoint( ((ref.p1.x*ref.p2.y - ref.p1.y*ref.p2.x) * (lines.get(i).p1.x - lines.get(i).p2.x) - (ref.p1.x - ref.p2.x) * (lines.get(i).p1.x * lines.get(i).p2.y - lines.get(i).p1.y * lines.get(i).p2.x)) / ((ref.p1.x - ref.p2.x) * (lines.get(i).p1.y - lines.get(i).p2.y) - (ref.p1.y - ref.p2.y) * (lines.get(i).p1.x - lines.get(i).p2.x)),
                             ((ref.p1.x*ref.p2.y - ref.p1.y*ref.p2.x) * (lines.get(i).p1.y - lines.get(i).p2.y) - (ref.p1.y - ref.p2.y) * (lines.get(i).p1.x * lines.get(i).p2.y - lines.get(i).p1.y * lines.get(i).p2.x)) / ((ref.p1.x - ref.p2.x) * (lines.get(i).p1.y - lines.get(i).p2.y) - (ref.p1.y - ref.p2.y) * (lines.get(i).p1.x - lines.get(i).p2.x)));
                // check if intersection point is within bounds
                if (ix.x > 0.0 && ix.x < 1.0 && ix.y > 0.0 && ix.y < 1.0) {
                    intscts.add(ix);
                }
            }
        }
        for (int i = 0; i < intscts.size(); i++) {
            System.out.println("Segments: " + intscts.get(i).x + " " + intscts.get(i).y);
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
//        for (int i = 0; i < intscts.size(); i++) {
//            System.out.println("Segments: " + intscts.get(i).x + " " + intscts.get(i).y);
//        }
        List<Lines> segs = new ArrayList<>();
        for (int o = 0; o < intscts.size()-1; o++) {
            segs.add(new Lines( new Point(intscts.get(o).x, intscts.get(o).y), new Point(intscts.get(o+1).x, intscts.get(o+1).y) ));
        }
        return segs;
    }
}