/*
 * Implemented as Tutorial of Masters Program 
 * M.E. - Computer Engineering 
 * <SubjectName>
 * SCET, Surat
 */
package scet.vintesh.wsn.tracking.ds;

import java.util.Objects;

/**
 *
 * @author Vintesh
 */
public final class Edge implements Comparable<Edge> {

    // Indicates two nodes which are endpoints of the Edge
    private Node node1;
    private Node node2;
    // Event Rate of Edge i.e. no of object crossing from NODE1 to NODE2
    private int eventRate;

    public Edge(Node node1, Node node2, int eventRate) {
        this.node1 = node1;
        this.node2 = node2;
        this.eventRate = eventRate;
    }

    public int getEventRate() {
        return eventRate;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    @Override
    public String toString() {
        return "Edge(" + node1.getNodeId() + "," + node2.getNodeId() + ") @" + eventRate;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.getEventRate() > o.getEventRate()) {
            return -1;
        } else if (this.getEventRate() < o.getEventRate()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object object) {
        Edge obj = (Edge) object;
        if ((obj.getNode1().getNodeId() == this.getNode1().getNodeId())
                && (obj.getNode2().getNodeId() == this.getNode2().getNodeId())
                && (this.getEventRate() == obj.getEventRate())) {
            return true;
        } else {
            return false;
        }
    }

//    @Override
//    public int compare(Edge o1, Edge o2) {
//        if (o1.getEventRate() > o2.getEventRate()) {
//            return 1;
//        } else if (o1.getEventRate() < o2.getEventRate()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.node1);
        hash = 83 * hash + Objects.hashCode(this.node2);
        hash = 83 * hash + this.eventRate;
        return hash;
    }
}
