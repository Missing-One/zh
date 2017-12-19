package cn.singularity.appsys.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/back/")
@Controller
public class TestController {

	@RequestMapping("/appcheck")
	public String in() {
		return "appcheck";
	}
	
}
