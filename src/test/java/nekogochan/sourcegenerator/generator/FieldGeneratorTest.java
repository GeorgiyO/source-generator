package nekogochan.sourcegenerator.generator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Map;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldGeneratorTest {

  private FieldGenerator base() {
    return new FieldGenerator().type("String")
                               .name("str");
  }

  @Test
  void type_and_name() {
    var field = base();
    assertEquals(
      "String str;",
      field.generate()
    );
  }

  @Test
  void $visibilities() {
    assertAll(
      () -> assertVisibility(FieldGenerator::$private, "private"),
      () -> assertVisibility(FieldGenerator::$protected, "protected"),
      () -> assertVisibility(FieldGenerator::$public, "public")
    );
  }

  void assertVisibility(UnaryOperator<FieldGenerator> visibility, String expectedVisibility) {
    var field = visibility.apply(base());
    assertEquals(
      "%s String str;".formatted(expectedVisibility),
      field.generate()
    );
  }

  @Test
  void $modifiers() {
    assertAll(
      Map.<UnaryOperator<FieldGenerator>, String>of(
        FieldGenerator::$static, "static",
        FieldGenerator::$final, "final",
        FieldGenerator::$transient, "transient",
        FieldGenerator::$volatile, "volatile",
        FieldGenerator::$strictfp, "strictfp"
      ).entrySet().stream()
         .<Executable>map(e -> () -> assertModifier(e.getKey(), e.getValue()))
         .toList()
    );
  }

  void assertModifier(UnaryOperator<FieldGenerator> modifier, String expectedModifierValue) {
    assertVisibility(modifier, expectedModifierValue); // same (while we dont use both visibility and modifier)
  }

  @Test
  void init() {
    var field = base().init("\"some shit\"");
    assertEquals(
      "String str = \"some shit\";",
      field.generate()
    );
  }

  @Test
  void keywords_order_test() {
    var field = base().init("\"some shit\"")
                      .$final()
                      .$static()
                      .$public();
    assertEquals(
      "public static final String str = \"some shit\";",
      field.generate()
    );
  }
}