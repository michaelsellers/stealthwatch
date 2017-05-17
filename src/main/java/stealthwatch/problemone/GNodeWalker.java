package stealthwatch.problemone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import stealthwatch.GNode;

/**
 * Observe that this GNode can be thought of as defining a graph. 
 * In implementing the functions below, you can assume that:
 *  1) any graph defined by a GNode is acyclic (no cycles). 
 *  2) when a GNode has no children, getChildren() returns a array of size 0, and *not* null. 
 *  3) all children returned by getChildren() are not null.
 **/
//Implement a function with the following signature:
//    public ArrayList walkGraph(GNode);
//
//which should return a ArrayList containing every GNode in the
//graph. Each node should appear in the ArrayList exactly once
//(i.e. no duplicates).

public class GNodeWalker {
	public ArrayList<GNode> walkGraph(GNode root) {
		List<GNode> flattened = Arrays.stream(root.getChildren())
			    .flatMap(GNodeWalker::flatten)
			    .collect(Collectors.toList());
		flattened.add(root);
		return new ArrayList<>(flattened);
	}
	
    private static Stream<GNode> flatten(GNode node) {
        return Stream.concat(
            Stream.of(node), 
            Arrays.stream(node.getChildren()).flatMap(GNodeWalker::flatten));
    }
}
