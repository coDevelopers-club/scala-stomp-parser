package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class SubscribeTest extends FlatSpec with Matchers {
  "Constructing a SUBSCRIBE frame" should
    "throw IllegalArgumentException without 'destination' and 'id' header" in {
    assertThrows[IllegalArgumentException] {
      new Subscribe(Map())
    }
  }

}
