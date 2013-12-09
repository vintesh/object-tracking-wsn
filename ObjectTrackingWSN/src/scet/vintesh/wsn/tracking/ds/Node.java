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
public class Node {

    private int nodeId;
    private Location location;
    // Indicats the One-Hop Neighbors
    private ArrayList<Node> oneHopNeighbor;

    public Node(int nodeId, Location location) {
        this.nodeId = nodeId;
        this.location = location;
        oneHopNeighbor = new ArrayList<>();
    }

    public Location getLocation() {
        return location;
    }

    public int getNodeId() {
        return nodeId;
    }

    public ArrayList<Node> getOneHopNeighbor() {
        return oneHopNeighbor;
    }

    public boolean addToOneHopNeighbors(Node neighbor) {
        for (Node node : oneHopNeighbor) {
            if (neighbor.getNodeId() == node.getNodeId()) {
                return true;
            }
        }
        return oneHopNeighbor.add(neighbor);
    }

    @Override
    public String toString() {
        return "ID: " + nodeId + " @" + location;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node node = (Node) obj;
            if (this.getNodeId() == node.getNodeId()) {
                return true;
            }
        }
        return false;
    }

}
