package com.laundry.ROLS.member;

import com.laundry.ROLS.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/* 파일명: MemberController.java
*  설명: 회원 컨트롤러
*  생성일자: 2025-08-06
* */
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    /*회원 목록 조회*/
    @GetMapping
    public String retrieveMemberList(Model model){
        //전체 회원 조회
        List<Member> members =  memberService.findMembers();

        List<MemberDTO> memberDTOS = members.stream().map(Member::getMemberDTO).toList();

        model.addAttribute("members", memberDTOS );
        return "/member/memberList";
    }

    /*회원 등록 (등록폼 조회)*/
    @GetMapping("/new")
    public String createMemberForm(Model model) {
        model.addAttribute("member", new MemberDTO());
        return "member/createForm";
    }
    /*회원 등록 POST*/
    @PostMapping
    public String createMember(@ModelAttribute("memberForm") MemberDTO memberDTO, BindingResult result) {

        //DTO → ENTITY 변환
        Member member = memberDTO.getMember();

        int newMemberId = memberService.createMember(member);

        return "redirect:/member";
    }

    /*회원 상세 보기 GET*/
    @GetMapping("/{id}")
    public String retrieveMemberDetail(@PathVariable("id") Integer id, Model model) {

        //서비스에 보낼 파라미터맵
        Map<String, Object> param = new HashMap<>();
        param.put("memberId",id);

        Map<String, Object> resultMap = memberService.retrieveMemberDetail(param);

        MemberDTO memberDTO = (MemberDTO)resultMap.get("member");

        model.addAttribute("member", memberDTO);
        return "member/detail";
    }
    /*회원 수정화면 보기 GET 흠 이걸 해야하나??*/
//    @GetMapping("/{id}/edit")
//    public String modifyMemberForm(@PathVariable Integer id, Model model) {
//        model.addAttribute("member", memberService.findOne(id));
//        return "member/editForm";
//    }

    @PostMapping("/{id}")
    public String modifyMember(@PathVariable Integer id , @ModelAttribute Member member ) {
        // memberService.update(id, member);
        return "redirect:/member/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Integer id) {
        // memberService.delete(id);
        return "redirect:/member";
    }



}
