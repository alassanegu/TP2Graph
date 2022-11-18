package org.example;


import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;

import java.util.function.Consumer;
import java.util.stream.Stream;
public class Explorer {

    private boolean respectDir;
    private Consumer<? super Node> preVisit;
    private Consumer<? super Node> postVisit;


    public Explorer(boolean respectDir, Consumer<? super Node> preVisit, Consumer<? super Node> postVisit) {
        this.respectDir = respectDir;
        this.preVisit = preVisit;
        this.postVisit = postVisit;
    }

    public void explore(Node v){
        v.setAttribute("visited");
        preVisit.accept(v);
        Stream<Edge> edges = respectDir ? v.leavingEdges() : v.enteringEdges();
        edges.map(e -> e.getOpposite(v)).filter(u -> !u.hasAttribute("visited")).forEach(this::explore);
        postVisit.accept(v);

    }

}

