package com.laundry.ROLS.domain;

import com.laundry.ROLS.member.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
    @SequenceGenerator(name = "member_seq_gen", sequenceName = "member_seq", allocationSize = 1)
    private Integer id;             //고객ID
    private String name;            //이름
    private String phone;           //연락처
    private String address;         //주소
    private String note;            //메모

    @CreatedDate
    private String registeredAt;   //등록일

    //ENTITY → DTO 변환
    public MemberDTO getMemberDTO(){
        return MemberDTO.builder().address(this.address).phone(this.phone).note(this.note).name(this.name).id(this.id).registeredAt(this.registeredAt).build();
    }
}
