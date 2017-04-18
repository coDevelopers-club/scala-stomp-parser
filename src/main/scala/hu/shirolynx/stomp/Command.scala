package hu.shirolynx.stomp

object Command extends Enumeration {
  type Command = Value
  val CONNECT, STOMP, CONNECTED, SEND, SUBSCRIBE, UNSUBSCRIBE, BEGIN, COMMIT, ABORT, ACK, NACK, DISCONNECT,
  MESSAGE, RECEIPT, ERROR = Value

  def withNameOpt(s: String): Option[Command] = values.find(_.toString == s)
}
