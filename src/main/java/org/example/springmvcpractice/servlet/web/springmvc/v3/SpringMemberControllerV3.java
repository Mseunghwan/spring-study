package org.example.springmvcpractice.servlet.web.springmvc.v3;

import org.example.springmvcpractice.servlet.domain.member.Member;
import org.example.springmvcpractice.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    // GET 요청만 허용
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form"; // 뷰 이름만 반환 (String)
    }

    // POST 요청만 허용
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username, // request.getParameter("username") 대체
            @RequestParam("age") int age,
            Model model) { // Model 객체를 파라미터로 받음

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member); // 모델에 데이터 저장
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}

