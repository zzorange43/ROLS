package com.laundry.ROLS.member;

import com.laundry.ROLS.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }
    
    /*
    * 개인 회원 조회
    */
    public Member findOne(Integer id) {
        return em.find(Member.class, id);
    }
    
    /*
     * 전체 회원 조회
     */
    public List<Member> findAll(){
        return em.createQuery("select m  from Member m", Member.class).getResultList();
    }

    /*
     * 이름으로 회원 검색
     */
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
