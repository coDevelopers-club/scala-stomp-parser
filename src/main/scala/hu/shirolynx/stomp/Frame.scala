package hu.shirolynx.stomp

import hu.shirolynx.stomp.frames._

object Frame {

  def transformHeadersToMap(headers: List[String]): Map[String, String] =
    headers.map(x => x.splitAt(x.indexOf(":"))).map(x => (x._1, x._2.substring(1))).toMap

  def apply(str: String): Option[Frame] = {
    val (rawCommand, rawHeader, body) = ParserHelper.extract(str)
    val headers = transformHeadersToMap(rawHeader)
    val command = Command.withNameOpt(rawCommand)

    try {
      command.getOrElse(None) match {
        case Command.ABORT => Some(Abort(headers))
        case Command.ACK => Some(Ack(headers))
        case Command.BEGIN => Some(Begin(headers))
        case Command.COMMIT => Some(Commit(headers))
        case Command.CONNECT => Some(Connect(headers))
        case Command.CONNECTED => Some(Connected(headers))
        case Command.DISCONNECT => Some(Disconnect(headers))
        case Command.ERROR => Some(Error(headers, body))
        case Command.MESSAGE => Some(Message(headers, body))
        case Command.NACK => Some(Nack(headers))
        case Command.RECEIPT => Some(Receipt(headers))
        case Command.SEND => Some(Send(headers, body))
        case Command.SUBSCRIBE => Some(Subscribe(headers))
        case Command.UNSUBSCRIBE => Some(UnSubscribe(headers))
        case Command.STOMP => Some(Stomp(headers))
        case _ => None
      }
    } catch {
      case ex: IllegalArgumentException => {
        println(ex)
        None
      }
    }
  }

}

