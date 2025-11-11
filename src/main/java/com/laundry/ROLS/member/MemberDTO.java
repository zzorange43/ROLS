package com.laundry.ROLS.member;

import com.laundry.ROLS.domain.Member;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Valid
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MemberDTO {

    private Integer id;              //고객ID

    @NotEmpty(message = "회원 이름은 필수입니다.")
    private String name;

    private String phone;           //연락처
    private String address;         //주소
    private String note;            //메모
    private String registeredAt;   //등록일

    //DTO → ENTITY 변환
    public Member getMember(){
        return Member.builder().id(this.id).note(this.note).address(this.address).name(this.name).phone(this.phone).build();
    }
}
