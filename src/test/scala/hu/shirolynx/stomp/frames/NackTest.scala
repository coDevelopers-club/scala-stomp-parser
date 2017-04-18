package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class NackTest extends FlatSpec with Matchers {
  "Constructing a Nack frame" should
    "throw IllegalArgumentException without 'id' header" in {
    assertThrows[IllegalArgumentException] {
      new Nack(Map())
    }
  }
}
