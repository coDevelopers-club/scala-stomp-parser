package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Abort private[frames](_headers: Map[String, String]) extends Frame {
  require(_headers.contains("transaction"))
  override val command: Command = Command.ABORT
  override val headers: Map[String, String] = _headers
}

object Abort {
  def apply(transaction: String) = new Abort(Map("transaction" -> transaction))

  def apply(headers: Map[String, String]) = new Abort(headers)
}
