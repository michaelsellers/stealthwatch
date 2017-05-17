package stealthwatch;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/* I chose to put the class into the same package but there but if there were different features 
 * each having a class implementing GNode then I may choose to put them in different packages based on feature.
*/
public class GraphNode implements GNode, Comparable<GraphNode> {
	
	private String name;
	private Set<GNode> children = new TreeSet<>();

	// I tend towards immutable classes but it depends on the case.
	public GraphNode(String name, GNode... graphNodes) {
		this.name = name;
		this.children.addAll(Arrays.asList(graphNodes));
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public GNode[] getChildren() {
		return children.toArray(new GNode[children.size()]);
	}
	
	public GraphNode addChild(GNode node) {
		children.add(node); 
		return this;
	}
	
    // I usually use HashCodeBuilder 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

    // I usually use EqualsBuilder 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	// I usually use ToStringBuilder
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(GraphNode that) {
		return this.name.compareTo(that.name);
	}
}
