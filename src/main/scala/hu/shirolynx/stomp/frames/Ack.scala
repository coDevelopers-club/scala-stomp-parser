package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Ack private[frames](_headers: Map[String, String]) extends Frame {
  require(_headers.contains("id"))
  override val command: Command = Command.ACK
  override val headers: Map[String, String] = _headers
}

object Ack {
  def apply(id: String) = new Ack(Map("id" -> id))

  def apply(headers: Map[String, String]) = new Ack(headers)
}
