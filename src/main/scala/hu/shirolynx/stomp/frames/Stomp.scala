package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Stomp private[frames](_header: Map[String, String]) extends Frame {
  require(_header.contains("accept-version") && _header.contains("host"))
  override val command: Command = Command.STOMP
  override val headers: Map[String, String] = _header
}

object Stomp {
  def apply(headers: Map[String, String]) = new Stomp(headers)

  def apply(acceptVersion: String, host: String) = new Stomp(Map("accept-version" -> acceptVersion, "host" -> host))

  def apply(host: String) = new Stomp(Map("accept-version" -> "1.0,1.1,2.0", "host" -> host))
}
