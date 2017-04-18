package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class MessageTest extends FlatSpec with Matchers {
  "Constructing a MESSAGE frame" should
    "throw IllegalArgumentException without 'destination', 'message-id' header" in {
    assertThrows[IllegalArgumentException] {
      new Abort(Map())
    }
  }
}
