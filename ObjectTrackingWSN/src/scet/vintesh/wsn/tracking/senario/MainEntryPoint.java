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

import scet.vintesh.wsn.tracking.ds.Graph;

/**
 *
 * @author Vintesh
 */
public class MainEntryPoint {

    public static void main(String[] args) {
        Senario senario = new Senario();
        Graph graph = senario.getGraph();

        senario.applyLFFT(graph);
    }

}
