package baitaplon.controller;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import baitaplon.dto.UserDTO;
import baitaplon.model.user;
import baitaplon.reponsitory.IUserReponsitory;
import baitaplon.service.impl.UserService;

@Controller
public class LoginController {
	  @Autowired
	    private UserService userService;
	  private IUserReponsitory userReponsitory;
	@GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Trả về file login.html trong templates
    }
	@GetMapping("/forgotpassword")
    public String forgotPassword() {
        return "forgotpassword"; // Trả về file login.html trong templates
    }
	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
	                    @RequestParam("password") String password,
	                    Model model,
	                    HttpSession session) {
	    user loggedUser = userService.loginUser(username, password);
	    if (loggedUser != null) {
	        session.setAttribute("loggedInUser", loggedUser);
	        return "redirect:/list_sinhvien";
	    } else {
	        model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
	        return "login";
	    }
	}

}
