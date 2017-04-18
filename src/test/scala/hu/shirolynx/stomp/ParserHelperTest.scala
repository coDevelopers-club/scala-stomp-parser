package hu.shirolynx.stomp

import org.scalatest.{FlatSpec, Matchers}

class ParserHelperTest extends FlatSpec with Matchers {
  "getLines" should "return List(\"A\", \"B\")" in {
    assertResult(List("A", "B")) {
      ParserHelper.getLines("A\nB")
    }
  }

  it should "return List(\"A\", \"B\", \"\", \"C\" )" in {
    assertResult(List("A", "B", "", "C")) {
      ParserHelper.getLines("A\nB\n\nC")
    }
  }

  "sliceAtEmptyLine" should "return (List(\"A\",\"B\"),List(\"C\"))" in {
    assertResult((List("A", "B"), List("C"))) {
      ParserHelper.splitAtEmptyLine(List("A", "B", "", "C"))
    }
  }

  "splitAtFirstLine" should "return (\"A\",List(\"B\",\"\",\"C\"))" in {
    assertResult(("A", List("B", "", "C"))) {
      ParserHelper.splitAtFirstLine(List("A", "B", "", "C"))
    }
  }

  "extract" should "return (\"A\",List(\"B\"),\"C\\nD\")" in {
    assertResult(("A", List("B"), "C\nD")) {
      ParserHelper.extract("A\nB\n\nC\nD")
    }
  }


}
