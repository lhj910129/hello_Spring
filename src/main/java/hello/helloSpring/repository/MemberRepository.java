package hello.helloSpring.repository;

import hello.helloSpring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //null일때 Optional로 감싸서 반환한다
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
