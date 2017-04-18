package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Begin private[frames](_headers: Map[String, String]) extends Frame {
  require(_headers.contains("transaction"))
  override val command: Command = Command.BEGIN
  override val headers: Map[String, String] = _headers
}

object Begin {
  def apply(transaction: String) = new Begin(Map("transaction" -> transaction))

  def apply(headers: Map[String, String]) = new Begin(headers)
}
