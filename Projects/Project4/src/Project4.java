/***************************/
/***    Matt Dombroski  ****/
/***       Project 4    ****/
/***************************/

import java.io.*;
import java.util.*;

public class Project4 {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-show")) {
            System.out.println("GUI not implemented");
        }
        if (Arrays.asList(args).contains("-directions")) {

        }
        String input;
        HashMap<String, Node> nodes = new HashMap<>();
        try {
            InputStream in = new FileInputStream("Data/nys.txt");
            InputStreamReader isr = new InputStreamReader(in); //, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((input = br.readLine()) != null) {
                String[] read = input.split("\t");
                if (read[0].equals("i")) {  // process an intersection
                    double x = Double.valueOf(read[2]);
                    double y = Double.valueOf(read[3]);
                    Node inter = new Node(read[1], x, y);
                    nodes.put(read[1], inter);
                }
                else if (read[0].equals("r")) {
                    Node one = nodes.get(read[2]);
                    Node two = nodes.get(read[3]);
                    one.neighbors.add(two);
                    two.neighbors.add(one);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Could not find file");
            e.printStackTrace();
        }


        // if minimal path is requested
        String start, goal;
        ArrayList<Node> path = Dijkstra(start, goal, nodes);


//        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
//            Node j = entry.getValue();
//            System.out.println(j.ID);
//            for (int g = 0; g < j.neighbors.size(); g++) {
//                System.out.println("\t" + j.neighbors.get(g));
//            }
//        }
    }

    public static ArrayList<Node> Dijkstra(String startID, String goalID, HashMap<String, Node> nodes) {
        Node start = nodes.get(startID);
        Node goal = nodes.get(goalID);
        Comparator<Node> comp = new NodeComparator();
        PriorityQueue<Node> openList = new PriorityQueue<>(10, comp);
        openList.add(start);
        start.cost = 0;
        Node current;
        while (!openList.isEmpty()) {
            current = openList.remove();
            if (current.location.x == goal.location.x && current.location.y == goal.location.y) {
                break;
            }
            for (Node neighbor : current.neighbors) {
                double toCost = current.cost + computeCost(current, neighbor);
                if (!openList.contains(neighbor) || toCost < neighbor.cost) {
                    neighbor.cost = toCost;  // update the cost
                    openList.add(neighbor);
                    neighbor.from = current;
                }
            }
        }
        Node c = goal;
        ArrayList<Node> path = new ArrayList<>();
        path.add(c);
        while (c.location.x != start.location.x && c.location.y != start.location.y) {
            c = c.from;
            path.add(c);
        }
        Collections.reverse(path);
        return path;
    }

    public static double computeCost(Node from, Node to) {
        // algorithm from www.movable-type.co.uk/scripts/latlong.html
        // take the lattitude and longitude of both nodes and calculates the distance between them in miles
        double R = 6371000;     // metres
        double fromLat = toRadians(from.location.y);
        double fromLon = toRadians(from.location.x);
        double toLat = toRadians(to.location.y);
        double toLon = toRadians(to.location.x);
        double dLat = toRadians((toLat-fromLat));
        double dLon = toRadians((toLon-fromLon));

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(fromLat) * Math.cos(toLat) * Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return (R*c)/1609.344;  // convert meters into miles
    }

    public static double toRadians(double degree) {
        return degree*(Math.PI/180);
    }

}
