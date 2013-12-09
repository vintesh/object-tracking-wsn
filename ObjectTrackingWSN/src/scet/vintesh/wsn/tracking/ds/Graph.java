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
package scet.vintesh.wsn.tracking.ds;

import java.util.ArrayList;

/**
 *
 * @author Vintesh
 */
public class Graph {

    // Set of Vertices
    private ArrayList<Node> nodes;
    // Set of Edges
    private ArrayList<Edge> edges;

    public Graph() {
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> vertices) {
        this.nodes = vertices;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
        for (Edge edge : edges) {
            edge.getNode1().addToOneHopNeighbors(edge.getNode2());
            edge.getNode2().addToOneHopNeighbors(edge.getNode1());
        }
        System.out.println("Configured nodes according to the edge list. Initialized...");
    }

    public Node getNodeWithIdentifier(int id) throws IllegalAccessException {
        for (Node node : nodes) {
            if (node.getNodeId() == id) {
                return node;
            }
        }
        System.out.println("From: Graph.java - Node with Id: " + id + " is not found");
        throw new IllegalAccessException("Node with Id: " + id + " is not found");
    }

//    public boolean isAllEdgesVisited() {
//        for (Edge edge : edges) {
//            if (!(edge.isVisited())) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public Edge findEdgeWithStartAndEndNodes(Node sourceNode, Node destinationNode) {
//        for (Edge edge : edges) {
//            if (edge.getSourceNode() == sourceNode && edge.getDestinationNode() == destinationNode) {
//                return edge;
//            }
//        }
//        return null;
//    }
}
