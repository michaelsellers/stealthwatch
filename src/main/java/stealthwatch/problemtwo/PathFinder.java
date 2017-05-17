package stealthwatch.problemtwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import stealthwatch.GNode;

// I would rather have worked with List instead of ArrayList but the requirements stated as such.  
// If this were a real life scenario I would have consulted with the person who created the requirement 
// to find out if it was a necessity, an oversight or a coding style difference.
public class PathFinder {
	public ArrayList<ArrayList<GNode>> paths(GNode node) {
		List<ArrayList<GNode>> nodePaths = Arrays.stream(node.getChildren())
			    .flatMap(PathFinder::determinePath).map(list -> {
					list.add(0, node); 
					return list;
				}).collect(Collectors.toList());
		return new ArrayList<ArrayList<GNode>>(nodePaths);
	}

	private static Stream<ArrayList<GNode>> determinePath(GNode node) {
		ArrayList<ArrayList<GNode>> childPaths = new ArrayList<>();
		Arrays.asList(node.getChildren()).forEach(child -> {
			childPaths.addAll(determinePath(child).collect(Collectors.toList()));
		});
		
		// add list for each leaf
		if (node.getChildren().length == 0) {
			childPaths.add(new ArrayList<GNode>());
		}
		
		// collect the nodes when returning up the stack
		childPaths.forEach(path -> path.add(0, node));
		return childPaths.stream();
	}
}
