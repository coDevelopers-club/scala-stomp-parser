package hu.shirolynx.stomp

object ParserHelper {
  def getLines(str: String): List[String] =
    str.split("\n").toList

  def splitAtEmptyLine(lines: List[String]): (List[String], List[String]) = {
    val raw = lines.splitAt(lines.indexWhere(x => x.isEmpty))
    (raw._1, raw._2.tail)
  }


  def splitAtFirstLine(lines: List[String]): (String, List[String]) =
    (lines.head, lines.tail)

  def extract(str: String): (String, List[String], String) = {
    val lines = getLines(str)
    val (command, rest) = splitAtFirstLine(lines)
    val (rawHeader, body) = splitAtEmptyLine(rest)

    (command, rawHeader, body.mkString("\n"))
  }
}
