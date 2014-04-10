package client

import java.net.Socket
import java.io._

/**
 * Created by FScoward on 2014/04/06.
 */
object Client {
  def main(args: Array[String]): Unit = {
    val socket = new Socket("localhost", 1025)

    println("connected to " + socket.getRemoteSocketAddress)

    val fileInputStream =
      new BufferedInputStream(new FileInputStream("C:\\Users\\FScoward\\Downloads\\archlinux-2014.03.01-dual.iso"))
    val outputStream = socket.getOutputStream
    val buf = new Array[Byte](4096)

    val start = System.currentTimeMillis()
    try{
      Iterator.continually(fileInputStream).takeWhile(_.read(buf) != -1).foreach{ x =>
//        println("sending...")
        outputStream.write(buf)
      }
    }finally {
      outputStream.close()
    }
    fileInputStream.close()

    println("Time: " + (System.currentTimeMillis() - start) + "msec")

    /* 入力待ちする */
    println("終了: exit")

//    waitInput(readLine())

    socket.close()
    println("接続断")
  }
  def waitInput(s:String) : Unit = {
    s match {
      case "exit" => /* 終了処理 */
      case _ => waitInput(readLine()) /* 他のキーだったら再び入力待ち */
    }
  }
}
