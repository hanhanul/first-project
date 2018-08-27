/*
 * 제목 : 전화번호 entity
 * 작성자 : 한하늘
 * 날짜 : 2018-08-26
 * 설명 : 전화번호 도메인으로 회원이 갖고 있는 전화번호에 대한 정보가 있으며
 * Member entity와 N:1관계
 */

package kr.co.uclick.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id	// 기본키임을 명시
	@GeneratedValue(strategy=GenerationType.AUTO)	// 데이터 자동으로 증가
	private Long id;
	
	private String num;
	
	@ManyToOne(fetch = FetchType.EAGER)//, cascade = CascadeType.ALL
    private Member member;
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Phone() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
}
