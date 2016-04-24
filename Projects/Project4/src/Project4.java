/***************************/
/***    Matt Dombroski  ****/
/***       Project 4    ****/
/***************************/

import java.io.*;
import java.util.*;

public class Project4 {
    public static void main(String[] args) throws IOException {
        String start = "";
        String goal = "";
        Boolean directions = false;
        Boolean MWST = false;
        double weight = 0;
        String filename = args[0];
        if (Arrays.asList((args)).contains("-show")) {
            System.out.println("GUI not implemented");
        }
        if (Arrays.asList(args).contains("-directions")) {
            directions = true;
            start = args[Arrays.asList(args).indexOf("-directions")+1];
            goal = args[Arrays.asList(args).indexOf("-directions")+2];
        }
        if (Arrays.asList(args).contains("-meridianmap")) {
            MWST = true;
        }
        if (Arrays.asList(args).contains("-weight")) {
            weight = Double.valueOf(args[Arrays.asList(args).indexOf("-weight")+1]);
        }
        String input;

        HashMap<String, Node> nodes = new HashMap<>();
        Comparator<Edge> comp = new EdgeComparator();
        PriorityQueue<Edge> edges = new PriorityQueue<>(10, comp);
        try {
            InputStream in = new FileInputStream("Data/" + filename);
            InputStreamReader isr = new InputStreamReader(in); //, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((input = br.readLine()) != null) {
                String[] read = input.split("\t");
                if (read[0].equals("i")) {  // process an intersection
                    double x = Double.valueOf(read[2]);  // latitude
                    double y = Double.valueOf(read[3]);  // longitude
                    Node inter = new Node(read[1], x, y);
                    nodes.put(read[1], inter);
                }
                else if (read[0].equals("r")) {
                    Node one = nodes.get(read[2]);
                    Node two = nodes.get(read[3]);
                    one.neighbors.add(two);
                    two.neighbors.add(one);
                    Edge e = new Edge(read[1], one, two, computeCost(one, two));
                    edges.add(e);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Could not find file");
            e.printStackTrace();
        }


        // if minimal path is requested
        ArrayList<Node> path;
        if (directions) {
            if (!nodes.containsKey(goal) || !nodes.containsKey(start))
                System.out.println("Sorry you entered an invalid start/destination");
            else {
                double Cost = 0;
                double pastCost = 0;
                System.out.println("Path: ");
                path = Dijkstra(start, goal, nodes, weight);
                pastCost = path.get(0).cost;
                System.out.print(path.get(0).ID + " ");
                for (int i = 1; i < path.size(); i++) {
                    Cost += path.get(i).cost-pastCost;
                    pastCost = path.get(i).cost;
                    System.out.print(path.get(i).ID + " ");
                }
                System.out.println();
                System.out.println("Distance in miles: " + Cost);
            }
        }

        // if MWST requested
        ArrayList<Edge> roads;
        if (MWST) {
            roads = Kruskal(edges);
            System.out.println("Roads taken: ");
            for (Edge r : roads) {
                System.out.print(r.ID + " ");
            }
            System.out.println();
            System.out.println("Size of MWST: " + roads.size());
        }
    }

    public static ArrayList<Edge> Kruskal(PriorityQueue<Edge> edges) {
        ArrayList<Edge> roads = new ArrayList<>();
        ArrayList<Edge> mwst = new ArrayList<>();
        while (!edges.isEmpty()) {
            roads.add(edges.poll());
        }
        for (Edge e : roads) {
            if (!e.a.visited || !e.b.visited) {
                mwst.add(e);
                e.a.visited = true;
                e.b.visited = true;
            }
        }
        return mwst;
    }

    public static ArrayList<Node> Dijkstra(String startID, String goalID, HashMap<String, Node> nodes, double weight) {
        Node start = nodes.get(startID);
        Node goal = nodes.get(goalID);
        Comparator<Node> comp = new NodeComparator();
        PriorityQueue<Node> openList = new PriorityQueue<>(10, comp);
        start.cost = 0;
        openList.add(start);
        Node current;
        while (!openList.isEmpty()) {
            current = openList.poll();
            current.visited = true;
            if (current.ID.equals(goal.ID)) {
                break;
            }
            for (Node neighbor : current.neighbors) {
                double toCost = current.cost + computeCost(current, neighbor);
                if (!neighbor.visited) {
                    if (toCost < neighbor.cost) {  // if its not known OR cost is better
                        neighbor.priority = toCost + weight*heuristic(neighbor, goal);
                        neighbor.cost = toCost;  // update the cost
                        openList.add(neighbor);
                        neighbor.from = current;
                    }
                }
            }
        }
        Node c = goal;
        ArrayList<Node> path = new ArrayList<>();
        path.add(c);
        while (!c.ID.equals(start.ID)) {
            c = c.from;
            path.add(c);
        }
        Collections.reverse(path);
        return path;
    }

    public static double heuristic(Node start, Node goal) {
        return computeCost(start, goal);
    }

    public static double computeCost(Node from, Node to) {
        // algorithm from www.movable-type.co.uk/scripts/latlong.html
        // take the lattitude and longitude of both nodes and calculates the distance between them in miles
        double R = 6371000;     // metres
        double fromLat = toRadians(from.location.x);
        double fromLon = toRadians(from.location.y);
        double toLat = toRadians(to.location.x);
        double toLon = toRadians(to.location.y);
        double dLat = toLat-fromLat;
        double dLon = toLon-fromLon;

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(fromLat) * Math.cos(toLat) * Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return (R*c)/1609.344;  // convert meters into miles
    }

    public static double toRadians(double degree) {
        return degree*(Math.PI/180);
    }

}
