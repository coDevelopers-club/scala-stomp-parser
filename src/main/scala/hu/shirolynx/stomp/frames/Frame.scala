package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command.Command


trait Frame {
  val command: Command
  val headers: Map[String, String]

  protected def printHeaders = headers.map { case (key, value) => s"$key:$value" }.mkString("\n")

  override def toString: String =
    s"${command}\n${printHeaders}\n\n\u0000"

}

