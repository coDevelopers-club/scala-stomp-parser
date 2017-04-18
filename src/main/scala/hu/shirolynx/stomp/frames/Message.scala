package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Message private[frames](_headers: Map[String, String], _body: String) extends FrameWithBody {
  override val command: Command = Command.MESSAGE
  override val headers: Map[String, String] = _headers
  override val body: String = _body
}

object Message {
  def apply(headers: Map[String, String], body: String) = new Message(headers, body)

  def apply(headers: Map[String, String]): Message = new Message(headers, "")
}
