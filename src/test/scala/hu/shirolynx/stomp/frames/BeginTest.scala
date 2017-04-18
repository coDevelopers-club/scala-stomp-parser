package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class BeginTest extends FlatSpec with Matchers {
  "Constructing a BEGIN frame" should
    "throw IllegalArgumentException without 'transaction' header" in {
    assertThrows[IllegalArgumentException] {
      new Begin(Map())
    }
  }
}
