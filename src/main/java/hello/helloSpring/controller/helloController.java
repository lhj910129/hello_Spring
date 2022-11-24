package hello.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","spring!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public  String helloMvc(@RequestParam("name" /*required = true 디폴트가 true, false면 안넣어도 됨*/) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    };



}
