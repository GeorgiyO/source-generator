package nekogochan.sourcegenerator.tip.common;

import nekogochan.sourcegenerator.tip.Keyword;
import nekogochan.sourcegenerator.tip.Order;

public enum Modifier implements Keyword {
  ABSTRACT("abstract", Order.ABSTRACT.getValue()),
  STATIC("static", Order.STATIC.getValue()),
  FINAL("final", Order.FINAL.getValue()),
  TRANSIENT("transient", Order.TRANSIENT.getValue()),
  VOLATILE("volatile", Order.VOLATILE.getValue()),
  DEFAULT("default", Order.DEFAULT.getValue()),
  SYNCHRONIZED("synchronized", Order.SYNCHRONIZED.getValue()),
  NATIVE("native", Order.NATIVE.getValue()),
  STRICTFP("strictfp", Order.STRICTFP.getValue()),
  ;

  private final String value;
  private final int order;

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public int getOrder() {
    return order;
  }

  Modifier(String value, int order) {
    this.value = value;
    this.order = order;
  }
}
