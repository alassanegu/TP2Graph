package org.example;

import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.GraphParseException;

import java.io.IOException;
import java.net.URISyntaxException;

public class Graphe {
    public static void main(String[] args) throws URISyntaxException, ElementNotFoundException, IOException, GraphParseException {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("TP2 - Graphe");

        graph.read("D:/Graphes/TP2Graph/src/main/java/org/example/data/graph.dgs");
        graph.setAttribute("ui.stylesheet", "url('D:/Graphes/TP2Graph/src/main/java/org/example/data/style.css')");
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        //graph.forEach(n -> n.setAttribute("ui.label", n.getId()));


        DephfirstSeach dfs = new DephfirstSeach();
        dfs.init(graph);
        dfs.compute();
        graph.forEach(v -> v.setAttribute("ui.label",
                v.getId() + " " + dfs.getPre(v) + " " + dfs.getPost(v)));
      /* graph.edges().forEach(e -> {
            Node u = e.getSourceNode();
            Node v = e.getTargetNode();
            if (dfs.getPre(u) < dfs.getPre(v) && dfs.getPost(v) < dfs.getPost(u)){
                e.setAttribute("ui.class","forward");
            } else if (dfs.getPre(v) < dfs.getPre(u) && dfs.getPost(u) < dfs.getPost(v)) {
                e.setAttribute("ui.class","back");
            }else {
                e.setAttribute("ui.class","crossing");
            }
        });*/


        /*StronglyConnectedComponents scc = new StronglyConnectedComponents();
        scc.init(graph);
        scc.compute();
        graph.forEach(v -> v.setAttribute("ui.label", v.getId() + " " + scc.getScc(v) ));*/




        graph.display(false);
    }
}
