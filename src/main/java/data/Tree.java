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

/**
 * Tree structure
 */
class Tree
{
	static class EmptyNode
	{
		void accept(Visitor visitor)
		{
		}

		void accept(LevelOrder visitor, Queue<EmptyNode> data)
		{
		}
	}

	static class Node<T> extends EmptyNode
	{
		T data;
		EmptyNode left = new EmptyNode();
		EmptyNode right = new EmptyNode();

		Node(T data)
		{
			this.data = data;
		}

		Node<T> left(Node<?> node)
		{
			this.left = node;
			return this;
		}

		Node<T> right(Node<?> node)
		{
			this.right = node;
			return this;
		}

		void accept(Visitor visitor)
		{
			visitor.visit(this);
		}

		void accept(LevelOrder visitor, Queue<EmptyNode> data)
		{
			visitor.visit(this, data);
		}
	}

	static abstract class Visitor
	{
		Consumer<Node<?>> action;

		Visitor(Consumer<Node<?>> action)
		{
			this.action = action;
		}

		abstract <T> void visit(Node<T> node);
	}

	static class PreOrder extends Visitor
	{
		PreOrder(Consumer<Node<?>> action)
		{
			super(action);
		}

		<T> void visit(Node<T> node)
		{
			action.accept(node);
			node.left.accept(this);
			node.right.accept(this);
		}
	}

	static class InOrder extends Visitor
	{
		InOrder(Consumer<Node<?>> action)
		{
			super(action);
		}

		<T> void visit(Node<T> node)
		{
			node.left.accept(this);
			action.accept(node);
			node.right.accept(this);
		}
	}

	static class PostOrder extends Visitor
	{
		PostOrder(Consumer<Node<?>> action)
		{
			super(action);
		}

		<T> void visit(Node<T> node)
		{
			node.left.accept(this);
			node.right.accept(this);
			action.accept(node);
		}
	}

	static class LevelOrder extends Visitor
	{
		LevelOrder(Consumer<Node<?>> action)
		{
			super(action);
		}

		<T> void visit(Node<T> node)
		{
			Queue<EmptyNode> queue = new LinkedList<>();
			queue.add(node);
			do
			{
				queue.remove().accept(this, queue);
			} while (!queue.isEmpty());
		}

		<T> void visit(Node<T> node, Queue<EmptyNode> queue)
		{
			action.accept(node);
			queue.add(node.left);
			queue.add(node.right);
		}
	}
}