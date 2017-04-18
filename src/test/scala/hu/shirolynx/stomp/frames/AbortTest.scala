package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class AbortTest extends FlatSpec with Matchers {
  "Constructing a ABORT frame" should
    "throw IllegalArgumentException without 'transaction' header" in {
    assertThrows[IllegalArgumentException] {
      new Abort(Map())
    }
  }
}
