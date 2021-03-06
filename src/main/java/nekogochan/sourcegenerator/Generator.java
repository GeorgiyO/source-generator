package nekogochan.sourcegenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.StringJoiner;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;

@Deprecated
public abstract class Generator {

  protected static final int BASE_OFFSET = 2;

  protected final String _package;
  protected final String name;
  protected String signature;
  protected final StringJoiner imports = new StringJoiner("\n");
  protected final StringJoiner classCode = new StringJoiner("\n");
  protected StringJoiner templates = new StringJoiner(", ", "<", ">");

  protected Generator(String _package, String signature, String name) {
    this._package = _package;
    this.signature = signature;
    this.name = name;
  }

  public String get() {
    var result = "package %s;\n\n".formatted(_package);
    if (imports.length() != 0) {
      result += imports + "\n\n";
    }
    result += """
              %s %s%s {
              %s
              }
              """.formatted(signature, name, templates, classCode);
    return result;
  }

  public void addClassTemplate(String template) {
    templates.add(template);
  }

  public void writeLocal() throws IOException {
    write("src/main/java");
  }

  public void writeLocalToTests() throws IOException {
    write("src/test/java");
  }

  public void write(String folder) throws IOException {
    write(Path.of(folder + "/%s/%s.java".formatted(
      _package.replaceAll("\\.", "/"),
      name)));
  }

  public void write(Path path) throws IOException {
    var dir = path.getParent();
    if (!Files.exists(dir)) {
      Files.createDirectory(dir);
    }
    Files.writeString(
      path,
      this.get(),
      CREATE, TRUNCATE_EXISTING, WRITE
    );
  }

  protected void addField(String field) {
    add(1, field + ";");
  }

  protected void addMethod(String signature, String body) {
    add(1, signature + " {");
    Arrays.stream(body.split("\n"))
          .forEach(row -> add(2, row));
    add(1, "}");
  }

  public void addEmptyLine() {
    add(0, "");
  }

  public void addImport(String _import) {
    imports.add("import " + _import + ";");
  }

  protected void add(int offset, String code) {
    classCode.add(offset(offset) + code);
  }

  protected static String offset(int depth) {
    var chars = new char[depth * BASE_OFFSET];
    Arrays.fill(chars, ' ');
    return String.valueOf(chars);
  }
}
