package reactor.core.examples.create;


import java.time.Duration;

import com.manisrini.domain.CardMetaData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import reactor.core.examples.data.ReactorTestData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class CreateReactorsMethodTest implements ReactorTestData {

  private CreateReactorsMethod createReactorsMethod;

  @BeforeEach
  public void init() {
    Hooks.onOperatorDebug();
    createReactorsMethod = new CreateReactorsMethod();
  }

  @Test
  void test_createMonoJust() {
    Mono<CardMetaData> cardMetadataMono = createReactorsMethod.createJustMono().log();
    StepVerifier.create(cardMetadataMono)
        .expectNext(getCardMetadata())
        .verifyComplete();
  }

  @Test
  void test_createJustFlux() {
    Flux<CardMetaData> cardMetadataFlux = createReactorsMethod.createJustFlux().log();
    StepVerifier.create(cardMetadataFlux)
        .expectNext(getCardMetadataArray())
        .verifyComplete();
  }

  @Test
  void test_createJustOrEmptyMono() {
    Mono<CardMetaData> justOrEmptyMono = createReactorsMethod.createJustOrEmptyMono().log();
    StepVerifier.create(justOrEmptyMono)
        .verifyComplete();

    Mono<CardMetaData> justOrEmptyOptionalMono = createReactorsMethod.createJustOrEmptyOptionalMono().log();
    StepVerifier.create(justOrEmptyOptionalMono)
        .verifyComplete();
  }

  @Test
  public void test_fluxFromIterable() {
    Flux<String> flux = createReactorsMethod.fluxFromIterable().log();
    StepVerifier.create(flux)
        .expectNext("john", "doe", "mani")
        .verifyComplete();

  }

  @Test
  public void test_fluxWithNoEventSignal() {
    Flux<String> flux = createReactorsMethod.fluxWithNoEventSignal().log();
    StepVerifier
        .create(flux)
        .expectSubscription()
        .expectNoEvent(Duration.ofSeconds(1))
        .thenCancel()
        .verify();
  }
}