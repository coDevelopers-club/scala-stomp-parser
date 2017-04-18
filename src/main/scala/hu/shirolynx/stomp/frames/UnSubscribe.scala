package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class UnSubscribe private[frames](_headers: Map[String, String]) extends Frame {
  require(_headers.contains("id"))
  override val command: Command = Command.SUBSCRIBE
  override val headers: Map[String, String] = _headers
}

object UnSubscribe {
  def apply(headers: Map[String, String]) = new UnSubscribe(headers)

  def apply(id: String) = new UnSubscribe(Map("id" -> id))
}


