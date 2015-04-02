import scala.io.Source

/**
 * Created by sayon on 02.04.2015.
 */

object Solver extends App {

  val input = Source.fromFile("input.txt").getLines().map(_.split(" ").map(_.toInt)).toArray

  println(input.length)
  println(input(0).length)
  val verts = for(i <- 0 until 17; j <- 0 until 20) yield {for (k <- 0 to 3) yield input(i+k)(j) }
  println(verts(0))
  val vertsmax = verts.map(_.reduce(_ * _)).max

  val hors= for(i <- 0 until 17; j <- 0 until 20) yield {for (k <- 0 to 3) yield input(j)(i+k) }
  val horsmax = hors.map(_.reduce(_ * _)).max

  println(hors(0))

  val diags1 = for(i <- 0 until 17; j <- 0 until 17) yield {for (k <- 0 to 3) yield input(j+k)(i+k) }
  val diagsmax1 = diags1.map(_.reduce(_ * _)).max

  val diags2 = for(i <- 0 until 17; j <- 0 until 17) yield {for (k <- 0 to 3) yield input(j+3-k)(i+k) }
  val diagsmax2 = diags2.map(_.reduce(_ * _)).max

  println(diags1(0))
  println(diags2(0))

  println(horsmax max vertsmax max diagsmax1 max diagsmax2)

}
