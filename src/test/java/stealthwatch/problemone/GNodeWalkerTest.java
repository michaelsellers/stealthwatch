package stealthwatch.problemone;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import stealthwatch.GNode;
import stealthwatch.GraphNode;

//Implement a function with the following signature:
//
//    public ArrayList walkGraph(GNode);
//
//which should return a ArrayList containing every GNode in the
//graph. Each node should appear in the ArrayList exactly once
//(i.e. no duplicates).

public class GNodeWalkerTest extends GNodeWalker {

	private GNodeWalker walker;

	@Before
	public void setup() {
		walker = new GNodeWalker();	
	}
	
	// consider a builder
	@Test
	public void happyPath() {
		GNode twoOne = new GraphNode("2.1");
		GNode twoTwo = new GraphNode("2.2");
		GNode oneOne = new GraphNode("1.1", twoOne, twoTwo);
		GNode oneTwo = new GraphNode("1.2");
		GNode root = new GraphNode("root", oneOne, oneTwo);
		
		ArrayList<GNode> flattened = walker.walkGraph(root);
		
		assertEquals(new ArrayList<>(Arrays.asList(oneOne, twoOne, twoTwo, oneTwo, root)), flattened);
	}
}
