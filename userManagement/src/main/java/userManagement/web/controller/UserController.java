package userManagement.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import userManagement.model.User;
import userManagement.model.dao.UserDao;
import userManagement.web.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserDao userdao;
	
	@Autowired
	private UserValidator uservalidator;
	
	@RequestMapping("/user/list.html")
	public String list(ModelMap models){
		//get all users from database and pass them to jsp
		List<User> users = userdao.getUsers();
		models.put("users", users);
		return "user/list";
	}
	
	@RequestMapping("/user/view.html")
	public String view(@RequestParam(required=false) Integer id, ModelMap models){
		models.put("user", userdao.getUser(id));
		return "user/view";
	}
	@RequestMapping("/user/view/{id}.html")
	public String view1(@PathVariable Integer id, ModelMap models, HttpSession session){
		return view(id, models);
//		models.put("user", userdao.getUser(id));
//		return "user/view";
	}
	
	@RequestMapping(value="/user/add.html", method=RequestMethod.GET)
	public String add(ModelMap models){
		models.put("user", new User());
		return "user/add";
	}
	
//	@RequestMapping(value="/user/add.html", method=RequestMethod.GET)
//	public String add(){
//		//models.put("user", new User());
//		return "user/add";
//	}
	
//	@RequestMapping(value="/user/add.html", method=RequestMethod.POST)
//	public String add(@RequestParam String username, @RequestParam String password){
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
////		save user to database
//		user = userdao.saveUser(user);
//		// redirect to user list
//		return "redirect:list.html";
//	}
	
	@RequestMapping(value="/user/add.html", method=RequestMethod.POST)
	public String add(@ModelAttribute User user, BindingResult result){
		uservalidator.validate(user, result);
		if(result.hasErrors()) return "user/add";
		
		user = userdao.saveUser(user);		
		// redirect to user list
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/user/edit.html", method=RequestMethod.GET)
	public String edit(@RequestParam Integer id, ModelMap models){
		models.put("user",userdao.getUser(id));
		return "user/edit";
	}
	
	@RequestMapping(value="/user/edit.html", method=RequestMethod.POST)
	public String edit(@ModelAttribute User user, SessionStatus status, BindingResult result){
		uservalidator.validate(user, result);
		if(result.hasErrors()) return "user/edit";
		user=userdao.saveUser(user);
		status.setComplete();
		return "redirect:list.html";
	}
	
}
