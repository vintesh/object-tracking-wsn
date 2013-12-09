/*
 * Implemented as Tutorial of Masters Program 
 * M.E. - Computer Engineering 
 * <SubjectName>
 * SCET, Surat
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scet.vintesh.wsn.tracking.senario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import scet.vintesh.wsn.tracking.ds.Edge;
import scet.vintesh.wsn.tracking.ds.Graph;
import scet.vintesh.wsn.tracking.ds.Location;
import scet.vintesh.wsn.tracking.ds.Node;

/**
 *
 * @author Vintesh
 */
public class Senario {

    Graph graph = new Graph();

    public Senario() {
        loadSenario1();
    }

    public Graph getGraph() {
        return graph;
    }

    /**
     * Initialize the Graph with proper nodes & edges Configuration 1 -
     * _2009_ELSEVIER_An efficient location tracking structure for wireless
     * sensor networks_TAP
     */
    public void loadSenario1() {
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        // =============== Configuration - 1
        nodes.add(new Node(0, new Location(5, 5)));
        nodes.add(new Node(1, new Location(4, 0)));
        nodes.add(new Node(2, new Location(9, 4)));
        nodes.add(new Node(3, new Location(8, 8)));
        nodes.add(new Node(4, new Location(2, 4)));
        nodes.add(new Node(5, new Location(1, 7)));
        nodes.add(new Node(6, new Location(1, 1)));
        nodes.add(new Node(7, new Location(5, 2)));
        nodes.add(new Node(8, new Location(7, 6)));
        nodes.add(new Node(9, new Location(1, 4)));
        graph.setNodes(nodes);

        try {
            edges.add(new Edge(graph.getNodeWithIdentifier(1), graph.getNodeWithIdentifier(6), 120));
            edges.add(new Edge(graph.getNodeWithIdentifier(1), graph.getNodeWithIdentifier(7), 154));
            edges.add(new Edge(graph.getNodeWithIdentifier(1), graph.getNodeWithIdentifier(2), 73));
            edges.add(new Edge(graph.getNodeWithIdentifier(6), graph.getNodeWithIdentifier(7), 57));
            edges.add(new Edge(graph.getNodeWithIdentifier(6), graph.getNodeWithIdentifier(4), 120));
            edges.add(new Edge(graph.getNodeWithIdentifier(6), graph.getNodeWithIdentifier(9), 135));
            edges.add(new Edge(graph.getNodeWithIdentifier(7), graph.getNodeWithIdentifier(4), 151));
            edges.add(new Edge(graph.getNodeWithIdentifier(7), graph.getNodeWithIdentifier(0), 142));
            edges.add(new Edge(graph.getNodeWithIdentifier(7), graph.getNodeWithIdentifier(2), 42));
            edges.add(new Edge(graph.getNodeWithIdentifier(2), graph.getNodeWithIdentifier(0), 69));
            edges.add(new Edge(graph.getNodeWithIdentifier(2), graph.getNodeWithIdentifier(8), 125));
            edges.add(new Edge(graph.getNodeWithIdentifier(2), graph.getNodeWithIdentifier(3), 79));
            edges.add(new Edge(graph.getNodeWithIdentifier(9), graph.getNodeWithIdentifier(4), 63));
            edges.add(new Edge(graph.getNodeWithIdentifier(9), graph.getNodeWithIdentifier(5), 188));
            edges.add(new Edge(graph.getNodeWithIdentifier(4), graph.getNodeWithIdentifier(0), 84));
            edges.add(new Edge(graph.getNodeWithIdentifier(4), graph.getNodeWithIdentifier(5), 215));
            edges.add(new Edge(graph.getNodeWithIdentifier(0), graph.getNodeWithIdentifier(8), 128));
            edges.add(new Edge(graph.getNodeWithIdentifier(0), graph.getNodeWithIdentifier(3), 102));
            edges.add(new Edge(graph.getNodeWithIdentifier(0), graph.getNodeWithIdentifier(5), 89));
            edges.add(new Edge(graph.getNodeWithIdentifier(8), graph.getNodeWithIdentifier(3), 49));
            edges.add(new Edge(graph.getNodeWithIdentifier(5), graph.getNodeWithIdentifier(3), 70));
        } catch (IllegalAccessException ex) {
            System.out.println("Edge initialization problem. Check & Correct Edge list & configuration");
        }
        graph.setEdges(edges);
    }

    public void applyLFFT(Graph graph) throws IllegalAccessException {
        // Initializing parameters for LFFT Graph/Tree
        ArrayList<Node> lfftNodes = new ArrayList<>();
        ArrayList<Edge> lfftEdges = new ArrayList<>();
        try {
            // Taking sink node as Node-1
            lfftNodes.add(graph.getNodeWithIdentifier(1));
        } catch (IllegalAccessException ex) {
            System.out.println("Initialization Error in LFFT Construction. Sink Node not found.");
        }

        // Taking All Edges in decreasing order
//        Queue<Edge> edgesSorted = new PriorityQueue<Edge>();
        ArrayList<Edge> edgesSorted = new ArrayList<Edge>();

        for (Edge edge : graph.getEdges()) {
            edgesSorted.add(edge);
        }
        Collections.sort(edgesSorted);

        System.out.println("EDGE QUEUE:");
        for (Edge edge : edgesSorted) {
            System.out.println(edge);
        }
        System.out.println("OVER");

        while (true) {
            int totalNoOfEdges = edgesSorted.size();
            for (int i = 0; i < totalNoOfEdges; i++) {
                Edge edge = edgesSorted.get(i);
                if (edge != null) {
                    Node node1 = edge.getNode1();
                    Node node2 = edge.getNode2();
                    if (lfftNodes.contains(node1) && !lfftNodes.contains(node2)) {
                        if (!lfftEdges.contains(edge)) {
                            lfftEdges.add(edge);
                            edgesSorted.remove(edge);
                            lfftNodes.add(node2);
                            break;
                        }
                    }
                    if (lfftNodes.contains(node2) && !lfftNodes.contains(node1)) {
                        if (!lfftEdges.contains(edge)) {
                            lfftEdges.add(edge);
                            edgesSorted.remove(edge);
                            lfftNodes.add(node1);
                            break;
                        }
                    }
                }
            }
            if (isAllNodesAreAdded(lfftNodes, graph.getNodes())) {
                break;
            }
        }

        printLFFT(lfftEdges, lfftNodes);
    }

    private boolean isAllNodesAreAdded(ArrayList<Node> lfftNodes, ArrayList<Node> graphNodes) {
        for (Node node : graphNodes) {
            if (!lfftNodes.contains(node)) {
                return false;
            }
        }
        return true;
    }

    private void printLFFT(ArrayList<Edge> lfftEdges, ArrayList<Node> lfftNodes) {
        System.out.println("EDGEs: " + lfftEdges.size());
        System.out.println(Arrays.toString(lfftEdges.toArray()));
        System.out.println("NODEs: " + lfftNodes.size());
        System.out.println(Arrays.toString(lfftNodes.toArray()));
    }
}
