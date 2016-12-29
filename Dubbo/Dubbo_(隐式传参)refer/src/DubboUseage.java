import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.baizhi.service.IDemoService;


public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		RpcContext.getContext().setAttachment("attch", "逗你玩");
		IDemoService demoService=(IDemoService) ctx.getBean("demoService");
        // setAttachment设置的KV，在完成下面一次远程调用会被清空。即多次远程调用要多次设置。
		
		for(int i=0;i<5;i++){
			//RpcContext.getContext().setAttachment("attch", "逗你玩"+i);
	    	demoService.methodInvoke();
	    }
		
	}
}
