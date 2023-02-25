package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {
    private MemberRepository memberRepository=MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member=new Member("kkk",20);

        //when
        Member savedMember=memberRepository.save(member);

        //then
        Member foundMember=memberRepository.findById(savedMember.getId());
        Assertions.assertThat(savedMember).isEqualTo(foundMember);

    }
    @Test
    void findById() {
        //given
        Member savedMember = memberRepository.save(new Member("kkk", 20));

        //when
        Member foundMember = memberRepository.findById(savedMember.getId());

        //then
        Assertions.assertThat(foundMember).isEqualTo(savedMember);
    }
    @Test
    void findAll() {
        //given
        Member savedMember1 = memberRepository.save(new Member("kkk", 20));
        Member savedMember2 = memberRepository.save(new Member("mmm", 30));

        //when
        List<Member> members = memberRepository.findAll();

        //then
        Assertions.assertThat(members).hasSize(2);
        Assertions.assertThat(members).contains(savedMember1, savedMember2);
    }
}