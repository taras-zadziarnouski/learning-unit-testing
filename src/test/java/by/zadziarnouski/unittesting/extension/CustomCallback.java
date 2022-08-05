package by.zadziarnouski.unittesting.extension;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

@Slf4j
public class CustomCallback implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    log.info("Hello world from CustomCallback.afterAll() callback");
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    log.info("Hello world from CustomCallback.afterEach() callback");
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    log.info("Hello world from CustomCallback.beforeAll() callback");
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    log.info("Hello world from CustomCallback.beforeEach() callback");
  }
}
