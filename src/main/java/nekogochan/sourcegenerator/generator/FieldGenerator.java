package nekogochan.sourcegenerator.generator;

import nekogochan.sourcegenerator.tip.common.Modifier;
import org.jetbrains.annotations.Nullable;

import java.util.StringJoiner;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static nekogochan.sourcegenerator.tip.common.Modifier.ABSTRACT;
import static nekogochan.sourcegenerator.tip.common.Modifier.STRICTFP;
import static nekogochan.sourcegenerator.tip.common.Modifier.TRANSIENT;
import static nekogochan.sourcegenerator.tip.common.Modifier.VOLATILE;

public class FieldGenerator extends AbstractGenerator<FieldGenerator> {

  @Nullable
  private String initValue;

  @Override
  public String generate() {
    var field = new StringJoiner(" ", "", ";");
    if (visibility != null) {
      field.add(visibility.getValue());
    }
    if (modifiers.size() > 0) {
      field.add(modifiers.stream()
                         .sorted(comparingInt(Modifier::getOrder))
                         .map(Modifier::getValue)
                         .collect(joining(" ")));
    }
    field.add(type);
    field.add(name);
    if (initValue != null) {
      field.add("=");
      field.add(initValue);
    }
    return field.toString();
  }

  public FieldGenerator init(String value) {
    this.initValue = value;
    return it();
  }

  public FieldGenerator $transient() {
    return modifier(TRANSIENT);
  }

  public FieldGenerator $volatile() {
    return modifier(VOLATILE);
  }

  public FieldGenerator $strictfp() {
    return modifier(STRICTFP);
  }
}
