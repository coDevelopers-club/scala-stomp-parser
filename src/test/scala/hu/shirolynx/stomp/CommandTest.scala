package hu.shirolynx.stomp

import org.scalatest.{FlatSpec, Matchers}

class CommandTest extends FlatSpec with Matchers {
  "withNameOpt" should "return CONNECT" in {
    assertResult(Some(Command.CONNECT)) {
      Command.withNameOpt("CONNECT")
    }

  }

}
