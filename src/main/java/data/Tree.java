/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
import lombok.Getter;

/**
 * A generic binary tree implementation using the Visitor pattern for traversals.
 * <p>
 * This tree uses the Null Object pattern to avoid null checks - empty positions
 * in the tree are represented by {@link EmptyNode} instances rather than null references.
 * <p>
 * Example usage:
 * <pre>{@code
 * // Create a tree from an array
 * Tree&lt;Integer&gt; tree = new Tree&lt;&gt;(new Integer[]{1, 2, 3, 4, 5});
 *
 * // Traverse the tree
 * tree.traverse(new PreOrder(node -&gt; System.out.println(node.data)));}
 * </pre>
 *
 * @param <T> the type of data stored in the tree nodes
 */
@Getter
public class Tree<T>
{
	/**
	 * The root node of the tree. Initialized as an EmptyNode for an empty tree.
	 */
	private EmptyNode root = new EmptyNode();

	/**
	 * Creates an empty tree.
	 */
	public Tree()
	{
	}

	/**
	 * Creates a tree from an array using level-order insertion.
	 * <p>
	 * The array is interpreted as a complete binary tree where:
	 * <ul>
	 *   <li>Element at index <code>i</code> has left child at index <code>2*i+1</code></li>
	 *   <li>Element at index <code>i</code> has right child at index <code>2*i+2</code></li>
	 * </ul>
	 * Null elements in the array create empty positions in the tree.
	 *
	 * @param elements the array of elements to build the tree from
	 */
	public Tree(T[] elements)
	{
		if (elements != null && elements.length > 0)
		{
			root = buildTreeLevelOrder(elements, 0);
		}
	}

	/**
	 * Recursively builds a tree from an array using level-order (breadth-first) structure.
	 * <p>
	 * This method is used internally by the constructor to map array indices
	 * to tree positions in a complete binary tree layout.
	 *
	 * @param elements the array of elements
	 * @param index    the current index being processed
	 * @return the node at this position, or null if the position is empty
	 */
	private Node<T> buildTreeLevelOrder(T[] elements, int index)
	{
		if (index >= elements.length || elements[index] == null)
		{
			return null;
		}

		Node<T> node = new Node<>(elements[index]);

		Node<T> leftChild = buildTreeLevelOrder(elements, 2 * index + 1);
		Node<T> rightChild = buildTreeLevelOrder(elements, 2 * index + 2);

		node.left = (leftChild != null) ? leftChild : new EmptyNode();
		node.right = (rightChild != null) ? rightChild : new EmptyNode();

		return node;
	}

	/**
	 * Creates a balanced Binary Search Tree from a sorted array.
	 * <p>
	 * The middle element becomes the root, with recursively balanced left
	 * and right subtrees. This ensures O(log n) height for the tree.
	 * <p>
	 * <strong>Important:</strong> The input array must be sorted for the resulting
	 * tree to maintain BST properties.
	 *
	 * @param <T>      the type of elements in the tree
	 * @param elements a sorted array of elements
	 * @return a balanced BST containing the elements
	 */
	public static <T> Tree<T> fromSortedArray(T[] elements)
	{
		Tree<T> tree = new Tree<>();
		if (elements != null && elements.length > 0)
		{
			tree.root = buildBalancedBST(elements, 0, elements.length - 1);
		}
		return tree;
	}

	/**
	 * Recursively builds a balanced BST from a sorted array segment.
	 * <p>
	 * Selects the middle element of the range as the parent node and
	 * recursively builds left and right subtrees from the remaining elements.
	 *
	 * @param <T>      the type of elements
	 * @param elements the sorted array
	 * @param start    the starting index of the current segment (inclusive)
	 * @param end      the ending index of the current segment (inclusive)
	 * @return the root node of the balanced subtree for this segment
	 */
	private static <T> Node<T> buildBalancedBST(T[] elements, int start, int end)
	{
		if (start > end)
		{
			return null;
		}

		int mid = start + (end - start) / 2;
		Node<T> node = new Node<>(elements[mid]);

		Node<T> leftChild = buildBalancedBST(elements, start, mid - 1);
		Node<T> rightChild = buildBalancedBST(elements, mid + 1, end);

		node.left = (leftChild != null) ? leftChild : new EmptyNode();
		node.right = (rightChild != null) ? rightChild : new EmptyNode();

		return node;
	}

	/**
	 * Traverses the tree in pre-order using the specified action.
	 * <p>
	 * This is a convenience method that uses pre-order traversal by default.
	 *
	 * @param action the action to perform on each node
	 */
	public void traverse(Consumer<Node<?>> action)
	{
		traverse(new PreOrder(action));
	}

	/**
	 * Traverses the tree using the specified visitor strategy.
	 * <p>
	 * This is the main entry point for tree traversal. Pass in any of the
	 * visitor implementations (PreOrder, InOrder, PostOrder, LevelOrder) with
	 * a Consumer action to perform on each node.
	 *
	 * @param visitor the visitor that defines the traversal strategy and action
	 */
	public void traverse(Visitor visitor)
	{
		root.accept(visitor);
	}

	/**
	 * Represents an empty position in the tree (Null Object pattern).
	 * <p>
	 * This class provides do-nothing implementations of accept methods,
	 * eliminating the need for null checks throughout the traversal code.
	 */
	public static class EmptyNode
	{
		/**
		 * Accept method for depth-first visitors. Does nothing for empty nodes.
		 *
		 * @param visitor the visitor attempting to visit this node
		 */
		void accept(Visitor visitor)
		{
		}

		/**
		 * Accept method for level-order visitor. Does nothing for empty nodes.
		 *
		 * @param visitor the level-order visitor
		 * @param data    the queue used for breadth-first traversal
		 */
		void accept(LevelOrder visitor, Queue<EmptyNode> data)
		{
		}
	}

	/**
	 * Represents a node in the binary tree containing data and child references.
	 * <p>
	 * Nodes can be constructed manually using the fluent {@link #left(Node)} and
	 * {@link #right(Node)} methods, or automatically via tree construction methods.
	 *
	 * @param <T> the type of data stored in this node
	 */
	@Getter
	public static class Node<T> extends EmptyNode
	{
		/**
		 * The data stored in this node
		 */
		T node;
		/**
		 * The left child (either a Node or EmptyNode)
		 */
		EmptyNode left = new EmptyNode();
		/**
		 * The right child (either a Node or EmptyNode)
		 */
		EmptyNode right = new EmptyNode();

		/**
		 * Creates a new node with the specified data.
		 *
		 * @param data the data to store in this node
		 */
		Node(T data)
		{
			this.node = data;
		}

		/**
		 * Sets the left child of this node (fluent interface).
		 *
		 * @param node the node to set as left child
		 * @return this node for method chaining
		 */
		public Node<T> left(Node<?> node)
		{
			this.left = node;
			return this;
		}

		/**
		 * Sets the right child of this node (fluent interface).
		 *
		 * @param node the node to set as right child
		 * @return this node for method chaining
		 */
		public Node<T> right(Node<?> node)
		{
			this.right = node;
			return this;
		}

		/**
		 * Accepts a visitor for depth-first traversal strategies.
		 * <p>
		 * This implements double dispatch - the node delegates back to the
		 * visitor's visit method, allowing the visitor to execute its specific
		 * traversal logic.
		 *
		 * @param visitor the visitor performing the traversal
		 */
		void accept(Visitor visitor)
		{
			visitor.visit(this);
		}

		/**
		 * Accepts a level-order visitor for breadth-first traversal.
		 *
		 * @param visitor the level-order visitor
		 * @param data    the queue tracking nodes to visit
		 */
		void accept(LevelOrder visitor, Queue<EmptyNode> data)
		{
			visitor.visit(this, data);
		}
	}

	/**
	 * Abstract base class for tree traversal strategies (Visitor pattern).
	 * <p>
	 * Each concrete visitor implements a specific traversal order and executes
	 * the provided action on each visited node.
	 */
	private static abstract class Visitor
	{
		/**
		 * The action to perform on each visited node
		 */
		Consumer<Node<?>> action;

		/**
		 * Creates a visitor with the specified action.
		 *
		 * @param action the consumer function to execute on each node
		 */
		Visitor(Consumer<Node<?>> action)
		{
			this.action = action;
		}

		/**
		 * Visits a node according to the traversal strategy.
		 *
		 * @param <T>  the type of data in the node
		 * @param node the node to visit
		 */
		abstract <T> void visit(Node<T> node);
	}

	/**
	 * Pre-order traversal visitor (Root → Left → Right).
	 * <p>
	 * Visits the current node first, then recursively visits the left subtree,
	 * followed by the right subtree.
	 * <p>
	 * Useful for: creating a copy of the tree, prefix expression evaluation.
	 */
	public static class PreOrder extends Visitor
	{
		/**
		 * Creates a pre-order visitor with the specified action.
		 *
		 * @param action the action to perform on each node
		 */
		public PreOrder(Consumer<Node<?>> action)
		{
			super(action);
		}

		/**
		 * Visits nodes in pre-order: current node, left subtree, right subtree.
		 *
		 * @param <T>  the type of data in the node
		 * @param node the current node being visited
		 */
		<T> void visit(Node<T> node)
		{
			action.accept(node);
			node.left.accept(this);
			node.right.accept(this);
		}
	}

	/**
	 * In-order traversal visitor (Left → Root → Right).
	 * <p>
	 * Recursively visits the left subtree first, then the current node,
	 * then the right subtree.
	 * <p>
	 * Useful for: visiting BST nodes in sorted order, infix expression evaluation.
	 */
	public static class InOrder extends Visitor
	{
		/**
		 * Creates an in-order visitor with the specified action.
		 *
		 * @param action the action to perform on each node
		 */
		public InOrder(Consumer<Node<?>> action)
		{
			super(action);
		}

		/**
		 * Visits nodes in in-order: left subtree, current node, right subtree.
		 *
		 * @param <T>  the type of data in the node
		 * @param node the current node being visited
		 */
		<T> void visit(Node<T> node)
		{
			node.left.accept(this);
			action.accept(node);
			node.right.accept(this);
		}
	}

	/**
	 * Post-order traversal visitor (Left → Right → Root).
	 * <p>
	 * Recursively visits the left subtree, then the right subtree,
	 * and finally the current node.
	 * <p>
	 * Useful for: deleting/freeing nodes, postfix expression evaluation.
	 */
	public static class PostOrder extends Visitor
	{
		/**
		 * Creates a post-order visitor with the specified action.
		 *
		 * @param action the action to perform on each node
		 */
		public PostOrder(Consumer<Node<?>> action)
		{
			super(action);
		}

		/**
		 * Visits nodes in post-order: left subtree, right subtree, current node.
		 *
		 * @param <T>  the type of data in the node
		 * @param node the current node being visited
		 */
		<T> void visit(Node<T> node)
		{
			node.left.accept(this);
			node.right.accept(this);
			action.accept(node);
		}
	}

	/**
	 * Level-order (breadth-first) traversal visitor.
	 * <p>
	 * Visits nodes level by level from top to bottom, left to right,
	 * using a queue to track which nodes to visit next.
	 * <p>
	 * Useful for: finding shortest path, level-by-level processing,
	 * serialization for complete trees.
	 */
	public static class LevelOrder extends Visitor
	{
		/**
		 * Creates a level-order visitor with the specified action.
		 *
		 * @param action the action to perform on each node
		 */
		public LevelOrder(Consumer<Node<?>> action)
		{
			super(action);
		}

		/**
		 * Initiates level-order traversal starting from the given node.
		 * <p>
		 * This method sets up the queue and begins the breadth-first traversal.
		 *
		 * @param <T>  the type of data in the node
		 * @param node the starting node (typically the root)
		 */
		<T> void visit(Node<T> node)
		{
			Queue<EmptyNode> queue = new LinkedList<>();
			queue.add(node);
			do
			{
				queue.remove().accept(this, queue);
			} while (!queue.isEmpty());
		}

		/**
		 * Visits a single node during level-order traversal.
		 * <p>
		 * Performs the action on the current node and adds its children
		 * to the queue for subsequent processing.
		 *
		 * @param <T>   the type of data in the node
		 * @param node  the current node being visited
		 * @param queue the queue of nodes yet to be visited
		 */
		<T> void visit(Node<T> node, Queue<EmptyNode> queue)
		{
			action.accept(node);
			queue.add(node.left);
			queue.add(node.right);
		}
	}

	/**
	 * Returns a string representation of the tree using the specified traversal order.
	 *
	 * @param visitorClass the class of the visitor (PreOrder, InOrder, PostOrder, or LevelOrder)
	 * @return a string representation of the tree
	 */
	public String toString(Class<? extends Visitor> visitorClass)
	{
		StringBuilder sb = new StringBuilder("[");
		try
		{
			Visitor visitor = visitorClass.getDeclaredConstructor(Consumer.class)
				.newInstance((Consumer<Node<?>>) node -> {
					if (sb.length() > 1)
					{
						sb.append(", ");
					}
					sb.append(node.node);
				});
			root.accept(visitor);
		}
		catch (Exception e)
		{
			return "Error creating visitor: " + e.getMessage();
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Returns a string representation of the tree using pre-order traversal (default).
	 *
	 * @return a string representation of the tree in pre-order
	 */
	@Override
	public String toString()
	{
		return toString(PreOrder.class);
	}
}