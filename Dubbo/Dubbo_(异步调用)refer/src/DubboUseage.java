import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.baizhi.service.IDemoService;


public class DubboUseage {
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		IDemoService demoService=(IDemoService) ctx.getBean("demoService");

	/*	
	 *  long start=System.currentTimeMillis();
		int sum=demoService.sum(1, 2);
		int multi=demoService.multi(12, 13);
		System.out.println("sum:"+sum+",multi:"+multi);
		long end=System.currentTimeMillis();
		System.out.println("总共耗时："+(end-start)/1000+"秒");
		
		*/
		
		
		long start=System.currentTimeMillis();
		demoService.sum(1, 2);
		Future<Integer> sumRes = RpcContext.getContext().getFuture();
	    demoService.multi(12, 13);
		Future<Integer> multiRes = RpcContext.getContext().getFuture();
		System.out.println("sum:"+sumRes.get()+",multi:"+multiRes.get());
		long end=System.currentTimeMillis();
		System.out.println("总共耗时："+(end-start)/1000+"秒");
	}
}
