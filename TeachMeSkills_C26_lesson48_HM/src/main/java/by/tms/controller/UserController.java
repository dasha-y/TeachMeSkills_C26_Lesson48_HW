package by.tms.controller;

import by.tms.dao.UserDao;
import by.tms.entity.Operation;
import by.tms.entity.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private HttpSession session;

    @GetMapping("/reg")
    public String reg(){
        return "user/reg";
    }

    @PostMapping("/reg")
    public String reg(NewUser user){
        userDao.save(user);
        session.setAttribute("user_id", user.getId());
        return "user/reg";
    }

    @GetMapping("/profile/{username}")
    @Transactional
    public String profile(@PathVariable String username, Model model){
       NewUser byUsername = userDao.findByUsername(username);
        List<Operation> operations = userDao.findAllOperationsByUsername(username);
        byUsername.setOperations(operations);
        model.addAttribute("user", byUsername);
        return "user/profile";
    }
}
