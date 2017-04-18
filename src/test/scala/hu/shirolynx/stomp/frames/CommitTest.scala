package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class CommitTest extends FlatSpec with Matchers {
  "Constructing a COMMIT frame" should
    "throw IllegalArgumentException without 'transaction' header" in {
    assertThrows[IllegalArgumentException] {
      new Commit(Map())
    }
  }
}
