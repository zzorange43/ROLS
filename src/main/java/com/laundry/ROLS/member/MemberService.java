package com.laundry.ROLS.member;

import com.laundry.ROLS.domain.Member;
import com.laundry.ROLS.system.exception.ErrorCode;
import com.laundry.ROLS.system.exception.customException.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.laundry.ROLS.system.exception.ErrorCode.MEMBER_EXIST;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * */
    @Transactional
    public Integer createMember(Member member) {
        this.validateDuplicateMember(member); //중복 회원 검증

        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new BusinessException(MEMBER_EXIST);
        }
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /*
     * 개인 회원 조회
     */
    @Transactional(readOnly = true)
    public Member findOne(Integer memberId){
        return memberRepository.findOne(memberId);
    }

    /*
     * 회원 상세 조회
     */
    @Transactional(readOnly = true)
    public Map<String,Object> retrieveMemberDetail(Map<String,Object> param){
        //파라미터에서 멤버id 갖고오기
        int memberId = (Integer)param.get("memberId");
        
        //개인 회원 조회
        Member member = findOne(memberId);
        
        //컨트롤러에 보낼 Map 생성
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("member",member.getMemberDTO()); //member -> memberDTO 이 작업 ... 매번 해줘야 하냐!!
        
        return resultMap;
    }
}
