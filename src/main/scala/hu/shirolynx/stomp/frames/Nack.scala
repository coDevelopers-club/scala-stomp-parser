package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Nack private[frames](_headers: Map[String, String]) extends Frame {
  require(_headers.contains("id"))
  override val command: Command = Command.NACK
  override val headers: Map[String, String] = _headers
}

object Nack {
  def apply(headers: Map[String, String]) = new Nack(headers)

  def apply(id: String) = new Nack(Map("id" -> id))
}
