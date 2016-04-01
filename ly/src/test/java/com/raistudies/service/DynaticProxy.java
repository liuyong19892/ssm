package com.raistudies.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import com.raistudies.domain.User;
import com.raistudies.service.mybatis.UserService;

public class DynaticProxy implements InvocationHandler{
	private Object obj;
	public DynaticProxy(Object obj){
		this.obj = obj;
	}
	
	public Object getObj() {
		return obj;
	}

	public static void main(String[] args) {
		DynaticProxy proxy = new DynaticProxy(new Impl());
		UserService service = (UserService)Proxy.newProxyInstance(Impl.class.getClassLoader(), Impl.class.getInterfaces(), proxy);
		service.saveUser(new User());
		
		CglibProxy cProxy = new CglibProxy();
		Impl Impl = (Impl)cProxy.getProxy(Impl.class);
		Impl.saveUser(new User());
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		this.before();
		method.invoke(obj,args);
		after();
		return result;
	}

	public void before(){
		System.out.println("before");
	}
	public void after(){
		System.out.println("after");
	}
}
	

		class CglibProxy implements MethodInterceptor{
			private Enhancer enhancer = new Enhancer();
			public Object getProxy(Class clazz){
				enhancer.setSuperclass(clazz);
				enhancer.setCallback(this);
				return enhancer.create();
		}
		@Override
		public Object intercept(Object obj, Method method, Object[] args,
				MethodProxy proxy) throws Throwable {
			System.out.println("模拟代理增强begain");
			Object result = proxy.invokeSuper(obj, args);
			System.out.println("模拟代理增强end");
			return result;
		}
		
	}

