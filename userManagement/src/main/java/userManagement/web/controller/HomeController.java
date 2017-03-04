package userManagement.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({"/home.html","/index.html"})
	public String home(ModelMap model){
		model.put("user", "Satvir");
		return "home";
	}
}
