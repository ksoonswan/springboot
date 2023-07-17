package me.whiteship.querydsldemo.account;

import static org.assertj.core.api.Assertions.assertThat;

import com.querydsl.core.types.Predicate;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud(){
        QAccount account = QAccount.account;
        Predicate predicate = account
                .firstName.containsIgnoreCase("swan")
                .and(QAccount.account.lastName.startsWith("kim"));

        Optional<Account> one = accountRepository.findOne(predicate);
        assertThat(one).isEmpty();
    }

}