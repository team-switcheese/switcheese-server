package com.switcheese.server.member.infrastructure;

import static com.switcheese.server.member.domain.model.QMember.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.switcheese.server.member.domain.MemberRepositoryCustom;
import com.switcheese.server.member.domain.model.Member;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;

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
