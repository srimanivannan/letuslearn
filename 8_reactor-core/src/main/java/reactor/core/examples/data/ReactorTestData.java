package reactor.core.examples.data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.manisrini.domain.CardMetaData;
import com.manisrini.domain.Customer;

public interface ReactorTestData {

  default CardMetaData getCardMetadata() {
    CardMetaData cardMetaData = new CardMetaData();
    cardMetaData.setPrimaryAccountNumber("123455");
    cardMetaData.setStatus("ACTIVE");
    return cardMetaData;
  }

  default CardMetaData[] getCardMetadataArray() {
    CardMetaData card1 = new CardMetaData();
    card1.setPrimaryAccountNumber("123455");
    card1.setStatus("ACTIVE");
    CardMetaData card2 = new CardMetaData();
    card2.setPrimaryAccountNumber("123456");
    card2.setStatus("ACTIVE");
    CardMetaData card3 = new CardMetaData();
    card3.setPrimaryAccountNumber("123457");
    card3.setStatus("ACTIVE");
    return new CardMetaData[]{card1, card2, card3};
  }

  default Customer buildUser(String userId, String name, String email, LocalDate dateOfBirth) {
    return Customer.builder()
        .userId(userId)
        .userName(name)
        .userEmail(email)
        .userDateOfBirth(dateOfBirth)
        .build();
  }

  default List<Customer> buildUserList() {
    Customer name1 = buildUser("user1", "name1", "a@email.com", LocalDate.parse("2011-12-03"));
    Customer name2 = buildUser("user2", "name2", "b@email.com", LocalDate.parse("2010-12-03"));
    Customer name3 = buildUser("user3", "name3", "b@email.com", LocalDate.parse("2009-12-03"));
    return Arrays.asList(name1, name2, name3);
  }

}
