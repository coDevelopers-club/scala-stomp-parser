package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Connect private[frames](_header: Map[String, String]) extends Frame {
  require(_header.contains("accept-version") && _header.contains("host"))
  override val command: Command = Command.CONNECT
  override val headers: Map[String, String] = _header
}

object Connect {
  def apply(header: Map[String, String]) = new Connect(header)

  def apply(acceptVersion: String, host: String) = new Connect(Map("accept-version" -> acceptVersion, "host" -> host))

  def apply(host: String) = new Connect(Map("accept-version" -> "1.0,1.1,2.0", "host" -> host))
}
