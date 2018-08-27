package ko.co.uclick.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.Member;
import kr.co.uclick.repository.MemberRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class MemberRepositoryTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void test() {
		
		/* select one */
//		Optional<Member> m = memberRepository.findById(1L);
//		Member member = m.get();
//		
//		assertEquals("한하늘1", member.getName());
		
		/* create */
		Member member = new Member();
		
		member.setName("한하늘2");
		
		memberRepository.save(member);
		
		/* update */
//		Member member = new Member();
//		member.setId(1L);
//		member.setName("이름1");
//		memberRepository.save(member);
		
//		/* delete */
//		memberRepository.deleteById(1L);
		
		/* select by name */
		List<Member> members = memberRepository.findMemberByName("한하늘2");
		
		for(Member m : members) {
			System.out.println(m.getId());
		}
		
	}
}
