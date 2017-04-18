package hu.shirolynx.stomp.frames

import hu.shirolynx.stomp.Command
import hu.shirolynx.stomp.Command.Command
import org.scalatest.{FlatSpec, Matchers}

class FrameTest extends FlatSpec with Matchers {
  "Frame.message" should " return STOMP format as stated in protocol " in {
    val sm = new Frame {
      override val command: Command = Command.STOMP
      override val headers: Map[String, String] = Map("headerName" -> "value")
    }

    assert(sm.toString == "STOMP\nheaderName:value\n\n\u0000")
  }

  "FrameWithBody.message" should " return MESSAGE format as stated in protocol " in {
    val sm = new FrameWithBody {
      override val body: String = "Body"
      override val command: Command = Command.STOMP
      override val headers: Map[String, String] = Map("headerName" -> "value")
    }

    assert(sm.toString == "STOMP\nheaderName:value\n\nBody\u0000")
  }


}
