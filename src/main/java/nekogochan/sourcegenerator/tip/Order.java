package nekogochan.sourcegenerator.tip;

public enum Order {

  /* KEYWORDS */
  /* APPLIED TO ALL */
  // public protected private
  VISIBILITY(0),

  // modifiers
  ABSTRACT(1),
  STATIC(2),
  FINAL(3),
  TRANSIENT(4),
  VOLATILE(5),
  DEFAULT(6),
  SYNCHRONIZED(7),
  NATIVE(8),
  STRICTFP(9),

  /* applied to field: */
  FIELD_TYPE(10),
  FIELD_NAME(11),

  /* applied to method: */
  METHOD_TEMPLATES(10),
  METHOD_RETURN_TYPE(11),
  METHOD_NAME(12),
  METHOD_ARGS(13),

  /* applied to class */
  CLASS_TYPE(10),
  CLASS_NAME(11),
  CLASS_TEMPLATES(12),
  CLASS_EXTENDS(13),
  CLASS_IMPLEMENTS(14),

  /* enum */
  ENUM_VALUES(15),
  ENUM_FIELDS(16),
  ENUM_METHODS(17),
  ENUM_CONSTRUCTOR(18),

  /* interface */
  INTERFACE_FIELDS(15),
  INTERFACE_ABSTRACT(16),
  INTERFACE_DEFAULT(17),
  INTERFACE_STATIC(18),

  /* class */
  /* static field */
  CLASS_STATIC_PUBLIC_FIELDS(15),
  CLASS_STATIC_PROTECTED_FIELDS(16),
  CLASS_STATIC_PRIVATE_FIELDS(17),
  /* static method */
  CLASS_STATIC_PUBLIC_METHOD(18),
  CLASS_STATIC_PROTECTED_METHOD(19),
  CLASS_STATIC_PRIVATE_METHOD(20),
  /* abstract */
  CLASS_ABSTRACT_FIELD(21),
  CLASS_ABSTRACT_METHOD(22),
  /* field */
  CLASS_PUBLIC_FIELD(23),
  CLASS_PROTECTED_FIELD(24),
  CLASS_PRIVATE_FIELD(25),
  /* constructor */
  CLASS_CONSTRUCTOR(26),
  /* getters and setters */
  CLASS_GETTER(27),
  CLASS_SETTER(28),
  /* methods */
  CLASS_PUBLIC_METHOD(29),
  CLASS_PROTECTED_METHOD(30),
  CLASS_PRIVATE_METHOD(31)
  ;

  private final int value;

  public int getValue() {
    return value;
  }

  Order(int value) {
    this.value = value;
  }
}
