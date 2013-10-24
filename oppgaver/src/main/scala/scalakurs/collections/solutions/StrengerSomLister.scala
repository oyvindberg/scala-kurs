package scalakurs.collections.solutions

class StrengerSomLister {
   val engelskAlfabet = 'a' to 'z'

   def char2int(c: Char): Int = engelskAlfabet.indexOf(c.toLower)

   def int2char(i: Int): Char = engelskAlfabet(i)

   def listOfChars2String(l: List[Char]): String = l.mkString

   def list2string(l: List[Int]): String = l.map(int2char).mkString

   def nummerIAlfabetStreng(s: String): List[Int] = s.map(char2int).toList

   def rot13(c: Char): Char = c match {
     case ' ' => ' '
     case _ =>
       int2char((char2int(c) + 13) % 26)
   }

   def rot13(s: String): String = s.map(rot13)
 }
