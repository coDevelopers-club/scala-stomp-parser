package hu.shirolynx.stomp.frames

import io.circe._
import io.circe.parser._


trait FrameWithBody extends Frame {
  val body: String

  override def toString: String =
    s"${command}\n${printHeaders}\n\n${body}\u0000"

  def bodyAsJson: Json = parse(body.trim) match {
    case Left(_) => Json.Null
    case Right(json) => json
  }
}
