package nekogochan.sourcegenerator.test_write_as_java_files;

import java.util.Random;

public class TestWriteAsJavaFiles {
  private boolean isFucked = new Random().nextBoolean();

  public void helloWorld() {
    var str = "Hello";
    if (isFucked) {
      str += " fucking";
    }
    str += " world";
    System.out.println(str);
  }
}
