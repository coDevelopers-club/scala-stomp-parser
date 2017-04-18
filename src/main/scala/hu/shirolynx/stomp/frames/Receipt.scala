package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Receipt private[frames](_headers: Map[String, String]) extends Frame {
  require(_headers.contains("receipt-id"))
  override val command: Command = Command.RECEIPT
  override val headers: Map[String, String] = _headers
}

object Receipt {
  def apply(headers: Map[String, String]) = new Receipt(headers)

  def apply(receiptId: String) = new Receipt(Map("receipt-id" -> receiptId))
}
