package nekogochan.sourcegenerator;

@Deprecated
public class ClassGenerator extends Generator {

  private boolean notAbstract = true;

  public ClassGenerator(String _package, String _name) {
    super(_package, "public class", _name);
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
    if (notAbstract) {
      super.signature = "abstract " + super.signature;
    }
    notAbstract = false;
    super.add(1, "abstract " + signature + ";");
  }
}
