package com.bootdemo.controller;

import com.bootdemo.domain.User;
import com.bootdemo.model.ResultBean;
import com.bootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: ASUS
 * @Date: 2020/3/1 17:10
 * @Version: 1.0
 */
@Controller
public class UserController {

    private UserService userService;

    private HttpSession session;

    @Autowired
    public UserController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }

    @RequestMapping("/redirect/personalCenter")
    public String redirectToPersonalCenter(Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute(user);
        return "personalCenter";
    }

    @RequestMapping({"/login/login.do"})
    public String doLogin(@RequestParam String phoneNumber,
                          @RequestParam String password, Model model){

        if(phoneNumber.equals("admin") && password.equals("admin")){
            return "adminCenter";
        }


        User user = userService.selectUserByPhoneNumber(phoneNumber);
        if(user != null && password.equals(user.getPassword())){
            session.setAttribute("user", user);
            model.addAttribute(user);
            return "personalCenter";
        }
        ResultBean resultBean = new ResultBean(1);
        if (user == null){
            resultBean.setBody("该手机号尚未注册");
        }else {
            resultBean.setBody("密码错误");
        }
        model.addAttribute("error", resultBean);
        return "/loginError";
    }

    @RequestMapping(value = "/remoteVerification", method = RequestMethod.POST)
    public String remoteVerification(HttpServletRequest request, Model model){
        //return userService.selectIdByPhoneNumber(phoneNumber) == null ? "true" : "false";
        Map<String, String[]> map = request.getParameterMap();
        String phoneNumber = map.get("phoneNumber")[0];
        User user = userService.selectUserByPhoneNumber(phoneNumber);
        System.out.println(user);
        if(user != null){
            session.setAttribute("user", user);
            model.addAttribute(user);
            return "result";
        }
        return "result";
    }


    @RequestMapping("/register/register.do")
    public String register(User user) {
        userService.insertUser(user);
        return "redirect:/login/login.html";
    }
}
