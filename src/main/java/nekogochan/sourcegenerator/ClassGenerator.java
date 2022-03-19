package nekogochan.sourcegenerator;

public class ClassGenerator extends Generator {
  public ClassGenerator(String $package, String $name) {
    super($package, "public class %s".formatted($name));
  }

  @Override
  public void addField(String field) {
    super.addField(field);
  }

  @Override
  public void addMethod(String signature, String body) {
    super.addMethod(signature, body);
  }

  public void addAbstractMethod(String signature) {
    super.add(1, "abstract " + signature);
  }
}
