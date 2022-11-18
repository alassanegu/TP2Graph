package org.example;


import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.GraphParseException;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, ElementNotFoundException, IOException, GraphParseException {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("TP2 - Graphe");

        graph.read("D:/Graphes/TP2Graph/src/main/java/org/example/data/graph.dgs");
        graph.setAttribute("ui.stylesheet", "url('D:/Graphes/TP2Graph/src/main/java/org/example/data/style.css')");

    }
}