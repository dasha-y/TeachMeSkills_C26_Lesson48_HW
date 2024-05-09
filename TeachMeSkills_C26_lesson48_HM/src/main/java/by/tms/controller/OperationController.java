package by.tms.controller;

import by.tms.dao.OperationDao;
import by.tms.entity.Operation;
import by.tms.entity.NewUser;
import by.tms.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/calc")
public class OperationController {

    @Autowired
    private OperationDao operationDao;

    @Autowired
    private HttpSession session;


//    @Autowired
//    public OperationController(OperationService operationService) {
//        this.operationService = operationService;
//    }
    @Autowired
    OperationService operationService;


    @GetMapping("/calc")
    public String calc(){
        return "calc/calc";
    }

    @PostMapping("/calc")
    public String calc(Operation operation){

        Long id = (Long) session.getAttribute("user_id");


        Operation operationResult = operationService.calculate(operation);

        NewUser user = new NewUser();
        user.setId(id);

        operationResult.setUser(user);
        
        operationDao.save(operationResult);
        return "redirect:/calc/history";
    }


    @GetMapping("/history")
    public String history(Model model){
        List<Operation> all = operationDao.findAll();
        model.addAttribute("operationList", all);
        return "calc/history";
    }

}
