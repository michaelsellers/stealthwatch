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
		List<ArrayList<GNode>> flattened = Arrays.stream(node.getChildren())
			    .flatMap(PathFinder::addTo).map(list -> {
					list.add(0, node); 
					return list;
				}).collect(Collectors.toList());
		return new ArrayList<ArrayList<GNode>>(flattened);
	}

	private static Stream<ArrayList<GNode>> addTo(GNode node) {
		ArrayList<ArrayList<GNode>> childPaths = new ArrayList<>();
		Arrays.asList(node.getChildren()).forEach(child -> {
			childPaths.addAll(addTo(child).collect(Collectors.toList()));
		});
		List<List<ArrayList<GNode>>> collect = Arrays.stream(node.getChildren()).map(child -> addTo(child).collect(Collectors.toList())).collect(Collectors.toList());
		// Arrays.stream(node.getChildren()).map(child ->
		// childPaths.addAll(addTo(child)));
		if (node.getChildren().length == 0) {
			childPaths.add(new ArrayList<GNode>());
		}
		childPaths.forEach(path -> path.add(0, node));
		// Arrays.stream(node.getChildren()).filter();
		return childPaths.stream();
	}
}
