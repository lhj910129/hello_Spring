package hello.helloSpring.repository;

import hello.helloSpring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    /*
    전체테스트 진행시 메소드 순서는 랜덤..

    현재는 개발을 하고 테스트케이스를 작성했지만
    테스트케이스를 먼저 작성하고 구현을 하는경우는 TDD개발 이라고 한다.
    */

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트가 끝날때마다 실행!
    @AfterEach
    public  void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //Optional로 반환받을때 get()으로 꺼내야함

        //Assertions.assertEquals(member, null); 기대한 값은 member 인데 실제 값은 null이라 오류발생!
        assertThat(member).isEqualTo(result); //요즘쓰는 방식

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring2").get();

        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
