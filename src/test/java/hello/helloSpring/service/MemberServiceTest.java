package hello.helloSpring.service; //테스트는 패키지 똑같이 생성됨

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void join() { //테스트는 한글로 써도됨!!
        //1. given (조건)
        Member member = new Member();
        member.setName("hello");

        //2. when (실행했을때)
        Long saveId = memberService.join(member);

        //3. then (결과)
        Member findmember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findmember.getName());
    }

    @Test
    public void exceptionExist() {
        //given
        Member member1 = new Member();
        member1.setName("스프링");
        Member member2 = new Member();
        member2.setName("스프링");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 123123");
//
//
//        }

        //then
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}