package study.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import study.dto.Member;

// 웹사이트 만들기의 기본이다. @Controller 입력. 이 부분이 사용자 입력을 받아주는 부분
@Controller
public class ThymeleafStudyController {
	private int count = 0;
	
	//	위의 컨트롤러에서 사용자 입력을 받은 부분이랑 내부적으로 작동할 부분이랑 연동시키는 부분이 아래의 @RequestMapping
//	웹 브라우저의 주소창에 입력된 url이 아래의 괄호 "" 안에 들어간 주소임.
	@RequestMapping("/")
	public String index() {
//		@Controller 어노테이션이 사용되었을 경우 @RequestMapping으로 연동된 메서드의 반환타입이 String일 경우, return "문자열" 입력 시 지정된 위치(templates 폴더)에서 지정한 문자열을 가진 html 파일을 호출
		return "index"; // templates 폴더에서 index.html 파일을 호출함
	}
	
//	위의 index 부분은 테스트용, 이제 아래부터 본격적으로 시작함.
	@RequestMapping("/thymeleaf")
//	Model은 ModelAndView 랑 비슷함. 
	public String thymeleaf(Model model) {
//		Model 클래스는 Controller 에서 사용자가 요청한 정보의 처리된 내용을 담고 있는 객체
//		View 부분으로 넘겨줄 데이터의 모음이 model 이라고 보면됨, 컨트롤러에서 받아서 back 단(View 부분)으로 넘겨줄...
//		html은 기본적으로 동적인 작업을 못해서 타임리프나 jsp가 대신 해주는 것임. jsp 는 <% %> 스크립틀릿 문장 사용함. 
		
//		thymeleaf 가 받을 데이터, 첫 번째 매개변수가 thymeleaf에서 사용할 변수명임. 두 번째 매개변수가 실제 데이터가 됨.
		
		String result = "";
		boolean flag = false;
		if (count % 2 == 0) {
			result = "짝수";
			flag = true;
			count++;
		}
		else {
			result = "홀수";
			flag = false;
			count++;
		}
		
//		study.dto로 임폴트 해주기
		Member member = new Member();
		member.setName("홍길동");
		member.setEmail("asdfas@sdfsdf.net");
		member.setTel("010-1234-5678");
		member.setAddress("부산");
		
		Member member2 = new Member("둘리", "hoeee@gmail.com", "010-1111-1111", "서울");
		Member member3 = new Member("고길동", "boojang@gmail.com", "010-2222-2222", "서울");
		Member member4 = new Member("마이콜", "micole@gmail.com", "010-3333-3333", "서울");
		
		List<Member> list = new ArrayList<Member>();
		list.add(member);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		
		model.addAttribute("data", "thymeleaf");
		model.addAttribute("hi", "Hello word!!");
		model.addAttribute("btnText", result); 
		model.addAttribute("member", member); // 클래스로 만들어서 객체화 시켜서 사용 가능.
		model.addAttribute("url", "//test//");
		model.addAttribute("h", "hello");
		model.addAttribute("w", "world");
		model.addAttribute("flag", flag);
		model.addAttribute("btnPrimary", "btn btn-primary");
		model.addAttribute("chk", true);
		model.addAttribute("datas", list);
		
		return "thymeleaf";
	}
	
	@RequestMapping("/test/test")
	public String testtest() {
		return "/test/test";
	}
}





























