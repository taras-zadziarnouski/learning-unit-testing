package by.zadziarnouski.unittesting.extension;

import java.io.FileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

@Slf4j
public class IgnoreFileNotFoundExceptionHandler implements TestExecutionExceptionHandler {

  @Override
  public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
    if (throwable instanceof FileNotFoundException) {
      log.error("File not found:" + throwable.getMessage());
      return;
    }
    throw throwable;
  }
}
