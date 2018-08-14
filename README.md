# desgin-pattern
该项目作为学习设计模式使用的demo记录

# 设计模式的的六大原则:
   学习设计模式之前最好先了解一下设计模式的设计原则：

 **1. 开闭原则（open close principle）**

 ***开放即指对扩展开放，对修改关闭*** 简而言之，就是扩展功能的时候应该尽量的不修改原有的代码。

 **2. 里氏代换原则（liskov substitution principle）**

  可以简单理解为派生类与基类的替换关系，一旦程序中出现基类，那么这个基类若是呗派生类替换了，也应该是合适的，并且对程序功能不受影响，该原则实际上是开闭原则的补充。 基类能真正复用，派生类也能够在基类的基础上增加新的行为。实现开闭原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。

**3. 依赖倒转原则（dependence inverse principle）**

这个原则是开闭原则的基础，具体内容：针对接口编程，依赖于抽象而不依赖于具体。

**4. 接口隔离原则（Interface Segregation Principle）**

使用多个隔离的接口，比使用单个接口要好，该模式出发点在与大一点的软件设计架构，便于维护升级，降低耦合度。

**5.迪米特法则，又称最少知道原则（Demeter Principle）**

一个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立。

**6. 合成复用原则（Composite Reuse Principle）**
尽量使用合成/聚合的方式，而不是使用继承。



#设计模式可以分为三大类：

 - ##创建型模式（creational pattern）
   隐藏创建对象的创建逻辑，提供创建对象的接口，而非使用new关键字进行创建。

 - ###工厂模式（factory pattern）

    隐藏创建的对象的逻辑，通过共同对的接口创建对象。
    
    
    实现demo结构如下图,实现demo代码点这里[这是我学习的时候写的demo][1]
    
    ![clipboard.png](/img/bVbfibS)
    
    
 - ###抽象工厂模式（abstract factory pattern）

   这个模式是工厂的共工厂 叫超级工厂模式还比较贴切，在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。



    ![clipboard.png](/img/bVbfj40)

 - ###单例模式（singleton pattern）    
 一个类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象
     1.不支持线程的懒汉单例模式 
     ```java 
  public class Singleton_unsupport_multithread {

	private Singleton_unsupport_multithread() {
		// TODO Auto-generated constructor stub
	}

	private static Singleton_unsupport_multithread instance;

	public static Singleton_unsupport_multithread getSingleton() {

		if (instance == null) {
			instance = new Singleton_unsupport_multithread();
		}

		return instance;
	}

	public void println() {
		System.out.println("In unsupport_multithread");
	}

}

     ``` 
     2.支持多线程的懒汉单例模式
     ```java
      public class Singleton_support_multithread {

    	private Singleton_support_multithread() {
	    	// TODO Auto-generated constructor stub
    	}

	    private static volatile Singleton_support_multithread instance;

	    /**
	     * 第一个判断可以减少锁住对象的情况 如果不为空直接返回 效率更高 
	     * 第二个判断就是懒加载的判断
	     * 
	     * @return
	     */
	    public static Singleton_support_multithread getInstance() {
		    if (instance == null) {
		    	synchronized (Singleton_support_multithread.class) {
			    	if (instance == null)
				    	instance = new Singleton_support_multithread();
			    }
		    }

	    	return instance;
	    }
    
    }

     ``` 
    3.饿汉模式
    
 ```java
/**
 * 
 * @author Vincent
 * 线程安全 但是容易产生垃圾对象，没有加锁执行效率会比较高 
 * 但不是懒加载 类一加载的时候就进行初始化 浪费内存
 *
 */
public class Singleton_hungry_man {

	private Singleton_hungry_man() {
		// TODO Auto-generated constructor stub
	}

	private static Singleton_hungry_man instance = new Singleton_hungry_man();

	public static Singleton_hungry_man getInstance() {

		return instance;

	}

}

```
      4.登记注册式
 ```java
/**
 * 
 * @author Vincent
 * 登记注册式 单例
 * 这里其实与前面的饿汉单例模式有点类似 但是由于利用了ClassLoaderDe特性 
 * 使在不调用的getInstance的时候不会初始化instance 实现了懒加载
 *
 */

public class Singleton_register {

	private static class SingletonHolder {
		private static Singleton_register instance = new Singleton_register();
	}

	private Singleton_register() {
		// TODO Auto-generated constructor stub
	}

	public static final Singleton_register getInstance() {
		return SingletonHolder.instance;
	}

}

 ```
    5.枚举单例式
```java
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

```
 - ###建造者模式（builder pattern）

    使用多个简单的对象一步一步构建成一个复杂的对象。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。值得一说的是感觉是这个设计模式 感觉更加注重内部对象的细节，内部零件装配的顺序。


     

 

      
 - ##结构型模式（ctructural pattern）
    这些设计模式关注类和对象的组合。继承的概念被用来组合接口和定义组合对象获得新功能的方式。
 - ##行为型模式（behavioral pattern）    
    这些设计模式特别关注对象之间的通信
 - ##J2EE设计模式（behavioral pattern）    
    这些设计模式特别关注表示层。这些模式是由 Sun Java Center 鉴定的。
    
   ![clipboard.png](/img/bVbfhUG)


  [1]: https://github.com/restoflife/desgin-pattern
