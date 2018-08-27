/*
 * 제목 : 회원 entity
 * 작성자 : 한하늘
 * 날짜 : 2018-08-26
 * 설명 : 회원 도메인으로 성명, 이메일, 전화번호의 회원정보가 있으며
 * Phone entity와 1:N 관계
 */

package kr.co.uclick.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Member {
	
	@Id	// 기본키임을 명시
	@GeneratedValue(strategy=GenerationType.AUTO)	// 데이터 자동으로 증가
	private Long id;
 
	@Column(length = 20)	// 성명의 길이를 20byte로 제한
	private String name;
	
	@Column
	private String email;

//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Phone> phones;
 
	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
