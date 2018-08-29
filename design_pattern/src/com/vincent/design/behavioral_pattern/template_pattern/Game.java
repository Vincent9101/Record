package com.vincent.design.behavioral_pattern.template_pattern;

/**
 * 
 * @author Vincent
 *         <p>
 *         最高层模板拥有通用的函数声明
 *         </p>
 *
 */
public abstract class Game {

	public Game() {
		// TODO Auto-generated constructor stub
	}

	protected abstract void initialize();

	protected abstract void startPlay();

	protected abstract void endPlay();

	// 模板
	public final void play() {

		// 初始化游戏
		initialize();

		// 开始游戏
		startPlay();

		// 结束游戏
		endPlay();
	}
}
