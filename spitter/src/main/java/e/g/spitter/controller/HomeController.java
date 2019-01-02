package e.g.spitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.*;
@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
}

/*@Controller
@RequestMapping({"/", "/homepage"}) // /와 /homepage 요청에 응답
public class HomeController {
	
	@RequestMapping(method=GET)
	public String home() {
		return "home";
	}
}*/