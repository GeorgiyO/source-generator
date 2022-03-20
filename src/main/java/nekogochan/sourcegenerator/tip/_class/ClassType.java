package nekogochan.sourcegenerator.tip._class;

import nekogochan.sourcegenerator.tip.Keyword;
import nekogochan.sourcegenerator.tip.Order;
import org.jetbrains.annotations.Nullable;

public enum ClassType implements Keyword {
  CLASS("class"),
  INTERFACE("interface"),
  ENUM("enum");

  private final String value;

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public int getOrder() {
    return Order.CLASS_TYPE.getValue();
  }


  ClassType(String value) {
    this.value = value;
  }
}
