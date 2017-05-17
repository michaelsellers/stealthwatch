package stealthwatch.problemtwo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import stealthwatch.GNode;
import stealthwatch.GraphNode;


//Implement a function with the following signature:
//
//    public ArrayList paths(GNode node);
//
//which should return a ArrayList of ArrayLists, representing all
//possible paths through the graph starting at 'node'. The ArrayList
//returned can be thought of as a ArrayList of paths, where each path
//is represented as an ArrayList of GNodes.
//
//Example:
//Assume the following graph:
//
//A
// B
//   E
//   F
// C
//   G
//   H
//   I
// D
//   J
//
//paths(A) = ( (A B E) (A B F) (A C G) (A C H) (A C I) (A D J) )

public class PathFinderTest {

	private PathFinder pathFinder;
	
	// unnecessary here but good for completeness.
	@Before
	public void setup() {
		pathFinder = new PathFinder();	
	}
	
	@Test
	public void testPaths() {
		GNode j = new GraphNode("J");
		GNode i = new GraphNode("I");
		GNode h = new GraphNode("H");
		GNode g = new GraphNode("G");
		GNode f = new GraphNode("F");
		GNode e = new GraphNode("E");
		GNode d = new GraphNode("D", j);
		GNode c = new GraphNode("C", g, h ,i);
		GNode b = new GraphNode("B", e, f);
		GNode a = new GraphNode("A", b, c, d);
		
		ArrayList<ArrayList<GNode>> paths = pathFinder.paths(a);

		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<GNode>> expected = list(list(a,b,e), list(a, b, f), list(a, c, g), list(a, c, h), list(a, c, i), list(a, d, j));
		assertEquals(expected, paths);
	}

	private ArrayList<ArrayList<GNode>> list(@SuppressWarnings("unchecked") ArrayList<GNode>... lists) {
		return new ArrayList<>(Arrays.asList(lists));
	}

	private ArrayList<GNode> list(GNode... nodes) {
		return new ArrayList<>(Arrays.asList(nodes));
	}

}
