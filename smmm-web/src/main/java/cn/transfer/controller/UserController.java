package cn.transfer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.transfer.model.User;
import cn.transfer.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/queryUsers")
	public ModelAndView queryUsers(HttpServletRequest request) throws Exception {

		String userId = request.getParameter("id");
		System.out.println(request.getParameter("id"));

		List<User> userList = userService.findUsers(null);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", userList);

		modelAndView.setViewName("users/usersList");

		return modelAndView;

	}

	@RequestMapping(value = "/editUsers", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String editUsers(Model model,
			@RequestParam(value = "id", required = true) Integer users_id)
			throws Exception {

		User user = userService.findUserById(users_id);

		model.addAttribute("user", user);

		return "users/editUsers";
	}

	@RequestMapping("/editUsersSubmit")
	public String editUsersSubmit(HttpServletRequest request, Integer id,
			User user) throws Exception {

		userService.updateUsers(id, user);

		return "success";
	}
}
