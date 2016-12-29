import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.baizhi.service.IDemoService;


public class DubboUseage {
	//<dubbo:reference id="demoService"  interface="com.baizhi.service.IDemoService" protocol="dubbo" check="false" />
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//访问中国的注册中心
		IDemoService demoService1=(IDemoService) ctx.getBean("demoService1");
	    System.out.println(demoService1.methodInvoke());
	    //访问美国的注册中心
	    IDemoService demoService2=(IDemoService) ctx.getBean("demoService2");
	    System.out.println(demoService2.methodInvoke());
	    
	}
}
