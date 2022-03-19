package nekogochan.sourcegenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassGeneratorTest {
  @Test
  void addField() {
    var gen = new ClassGenerator("shit", "Shit");
    gen.addField("private String str = \"Some string value\"");
    gen.addField("public int i = 10");
    assertEquals(
      """
      package shit;
            
      public class Shit {
        private String str = "Some string value";
        public int i = 10;
      }
      """,
      gen.get()
    );
  }

  @Test
  void addMethod() {
    var gen = new ClassGenerator("animals", "Cat");
    gen.addMethod("public void meow()",
                  """
                  System.out.println("meow!");
                  """);
    assertEquals(
      """
      package animals;
      
      public class Cat {
        public void meow() {
          System.out.println("meow!");
        }
      }
      """,
      gen.get()
    );
  }

  @Test
  void addAbstractMethod() {
    var gen = new ClassGenerator("animals", "Animal");
    gen.addAbstractMethod("public void suckDick()");
    assertEquals(
      """
      package animals;
      
      abstract public class Animal {
        abstract public void suckDick();
      }
      """,
      gen.get()
    );
  }

  @Test
  void addTemplate() {
    var gen = new ClassGenerator("test", "Test");
    gen.addClassTemplate("T");
    gen.addClassTemplate("R");
    assertEquals(
      """
      package test;
      
      public class Test<T, R> {
      
      }
      """,
      gen.get()
    );
  }
}