/*
 * 제목 : Phone Repository
 * 작성자 : 한하늘
 * 날짜 : 2018-08-26
 * 설명 : 데이터베이스에 접근
 */

package kr.co.uclick.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.uclick.entity.Member;
import kr.co.uclick.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>, QuerydslPredicateExecutor<Phone> {

	// 전화번호로 Phone 검색
	public List<Phone> findPhoneByNum(String num);
}
