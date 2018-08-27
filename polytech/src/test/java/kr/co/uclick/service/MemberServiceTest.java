package kr.co.uclick.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.Member;
import kr.co.uclick.entity.Phone;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	
	@Test
	public void test() {
//		Optional<Member> m = memberService.findById(1L);
//		Member member = m.get();
//		
//		for (Phone p: member.getPhones()) {
//			System.out.println(p.getNum());
//		}
//		
//		assertEquals("한하늘", member.getName());
		
//		Member foo = new Member();
//		memberService.save(foo);
//		memberService.findById(foo.getId());
//		int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
//		  .getCache("org.baeldung.persistence.model.Foo").getSize();
//		assertThat(size, greaterThan(0));
	}
}
