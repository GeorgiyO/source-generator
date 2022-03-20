package nekogochan.sourcegenerator.tip.common;

import nekogochan.sourcegenerator.tip.Keyword;
import nekogochan.sourcegenerator.tip.Order;
import org.jetbrains.annotations.Nullable;

public enum Visibility implements Keyword {
  PRIVATE("private"),
  PROTECTED("protected"),
  PACKAGE_PRIVATE(null),
  PUBLIC("public");

  private final String value;

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public int getOrder() {
    return Order.VISIBILITY.getValue();
  }

  Visibility(String value) {
    this.value = value;
  }
}
