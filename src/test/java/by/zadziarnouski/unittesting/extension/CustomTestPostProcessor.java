package by.zadziarnouski.unittesting.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class CustomTestPostProcessor implements TestInstancePostProcessor {

  @Override
  public void postProcessTestInstance(Object testInstance,
      ExtensionContext context) {
    System.out.println("Hello World from TestInstancePostProcessor");
  }
}
