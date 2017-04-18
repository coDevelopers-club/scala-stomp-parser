package hu.shirolynx.stomp.frames

import org.scalatest.{FlatSpec, Matchers}

class ReceiptTest extends FlatSpec with Matchers {
  "Constructing a Receipt frame" should
    "throw IllegalArgumentException without 'receipt-id' header" in {
    assertThrows[IllegalArgumentException] {
      new Receipt(Map())
    }
  }
}
