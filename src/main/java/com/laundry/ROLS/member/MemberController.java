package com.laundry.ROLS.member;

import com.laundry.ROLS.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/{id}")
    public String retrieveMemberDetail(@PathVariable Integer id, Model model) {
        // model.addAttribute("member", memberService.findById(id));
        return "member/detail";
    }

    @GetMapping("/{id}/edit")
    public String modifyMemberForm(@PathVariable Integer id, Model model) {
        // model.addAttribute("member", memberService.findById(id));
        return "member/editForm";
    }

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
