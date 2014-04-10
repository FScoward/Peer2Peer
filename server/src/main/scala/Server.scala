import fscoward.network.P2PServer

/**
  * Created by FScoward on 2014/04/06.
  */
object Server {
   def main(args: Array[String]): Unit = {
     println("Server Program")
     try{
       val p = new P2PServer()
       p.run

     }catch{
       case e: Exception => println("error")
     }
   }
 }
