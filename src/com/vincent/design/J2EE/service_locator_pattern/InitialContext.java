package com.vincent.design.J2EE.service_locator_pattern;

/**
 * 
 * @author Vincent 提供查询服务的接口
 *
 */
public class InitialContext {

	public Object lookup(String jndiName) {
		if (jndiName.equalsIgnoreCase("SERVICE1")) {
			System.out.println("Looking up and creating a new Service1 object");
			return new ServiceA();
		} else if (jndiName.equalsIgnoreCase("SERVICE2")) {
			System.out.println("Looking up and creating a new Service2 object");
			return new ServiceB();
		}
		return null;
	}
}
