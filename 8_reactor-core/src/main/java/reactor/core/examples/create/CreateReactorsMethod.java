package reactor.core.examples.create;


import java.util.Arrays;
import java.util.Optional;


import com.manisrini.domain.CardMetaData;
import reactor.core.examples.data.ReactorTestData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateReactorsMethod implements ReactorTestData {

  public static void main(String[] args) {

  }

  public Mono<CardMetaData> createJustMono() {
    return Mono.just(getCardMetadata());
  }

  public Mono<CardMetaData> createJustOrEmptyMono() {
    return Mono.justOrEmpty(null);
  }

  public Mono<CardMetaData> createJustOrEmptyOptionalMono() {
    return Mono.justOrEmpty(Optional.ofNullable(null));
  }

  public Flux<CardMetaData> createJustFlux() {
    return Flux.just(getCardMetadataArray());
  }

  public Flux<String> fluxFromIterable() {
    return Flux.fromIterable(Arrays.asList("john", "doe", "mani"));
  }

  public Flux<String> fluxWithNoEventSignal() {
    return Flux.never();
  }

}
