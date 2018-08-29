package com.vincent.design.J2EE.business_delegate_pattern;


/**
 * 
 * @author Vincent
 * <p>用于返回具体服务实体，相当于服务工厂类</p>
 *
 */
public class BusinessLookup {

	public BusinessLookup() {
		// TODO Auto-generated constructor stub
	}

	public BusinessService getBusinessService(String serviceType) {
		if (serviceType.equalsIgnoreCase("EJB")) {
			return new EJBService();
		} else {
			return new JMSService();
		}
	}

}
