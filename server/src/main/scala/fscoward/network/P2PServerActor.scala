package fscoward.network

import akka.actor.Actor
import java.net.{Socket, ServerSocket}
import java.io.{BufferedOutputStream, FileOutputStream, PrintWriter}

/**
 * Created by FScoward on 2014/04/06.
 */
class P2PServerActor extends Actor {

  def receive = {
    case socket: Socket => {
      println("connected... " + socket.getRemoteSocketAddress)

      // ファイル受信
      val inputStream = socket.getInputStream

      val buf = new Array[Byte](4096)

//      val out = new FileOutputStream("test.mp4")
      val out = new BufferedOutputStream(new FileOutputStream("test.mp4"))


      val start = System.currentTimeMillis()
      Iterator.continually(inputStream).takeWhile(_.read(buf) != -1).foreach{x =>
//        println("receive...")

        out.write(buf)

     /*
        val len = x.read(buf)
        if(len != -1){
          println("ReceiveBufferSize = " + socket.getReceiveBufferSize)
          out.write(buf, 0, len)
        }
        */
      }
      out.flush()
      out.close()

      inputStream.close()
      socket.close()

      println("Time: " + (System.currentTimeMillis() - start) + "msec")
      println("socket is closed? " + socket.isClosed)
      context.system.stop(self)
//      context.system.shutdown()
    }
  }

  override def preStart() = {
    println("preStart")
  }

  override def postStop() = {
    println("postStop")
  }

}
