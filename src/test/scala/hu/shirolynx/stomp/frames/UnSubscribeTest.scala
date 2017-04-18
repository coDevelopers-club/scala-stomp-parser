package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class UnSubscribeTest extends FlatSpec with Matchers {
  "Constructing a UNSUBSCRIBE frame" should
    "throw IllegalArgumentException without 'id' header" in {
    assertThrows[IllegalArgumentException] {
      new UnSubscribe(Map())
    }
  }
}
