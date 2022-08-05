package by.zadziarnouski.unittesting.extension;

import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CustomExecutionCondition implements ExecutionCondition {

  @SneakyThrows
  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    return ConditionEvaluationResult.enabled("Test enabled");
  }
}
