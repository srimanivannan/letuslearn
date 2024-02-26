package reactor.core.examples.create;

import java.util.List;

import reactor.core.examples.data.ReactorTestData;
import com.manisrini.domain.Customer;
import reactor.core.publisher.Flux;

public class TransformReactorsMethod implements ReactorTestData {

  public Flux<String> fluxList() {
    List<Customer> customers = buildUserList();
    return Flux.fromIterable(customers).map(Customer::getUserName);
  }
}
