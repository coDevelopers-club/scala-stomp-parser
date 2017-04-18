package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class STOMPTest extends FlatSpec with Matchers {
  "Constructing a STOMP frame " should
    "throw IllegalArgumentException without 'accept-version' and 'host' header" in {
    assertThrows[IllegalArgumentException] {
      new Connect(Map())
    }
  }
}
