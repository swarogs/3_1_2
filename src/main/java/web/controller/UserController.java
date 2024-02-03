package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService usersService) {
		this.userService = usersService;
	}

	@RequestMapping(value = "/")
	public String getAllUsers(Model model) {
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("allUsers", allUsers);
		return "all_users";
	}

	@GetMapping("/creat_user")
	public String creatUserFrom(Model model) {
		model.addAttribute("user", new User());
		return "creat_user";
	}

	@PostMapping("/creat_user")
	public String addUser(@ModelAttribute("user") User user1) {
		userService.addUser(user1);
		return "redirect:/";
	}

	@GetMapping("/update_user")
	public String updateUserFrom(Model model) {
		model.addAttribute("userU", new User());
		return "update_user";
	}

	@PostMapping("/update_user")
	public String updateUser(@ModelAttribute("userU") User user) {
		userService.updateUser(user.getId(), user);
		return "redirect:/";
	}

	@GetMapping("/delete_user")
	public String deleteUserFrom(Model model) {
		model.addAttribute("userD", new User());
		return "delete_user";
	}

	@PostMapping("/delete_user")
	public String deleteUser(@ModelAttribute("userD") User user) {
		userService.deleteUser(user.getId());
		return "redirect:/";
	}

}