package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command

class Commit private[frames](_headers: Map[String, String]) extends Frame {
  require(_headers.contains("transaction"))
  override val command: Command = Command.COMMIT
  override val headers: Map[String, String] = _headers
}

object Commit {
  def apply(transaction: String): Commit = new Commit(Map("transaction" -> transaction))

  def apply(headers: Map[String, String]): Commit = new Commit(headers)
}