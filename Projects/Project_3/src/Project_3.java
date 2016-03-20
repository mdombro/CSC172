import java.util.List;

public class Project_3 {
    public static void main(String[] args) {
        // all this is in a loop reading the incoming line coordinates
        // read a set of coordinates
        List<Float> intscts = getIntersection(x1, y1, x2, y2, tree.parenNode, intersections, lines); // intersections for the new line
        lines.add(x1);
        lines.add(y1);
        lines.add(x2);
        lines.add(y2);
        List<Float> segments = findSegments(intscts, x1, y1, x2, y2);  //
        // for each segment
            t.insert(endpoints); // the insert function will need to be redone to calculate c/cw on each line recursively
    }


    public <T> List<T> getIntersections(float x1, float y1, float x2, float y2, MyTreeNode node, List<T> intersections, List<T> lines) { // pass the parent node
        // algorithm to compute intersections

        for (int i = 0; i < lines.size()/4; i++) {
            lines[i]; // x1
            lines[i+1]; // y1
            lines[i+2]; // x2
            lines[i+3]; // y2
        }
        return intersections;
    }
}