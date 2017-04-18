package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class ConnectedTest extends FlatSpec with Matchers {
  "Constructing a CONNECTED frame" should
    "throw IllegalArgumentException without 'version' header" in {
    assertThrows[IllegalArgumentException] {
      new Connected(Map())
    }
  }
}
