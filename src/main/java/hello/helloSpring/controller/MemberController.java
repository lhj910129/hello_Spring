package hello.helloSpring.controller;

import hello.helloSpring.domain.Member;
import hello.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller //컨트롤러라는 어노테이션이 있으면 스프링이 객체로 생성해서 갖고있음..!
public class MemberController {
    /*
    private final MemberService memberService = new MemberService(); //이렇게 인스턴스로 만드는 방법보다 스프링컨테이너에 등록해놓고 사용하는 방법으로 개발할 것
    */

    private final MemberService memberService;

    @Autowired //컨트롤러와 서비스를 연결시켜줌 DI(의존성 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
