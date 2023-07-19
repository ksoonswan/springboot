package me.whiteship.commonweb.post;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

@Service
public class AccountAuditAware implements AuditorAware<Account> {

  @Override
  public Optional<Account> getCurrentAuditor() {
    System.out.println("looking for current user");
    return Optional.empty();
  }
}
