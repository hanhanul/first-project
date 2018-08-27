/*
 * 제목 : Phone Service
 * 작성자 : 한하늘
 * 날짜 : 2018-08-26
 * 설명 : Phone Repository를 통해 데이터베이스에서 데이터를 가져온 후 컨트롤러에게 전달
 */

package kr.co.uclick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Member;
import kr.co.uclick.entity.Phone;
import kr.co.uclick.repository.MemberRepository;
import kr.co.uclick.repository.PhoneRepository;

@Service
@Transactional
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;

	// Phone 삭제
	public void delete(Phone entity) {
		phoneRepository.delete(entity);
	}

	// 모든 Phone select
	@Transactional(readOnly = true)
	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}

	// Phone 저장
	public void save(Phone phone) {
		phoneRepository.save(phone);
	}

	// id로 해당 Phone select
	public Optional<Phone> findById(Long id) {
		return phoneRepository.findById(id);
	}
	
	// 매개변수의 문자열과 일치하는 번호의 Phone select
	public List<Phone> findPhoneByNum(String num) {
		return phoneRepository.findPhoneByNum(num);
	}
}
