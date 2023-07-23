import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar

object CeaserCipher {
  def encrypt(text:String, shift:Int):String={
    text.map{char =>
      if(char.isLetter) {
        val base = if(char.isUpper) 65 else 97
        val shiftedChar = ((char - base + shift)%26 + 26)%26 + base
        shiftedChar.toChar
      }
      else
        char
    }
  }

  def decrypt(cipherText:String, shift:Int): String={
    encrypt(cipherText, -shift)
  }

  def cipher(text:String, shift:Int, selectedFunction:(String,Int) => String) : String ={
    selectedFunction(text, shift)
  }

  def main(args: Array[String]): Unit = {
    print("Enter text to encrypt : ")
    val text = readLine()
    print("Enter shifting value : ")
    val shift = readInt()
    print("Type 'e' for encryption or 'd' for decryption : ")
    val method = readChar()

    if(method == 'e') println("Encrypted text : " + cipher(text, shift, encrypt))
    else if (method == 'd') println("Decrypted text : " + cipher(text, shift, decrypt))
    else println("Wrong letter")
  }
}