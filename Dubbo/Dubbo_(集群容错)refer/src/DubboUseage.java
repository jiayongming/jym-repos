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
		
		IDemoService demoService=(IDemoService) ctx.getBean("demoService");
		//打印代理类型 底层dubbo使用NIO的RCP做远程调度  默认使用的是balancer 随机选择服务器 集群容错failover
	    for(int i=0;i<100;i++){
			System.out.println(i+"[]"+demoService.methodInvoke());
	    }
		
	}
}
