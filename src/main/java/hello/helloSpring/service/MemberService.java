package hello.helloSpring.service;

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.MemberRepository;
import hello.helloSpring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { //ctrl + Shift + T 테스트생성

    private final MemberRepository memberRepository = new MemoryMemberRepository() {

        //회원가입
        private Long join(Member member){

            //ctrl + alt + V            변수로 생성하기
            //ctrl + shift + alt + T    리팩토링

            validateDuplicateMember(member);

            memberRepository.save(member);
            return member.getId();
        }

        //중복회원 거르기
        //ctrl + alt + M            메소드로 추출하기
        private void validateDuplicateMember(Member member) {
            memberRepository.findByName(member.getName()).ifPresent(m -> { //만약 값이 있으면
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
        }

        //전체회원조회
        private List<Member> findMembers(){
            return memberRepository.findAll();
        }

        //Id로 회원 찾기
        private Optional<Member> findOne(Long memberId){
            return memberRepository.findById(memberId);
        }

    };




}
