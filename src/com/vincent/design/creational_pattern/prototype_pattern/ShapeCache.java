package com.vincent.design.creational_pattern.prototype_pattern;

import java.util.Hashtable;

import javax.swing.plaf.synth.SynthPainter;

import com.vincent.design.creational_pattern.prototype_pattern.entity.Circle;
import com.vincent.design.creational_pattern.prototype_pattern.entity.Rectangle;
import com.vincent.design.creational_pattern.prototype_pattern.entity.Square;

/**
 * 
 * @author Vincent
 *         <p>
 *         假设shape是从数据库读取出来 该类作为一个缓存
 *         </p>
 *
 */
public class ShapeCache {

	private static Hashtable<String, Shape> shapeTable = new Hashtable<String, Shape>();

	/**
	 * 
	 * @param id
	 * @return
	 *         <p>
	 * 		<em>注意：</em> 这里使用的克隆缓存对象 并且只是 <em>浅拷贝</em>
	 *         </p>
	 */
	public static Shape getShape(String id) {
		Shape shapeCache = shapeTable.get(id);

		return (Shape) shapeCache.clone();
	}
	
	
	/**
	 * 假设在数据库查询 加载
	 * 
	 * TODO:以后可以用配置文件 使用自定义数据库工具类加载
	 */
	public static void  loadShapeCache() {
	  Shape circle=new Circle();
	  circle.setId("1");
	  shapeTable.put(circle.getType()+circle.getId(), circle);
	  Shape rec=new Rectangle();
	   rec.setId("2");
	  shapeTable.put(rec.getType()+rec.getId(), rec);
	  Shape square=new Square();
	  square.setId("3");
	  shapeTable.put(square.getType()+square.getId(),square);
	
		
	}
	public ShapeCache() {
		// TODO Auto-generated constructor stub

	}

}
