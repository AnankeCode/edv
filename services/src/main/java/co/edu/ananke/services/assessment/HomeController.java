package co.edu.ananke.services.assessment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 
 * @author SantiPurdy
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
