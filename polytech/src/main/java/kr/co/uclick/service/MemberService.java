/*
 * 제목 : Member Service
 * 작성자 : 한하늘
 * 날짜 : 2018-08-26
 * 설명 : Member Repository를 통해 데이터베이스에서 데이터를 가져온 후 컨트롤러에게 전달
 */

package kr.co.uclick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Member;
import kr.co.uclick.repository.MemberRepository;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	// Member 삭제
	public void delete(Member entity) {
		memberRepository.delete(entity);
	}

	// 모든 Member select
	@Transactional(readOnly = true)
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	// Member 저장
	public void save(Member member) {
		memberRepository.save(member);
	}

	// id로 해당 Member select
	public Optional<Member> findById(Long id) {
		return memberRepository.findById(id);
	}
	
	// 매개변수의 문자열이 성명에 포함된 Member select 
	public List<Member> findMemberByNameContaining(String name) {
		return memberRepository.findMemberByNameContaining(name);
	}
}
