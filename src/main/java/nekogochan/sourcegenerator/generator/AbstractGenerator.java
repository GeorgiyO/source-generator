package nekogochan.sourcegenerator.generator;

import nekogochan.sourcegenerator.tip.common.Modifier;
import nekogochan.sourcegenerator.tip.common.Visibility;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static nekogochan.sourcegenerator.tip.common.Visibility.*;
import static nekogochan.sourcegenerator.tip.common.Modifier.*;

public abstract class AbstractGenerator<It extends AbstractGenerator<It>> {

  public abstract String generate();

  protected String type;
  protected String name;
  @Nullable
  protected Visibility visibility = null;
  protected final List<Modifier> modifiers = new ArrayList<>();

  @SuppressWarnings("unchecked")
  protected It it() {
    return (It) this;
  }

  public It type(String type) {
    this.type = type;
    return it();
  }

  public It name(String name) {
    this.name = name;
    return it();
  }

  private It visibility(Visibility visibility) {
    this.visibility = visibility;
    return it();
  }

  protected It modifier(Modifier modifier) {
    this.modifiers.add(modifier);
    return it();
  }

  public It $private() {
    return visibility(PRIVATE);
  }

  public It $protected() {
    return visibility(PROTECTED);
  }

  public It $public() {
    return visibility(PUBLIC);
  }

  public It $abstract() {
    return modifier(ABSTRACT);
  }

  public It $static() {
    return modifier(STATIC);
  }

  public It $final() {
    return modifier(FINAL);
  }
}
