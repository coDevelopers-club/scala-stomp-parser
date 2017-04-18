package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class AckTest extends FlatSpec with Matchers {
  "Constructing a Ack frame" should
    "throw IllegalArgumentException without 'id' header" in {
    assertThrows[IllegalArgumentException] {
      new Ack(Map())
    }
  }
}
