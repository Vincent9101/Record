package com.vincent.design.creational_pattern.singleton_pattern;
/**
 * 
 * @author Vincent
 * 讲道理哦 这个方式最方便的单例模式 
 * 利用枚举 自带支持 序列化机制  防止反序列化多次创建对象 可以适应多线程 然而却不怎么受待见 大多数人不用这个方式 可能和习惯有关系吧 = =   
 *
 */
public enum Singleton_enum {
		
	Instance;
	

}
