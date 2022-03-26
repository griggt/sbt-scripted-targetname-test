object B {
  def main(args: Array[String]): Unit = {
    val a = new A()
    assert(a.name == a.expectedName)
  }
}
