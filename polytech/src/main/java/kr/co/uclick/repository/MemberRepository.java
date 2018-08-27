/*
 * 제목 : Member Repository
 * 작성자 : 한하늘
 * 날짜 : 2018-08-26
 * 설명 : 데이터베이스에 접근
 */

package kr.co.uclick.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.uclick.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
	
	// 성명으로 회원을 검색할 때 사용
	public List<Member> findMemberByName(String name);
	
	// 성명에 해당 문자열을 포함한 회원을 검색
	public List<Member> findMemberByNameContaining(String name);
}
