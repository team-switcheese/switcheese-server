package com.switcheese.server.keyboardSwitch.domain;

import com.switcheese.server.keyboardSwitch.domain.model.KeyboardSwitch;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyboardSwitchRepository extends JpaRepository<KeyboardSwitch, Long> {

  Optional<KeyboardSwitch> findByIdAndIsDeleteFalse(Long id);

}
