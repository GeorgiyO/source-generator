package nekogochan.sourcegenerator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestWriteAsJavaFiles {

  @Test
  void write() throws IOException {
    var gen = new ClassGenerator("nekogochan.sourcegenerator.test_write_as_java_files", "TestWriteAsJavaFiles");
    gen.addImport("java.util.Random");
    gen.addField("private boolean isFucked = new Random().nextBoolean()");
    gen.addEmptyLine();
    gen.addMethod("public void helloWorld()",
                  """
                  var str = "Hello";
                  if (isFucked) {
                    str += " fucking";
                  }
                  str += " world";
                  System.out.println(str);
                  """);
    gen.writeLocalToTests();
  }
}
