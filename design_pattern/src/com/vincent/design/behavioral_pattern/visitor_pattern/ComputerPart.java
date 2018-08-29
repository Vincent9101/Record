package com.vincent.design.behavioral_pattern.visitor_pattern;

/**
 * 
 * @author Vincent
 * <p>被访问的数据结构接口</p>
 *
 */
public interface ComputerPart {
	public void accept(ComputerPartVisitor computerPartVisitor);

}
