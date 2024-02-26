package reactor.core.examples.util;

import java.time.Duration;

import io.vavr.control.Try;

public interface ThreadUtil {

  static void waitFor(Duration duration) {
    Try.run(() -> Thread.sleep(duration.toMillis())).get();
  }
}
