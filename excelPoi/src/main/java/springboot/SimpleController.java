package springboot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	@RequestMapping(value ="/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		
		return "Hello world你好" ;
	}
	
}