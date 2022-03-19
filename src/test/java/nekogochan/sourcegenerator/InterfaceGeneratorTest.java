package nekogochan.sourcegenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceGeneratorTest {

  @Test
  void addField() {
    var gen = new InterfaceGenerator("test", "Test");
    gen.addField("String NAME = \"Test\"");
    assertEquals(
      """
      package test;
      
      public interface Test {
        String NAME = "Test";
      }
      """,
      gen.get()
    );
  }

  @Test
  void addMethod() {
    var gen = new InterfaceGenerator("test", "Test");
    gen.addMethod("String getString()");
    assertEquals(
      """
      package test;
      
      public interface Test {
        String getString();
      }
      """,
      gen.get()
    );
  }

  @Test
  void addDefaultMethod() {
    var gen = new InterfaceGenerator("test", "Test");
    gen.addDefaultMethod("String getString()",
                         """
                         return "shit";
                         """);
    assertEquals(
      """
      package test;
      
      public interface Test {
        default String getString() {
          return "shit";
        }
      }
      """,
      gen.get()
    );
  }

  @Test
  void addStaticMethod() {
    var gen = new InterfaceGenerator("test", "Test");
    gen.addStaticMethod("String getString()",
                        """
                        return "shit";
                        """);
    assertEquals(
      """
      package test;
      
      public interface Test {
        static String getString() {
          return "shit";
        }
      }
      """,
      gen.get()
    );
  }
}