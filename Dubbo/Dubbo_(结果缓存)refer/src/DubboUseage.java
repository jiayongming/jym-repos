import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.baizhi.service.IDemoService;


public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IDemoService demoService=(IDemoService) ctx.getBean("demoService");
        //注意区分<dubbo:reference cahe/>和<dubbo:service cahe=""/>区别
		for(int i=0;i<5;i++){
	    	demoService.methodInvoke();
	    }
		
	}
}
