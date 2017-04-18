package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Connected private[frames](_headers: Map[String, String]) extends Frame {
  require(_headers.contains("version"))
  override val command: Command = Command.CONNECTED
  override val headers: Map[String, String] = _headers
}

object Connected {
  def apply(headers: Map[String, String]) = new Connected(headers)

  def apply(version: String) = new Connected(Map("version" -> version))
}


