package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command


class Send private[frames](_headers: Map[String, String], _body: String) extends FrameWithBody {
  require(_headers.contains("destination"), "SEND message requires destination header")
  override val command: Command = Command.SEND
  override val headers: Map[String, String] = _headers
  override val body: String = _body
}

object Send {
  def apply(_headers: Map[String, String], _body: String): Send = new Send(_headers, _body)

  def apply(_destination: String, _body: String): Send = new Send(Map("destination" -> _destination), _body)
}
