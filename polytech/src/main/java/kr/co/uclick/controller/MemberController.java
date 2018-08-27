/*
 * 제목 : Member Controller
 * 작성자 : 한하늘
 * 날짜 : 2018-08-26
 * 설명 : 클라이언트로부터 전달되어진 데이터를 가공
 */

package kr.co.uclick.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.uclick.entity.Member;
import kr.co.uclick.entity.Phone;
import kr.co.uclick.service.MemberService;
import kr.co.uclick.service.PhoneService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PhoneService phoneService;

	@RequestMapping(value = "/list")	// 경로 설정
	public String list(Locale locale, @RequestParam Map<String, String> param, Model model) {
		
		String name_search = param.get("name_search");				// 검색한 이름을 파라미터로 받음
		String phone_search = param.get("phone_search");			// 검색한 전화번호를 받음
		
		List<Member> members = new ArrayList<Member>();				// Member List 생성
		
		if (name_search != null && name_search != "") {				// 검색한 이름이 있을 경우
			// 해당이름으로 찾은 회원들을 list에 대입
    	    members = memberService.findMemberByNameContaining(name_search);	
        } else if (phone_search != null && phone_search != "") {	// 검색한 전화번호가 있을 경우
        	// 해당 전화번호로 Phone을 찾고
			List<Phone> phoneList = phoneService.findPhoneByNum(phone_search);	
			for(Phone phone : phoneList) {
				// 전화번호에 해당하는 Member를 List에 저장
				members.add(phone.getMember());	
			}
        } else {	// 검색한 이름과 전화번호가 없을 경우
        	// 모든 회원정보를 출력
     	    members = memberService.findAll();	
        }
		model.addAttribute("members", members);
		
		return "list";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Locale locale, @RequestParam Map<String, String> param, Model model) {
		
		long id = Long.parseLong(param.get("key"));			// list에서 회원의 id를 파라미터로 받음
		model.addAttribute("id", id);
		
		Optional<Member> m = memberService.findById(id);	// id로 회원객체를 얻어옴
		Member member = m.get();
		
		String name = member.getName();					// 해당 회원의 이름을 가져옴
		model.addAttribute("name", name);
		
		String email = member.getEmail();				// 이메일 정보를 가져옴
		model.addAttribute("email", email);
		
		List<Phone> phones = member.getPhones();		// 회원이 갖고 있는 전화번호 정보를 모두 가져옴
		model.addAttribute("phones", phones);
		
		return "view";
		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Locale locale, @RequestParam Map<String, String> param, Model model) {
		
		long id = Long.parseLong(param.get("key"));			// view로 부터 회원의 id를 얻음
		model.addAttribute("id", id);
		
		Optional<Member> m = memberService.findById(id);	// id로 회원객체를 얻어옴
		Member member = m.get();
		
		String name = member.getName();				// 해당 회원의 이름을 가져옴
		String email = member.getEmail();			// 이메일 정보를 가져옴
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		
		List<Phone> phones = member.getPhones();	// 회원이 갖고 있는 전화번호 정보를 모두 가져옴
		model.addAttribute("phones", phones);
		
		return "edit";
		
	}

	@RequestMapping(value = "/editsave")
	public String editsave(Locale locale, @RequestParam Map<String, String> param, Model model, @RequestParam(value="phonenum", required=true) List<String> values) {

		long id = Long.parseLong(param.get("key"));	// 회원 번호(edit로 부터 얻음)
		String name = param.get("name");	// edit에서 입력한 회원 이름
		String email = param.get("email");	// edit에서 입력한 이메일
		
		Optional<Member> m = memberService.findById(id);	// 회원id로 회원객체를 가져옴
		Member member = m.get();
		member.setName(name);				// edit에서 변경한 이름으로 회원의 이름을 변경
		member.setEmail(email);				// edit에서 변경한 이메일로 회원의 이메일을 변경
		
		memberService.save(member);			// 변경된 회원 객체 저장
		
		int end = values.size();			// 파라미터로 받은 전화번호 배열의 사이즈를 end변수에 대입
		
		for(String num : values) {			// 전달받은 전화번호 배열에 빈값이 있을 경우 
			if(num == "") {
				end = values.indexOf(num);	// 빈값의 index를 end 변수에 대입
			}
		}
		
		List<Phone> phones = member.getPhones();	// 회원의 전화번호 정보를 가져옴
		
		for(Phone phone : phones) {
			phoneService.delete(phone);		// 회원의 전화번호 정보를 모두 삭제
		}
		
		for(int i=0; i < end; i++) {		// 파라미터로 넘겨온 전화번호 정보 중 유효한 것만
			Phone phone = new Phone();		// Phone 객체 생성
			phone.setNum(values.get(i));	// 파라미터로 받은 전화번호를 Phone 객체에 저장
			phone.setMember(member);		// Phone의 회원정보 저장
			phoneService.save(phone);		// Phone 저장
		}
		
		return "redirect:list";				// 목록으로 이동
	}
	
	@RequestMapping(value = "/insert")
	public String insert(Model model) {
		
		return "insert";
	}
	
	@RequestMapping(value = "/save")
	public String save(Locale locale, @RequestParam Map<String, String> param, Model model, @RequestParam(value="phonenum", required=true) List<String> values) {

		String name = param.get("name");	// insert에서 입력한 회원 이름
		String email = param.get("email");	// insert에서 입력한 이메일
		
		Member member = new Member();	// 정보저장을 위한 Member 객체 생성
		member.setName(name);			// 받아온 파라미터로 회원이름 저장
		member.setEmail(email);			// 이메일 저장
		
		memberService.save(member);		// 회원 객체 저장
		
		int end = values.size();		// 파라미터로 넘어온 (전화번호 정보를 담은)배열의 크기를 end변수에 대입
		
		for(String num : values) {		// 유효한 전화번호 정보를 얻기 위해
			if(num == "") {				// 빈 값인 배열요소의 index를 end 값으로 지정
				end = values.indexOf(num);
			}
		}
		
		for(int i=0; i < end; i++) {		// insert에서 입력된 전화번호 수만큼 반복
			Phone phone = new Phone();		// Phone 객체 생성	
			phone.setNum(values.get(i));	// 파라미터로 받은 전화번호를 Phone 객체에 저장
			phone.setMember(member);		// Phone의 회원정보 저장
			phoneService.save(phone);		// Phone 저장
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(Locale locale, @RequestParam Map<String, String> param, Model model) {

		long id = Long.parseLong(param.get("key"));			// 회원 아이디
		Optional<Member> m = memberService.findById(id);	// 회원 아아디로 해당 회원을 객체를 가져옴
		Member member = m.get();
		List<Phone> phones = member.getPhones();	// 해당 회원의 전화번호 정보를 가져옴
		for(Phone phone : phones) {					// 회원 삭제 전 회원에 속한 전화번호 정보를 삭제
			phoneService.delete(phone);
		}
		member.setPhones(null);			// 회원의 전화번호 정보를 null로 설정
		memberService.delete(member);	// 전화번호 정보 삭제 후 해당 회원 삭제
		
		return "redirect:list";			// 삭제 후 목록페이지로 이동
	}
}
