package com.apocryphalworks.twenty48.ai;

import java.util.ArrayList;
import java.util.List;

import com.apocryphalworks.twenty48.engine.Board;

public class AIDecisionNode<T extends GameState> {
	AIDecisionNode<T> parent;
	List<AIDecisionNode<T>> children;
	T data;
	public AIDecisionNode() {
		parent = null;
		children = new ArrayList<AIDecisionNode<T>>();
		data = null;
	}
	public AIDecisionNode(T data) {
		parent = null;
		children = new ArrayList<AIDecisionNode<T>>();
		this.data = data;
	}
	
	public AIDecisionNode<T> getParent() {
		return parent;
	}
	public void setParent(AIDecisionNode<T> parent) {
		this.parent = parent;
	}
	public List<AIDecisionNode<T>> getChildren() {
		return children;
	}
	public void setChildren(List<AIDecisionNode<T>> children) {
		this.children = children;
	}
	public void addChild(AIDecisionNode<T> child) {
		this.children.add(child);
	}

	public int getNodeScore() {
		return 0;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public boolean isValid() {
		return data.isValid();
	}
	
	
}
