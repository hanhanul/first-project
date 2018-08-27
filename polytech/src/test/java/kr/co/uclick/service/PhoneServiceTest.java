package kr.co.uclick.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.Phone;
import kr.co.uclick.repository.MemberRepository;
import kr.co.uclick.repository.PhoneRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class PhoneServiceTest {
	
	@Autowired
	PhoneService phoneService;
	
	@Test
	public void test() {
//		Optional<Phone> p = phoneService.findById(1L);
//		Phone phone = p.get();
//		
//		assertEquals("01090471974", phone.getNum());
		
		List<Phone> phone = phoneService.findPhoneByNum("1234");
		
		Phone p = phone.get(0);
		assertEquals("멤버", p.getMember().getName());
	}
}
