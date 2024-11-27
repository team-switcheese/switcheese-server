package com.switcheese.server.infrastructure.test;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.switcheese.server.domain.member.Member;
import com.switcheese.server.domain.member.MemberRepositoryCustom;
import jakarta.persistence.EntityManager;
import static com.switcheese.server.domain.member.QMember.member;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Member> test() {
        return queryFactory
                .selectFrom(member)
                .where(member.createdAt.before(LocalDateTime.now())
                        .and(member.password.length().lt(5)))
                .fetch();
    }
}
