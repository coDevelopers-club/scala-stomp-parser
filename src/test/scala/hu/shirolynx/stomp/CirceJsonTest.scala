package hu.shirolynx.stomp

import hu.shirolynx.stomp.frames.Send
import io.circe._
import org.scalatest.{FlatSpec, Matchers}

class CirceJsonTest extends FlatSpec with Matchers {
  "FrameWithBody.bodyAsJson" should " return Json.Null in case " in {
    val send = Send(Map("destination" -> "dest"), "")
    assertResult(Json.Null) {
      send.bodyAsJson
    }
  }

  it should " should contain field \"name\" with value \"json\"  " in {
    val send = Send(Map("destination" -> "dest"), "{\"name\":\"json\"}")
    assertResult("json") {
      val cursor: HCursor = send.bodyAsJson.hcursor
      cursor.downField("name").as[String] match {
        case Right(name) => name
        case Left(_) => ""
      }
    }
  }

  it should " should not contain field \"address\" with value \"code\"" in {
    val send = Send(Map("destination" -> "dest"), "{\"name\":\"json\"}")
    assert {
      val cursor: HCursor = send.bodyAsJson.hcursor
      cursor.downField("address").as[String] match {
        case Right(_) => false
        case Left(_) => true
      }
    }
  }


}
