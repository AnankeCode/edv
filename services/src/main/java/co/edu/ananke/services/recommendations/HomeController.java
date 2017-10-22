package  co.edu.ananke.services.recommendations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller.
 * 
 * @author SantiPurdy
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
