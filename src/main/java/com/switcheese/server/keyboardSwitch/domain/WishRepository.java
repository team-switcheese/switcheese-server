package com.switcheese.server.keyboardSwitch.domain;

import com.switcheese.server.keyboardSwitch.domain.model.KeyboardSwitch;
import com.switcheese.server.keyboardSwitch.domain.model.Wish;
import com.switcheese.server.member.domain.model.Member;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {

  Optional<Wish> findByMemberAndKeyboardSwitch(Member member, KeyboardSwitch keyboardSwitch);

  Page<Wish> findByMemberAndIsActiveTrue(Member member, Pageable pageable);

}
