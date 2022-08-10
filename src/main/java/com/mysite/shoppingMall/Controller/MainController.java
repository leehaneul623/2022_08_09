package com.mysite.shoppingMall.Controller;

import com.mysite.shoppingMall.Repository.QuestionRepository;
import com.mysite.shoppingMall.Service.QuestionService;
import com.mysite.shoppingMall.Vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/main")
    public String showMain() {
        return "pages/main.html";
    }

    @RequestMapping("/")
    public String rootMain() {
        return "redirect:/main";
    }

    @RequestMapping("/test")
    public String showTest() {
        return "QnA/qna.html";
    }

    @RequestMapping("/test2")
    public String showTest2(Model model){
        List<Question> questionList = questionService.getList(2);
        model.addAttribute("questionList",questionList);

        return "user/test.html";
    }

}
