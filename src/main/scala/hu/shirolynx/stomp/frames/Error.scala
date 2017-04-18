package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Error private[frames](_headers: Map[String, String], _body: String) extends FrameWithBody {
  override val command: Command = Command.ERROR
  override val headers: Map[String, String] = _headers
  override val body: String = _body
}

object Error {
  def apply(_headers: Map[String, String], _body: String): Error = new Error(_headers, _body)

  def apply(headers: Map[String, String]) = new Error(headers, "")
}