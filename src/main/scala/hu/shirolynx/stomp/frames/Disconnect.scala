package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Disconnect private[frames](_headers: Map[String, String]) extends Frame {
  override val command: Command = Command.DISCONNECT
  override val headers: Map[String, String] = _headers
}

object Disconnect {
  def apply(headers: Map[String, String]) = new Disconnect(headers)

  def apply() = new Disconnect(Map())
}