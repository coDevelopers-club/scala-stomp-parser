package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class SendTest extends FlatSpec with Matchers {
  "Constructing a SEND frame " should "throw IllegalArgumentException without 'destination' header" in {
    assertThrows[IllegalArgumentException] {
      new Send(Map(), "body")
    }
  }
}
