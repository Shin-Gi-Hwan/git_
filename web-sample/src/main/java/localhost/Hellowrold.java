package localhost;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class Hellowrold {
	@GetMapping
	public String sayHelloworld() {
		return "Helloworld";
	}
	


}
