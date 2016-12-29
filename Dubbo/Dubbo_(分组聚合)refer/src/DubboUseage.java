import java.io.IOException;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.baizhi.service.IDemoService;


public class DubboUseage {
	//<dubbo:reference id="demoService"  interface="com.baizhi.service.IDemoService" protocol="dubbo" check="false" />
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//分组聚合
	  IDemoService demoService=(IDemoService) ctx.getBean("demoService");
	   for (String string : demoService.groupArray()) {
		   System.out.println(string);
	   }
	   for (String string : demoService.groupList()) {
		   System.out.println(string);
	   }
	   for (Map.Entry<String, Object> entry : demoService.groupMap().entrySet()) {
		   String key = entry.getKey();
		   Object value=entry.getValue();
		   System.out.println(key+" "+value);
	   }
	    
	}
}
