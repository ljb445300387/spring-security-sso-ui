package org.baeldung.config;


import java.security.Principal;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal principal) {
        System.out.println(principal);
		return principal;
    }
    
    @GetMapping("/mylogout")
	public String mylogoutPage(Model model) {
		return "mylogin";
	}
    
    @ResponseBody
    @PostMapping("/mylogoutUrl")
    public void mylogoutUrl(Principal principal) {
    	System.out.println(principal);
    }
    
    @ResponseBody
    @PostMapping("/ljb/form")
    public void user(User user) {
    	System.out.println(user);
    }
}
