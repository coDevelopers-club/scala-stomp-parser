package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Subscribe private[frames](_headers: Map[String, String]) extends Frame {
  require(_headers.contains("destination") && _headers.contains("id"))
  override val command: Command = Command.SUBSCRIBE
  override val headers: Map[String, String] = _headers
}

object Subscribe {
  def apply(_headers: Map[String, String]) = new Subscribe(_headers)

  def apply(destination: String, id: String) = new Subscribe(Map("destination" -> destination, "id" -> id))
}
