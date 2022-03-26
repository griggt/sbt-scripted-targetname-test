import annotation.targetName

@targetName("C") class A {
  def name = getClass().getSimpleName()
  val expectedName: String = "C"
}
