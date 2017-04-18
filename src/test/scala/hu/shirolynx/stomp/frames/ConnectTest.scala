package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class ConnectTest extends FlatSpec with Matchers {
  "Constructing a CONNECT frame" should
    "throw IllegalArgumentException without 'accept-version' and 'host' header" in {
    assertThrows[IllegalArgumentException] {
      new Connect(Map())
    }
  }
}
