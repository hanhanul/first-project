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
import kr.co.uclick.entity.Phone;
import kr.co.uclick.repository.MemberRepository;
import kr.co.uclick.repository.PhoneRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class PhoneRepositoryTest {
	
	@Autowired
	PhoneRepository phoneRepository;
	
	@Test
	public void test() {
		Optional<Phone> p = phoneRepository.findById(1L);
		Phone phone = p.get();
		
		assertEquals("01090471974", phone.getNum());
	
	
	/* create */
//	Member member = new Member();
//	
//	member.setName("한하늘2");
//	
//	memberRepository.save(member);
	
	/* update */
//	Member member = new Member();
//	member.setId(1L);
//	member.setName("이름1");
//	memberRepository.save(member);
	
//	/* delete */
//	memberRepository.deleteById(1L);
	
	/* select by name */
//	List<Member> members = phoneRepository.findMemberByName("한하늘2");
	
//	for(Member m : members) {
//		System.out.println(m.getId());
//	}
}
	
}