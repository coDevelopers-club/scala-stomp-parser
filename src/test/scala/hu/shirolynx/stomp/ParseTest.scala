package hu.shirolynx.stomp

import hu.shirolynx.stomp.frames._
import org.scalatest.{FlatSpec, Matchers}

class ParseTest extends FlatSpec with Matchers {
  "transformHeadersToMap" should "Map(\"A\" -> \"B\", \"C\" -> \"D\")" in {
    assertResult(Map("A" -> "B", "C" -> "D")) {
      Frame.transformHeadersToMap(List("A:B", "C:D"))
    }
  }

  "Parse" should "parse \"CONNECT\\naccept-version:1.2\\nhost:stomp.github.org\\n\\n\\u0000\" as CONNECT" in {
    assert(Frame("CONNECT\naccept-version:1.2\nhost:stomp.github.org\n\n\u0000").get match {
      case _: Connect => true
      case _ => false
    })
  }

  it should "parse \"STOMP\\naccept-version:1.2\\nhost:stomp.github.org\\n\\n\\u0000\" as STOMP" in {
    assert(Frame("STOMP\naccept-version:1.2\nhost:stomp.github.org\n\n\u0000").get match {
      case _: Stomp => true
      case _ => false
    })
  }

  it should "parse \"CONNECTED\\nversion:1.2\\n\\n\\u0000\" as CONNECTED" in {
    assert(Frame("CONNECTED\nversion:1.2\n\n\u0000").get match {
      case _: Connected => true
      case _ => false
    })
  }

  it should "parse \"SEND\\ndestination:/queue/a\\ncontent-type:text/plain\\n\\nhello queue a\\n\\u0000\" as CONNECTED" in {
    assert(Frame("SEND\ndestination:/queue/a\ncontent-type:text/plain\n\nhello queue a\n\u0000").get match {
      case _: Send => true
      case _ => false
    })
  }

  it should "parse \"SUBSCRIBE\\nid:0\\ndestination:/queue/foo\\nack:client\\n\\n\\u0000\" as SUBSCRIBE" in {
    assert(Frame("SUBSCRIBE\nid:0\ndestination:/queue/foo\nack:client\n\n\u0000").get match {
      case _: Subscribe => true
      case _ => false
    })
  }

  it should "parse \"UNSUBSCRIBE\\nid:0\\n\\n\\0000\" as UNSUBSCRIBE" in {
    assert(Frame("UNSUBSCRIBE\nid:0\n\n\0000").get match {
      case _: UnSubscribe => true
      case _ => false
    })
  }

  it should "parse \"ACK\\nid:12345\\ntransaction:tx1\\n\\n\\u0000\" as ACK" in {
    assert(Frame("ACK\nid:12345\ntransaction:tx1\n\n\u0000").get match {
      case _: Ack => true
      case _ => false
    })
  }

  it should "parse \"NACK\\nid:12345\\ntransaction:tx1\\n\\n\\u0000\" as NACK" in {
    assert(Frame("NACK\nid:12345\ntransaction:tx1\n\n\u0000").get match {
      case _: Nack => true
      case _ => false
    })
  }

  it should "parse \"BEGIN\\ntransaction:tx1\\n\\n\\u0000\" as BEGIN" in {
    assert(Frame("BEGIN\ntransaction:tx1\n\n\u0000").get match {
      case _: Begin => true
      case _ => false
    })
  }

  it should "parse \"COMMIT\\ntransaction:tx1\\n\\n\\u0000\" as COMMIT" in {
    assert(Frame("COMMIT\ntransaction:tx1\n\n\u0000").get match {
      case _: Commit => true
      case _ => false
    })
  }

  it should "parse \"ABORT\\ntransaction:tx1\\n\\n\\u0000\" as ABORT" in {
    assert(Frame("ABORT\ntransaction:tx1\n\n\u0000").get match {
      case _: Abort => true
      case _ => false
    })
  }

  it should "parse \"DISCONNECT\\nreceipt:77\\n\\u0000\" as DISCONNECT" in {
    assert(Frame("DISCONNECT\nreceipt:77\n\u0000").get match {
      case _: Disconnect => true
      case _ => false
    })
  }

  it should "parse \"MESSAGE\\nsubscription:0\\nmessage-id:007\\ndestination:/queue/a\\ncontent-type:text/plain\\n\\nhello queue a\\u0000\" as MESSAGE" in {
    assert(Frame("MESSAGE\nsubscription:0\nmessage-id:007\ndestination:/queue/a\ncontent-type:text/plain\n\nhello queue a\u0000").get match {
      case _: Message => true
      case _ => false
    })
  }

  it should "parse \"RECEIPT\\nreceipt-id:message-12345\\n\\n\\u0000\" as RECEIPT" in {
    assert(Frame("RECEIPT\nreceipt-id:message-12345\n\n\u0000").get match {
      case _: Receipt => true
      case _ => false
    })
  }

  it should "parse \"ERROR\\nreceipt-id:message-12345\\ncontent-type:text/plain\\ncontent-length:171\\nmessage: malformed frame received\\n\\nThe message:\\n-----\\nMESSAGE\\ndestined:/queue/a\\nreceipt:message-12345\\n\\nHello queue a!\\n\\u0000\" as ERROR" in {
    assert(Frame("ERROR\nreceipt-id:message-12345\ncontent-type:text/plain\ncontent-length:171\nmessage: malformed frame received\n\nThe message:\n-----\nMESSAGE\ndestined:/queue/a\nreceipt:message-12345\n\nHello queue a!\n\u0000").get match {
      case _: Error => true
      case _ => false
    })
  }
}
