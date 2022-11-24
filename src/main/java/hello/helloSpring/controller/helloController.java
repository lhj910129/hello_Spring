package hello.helloSpring.controller;

import hello.helloSpring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")
    @ResponseBody //??? body에 넣겠다는 의미?
    public String helloString(@RequestParam("name") String name ){
        return "hello " + name; //만약 spring을 넣었다면 hello spring이 될것...... html로 내려주는게 아니라 문자 그대로 .... 하지만 잘 쓰지 않음
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name ) {
        Hello hello = new Hello(); //ctrl + shift + enter 자동완성
        hello.setName(name);
        return hello;
    }
    /*
    * JSON방식으로 내려준다... @ResponsBody와 같이 쓴다면 JSON방식이 기본!
    */

    static class Hello{
        private String name;

        //단축키 alt + insert
        //getter setter는 자바빈 표준방식 == 프로퍼티 접근방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }




}
