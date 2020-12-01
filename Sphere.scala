
import java.awt.Color

class Sphere(val origin:Vector3, val radius:Double, val color:Color, val albeto: Double) {


    def getNormalVect(point: Vector3): Vector3 = {
      val del = new Vector3(2 * point.x, 2 * point.y, 2 * point.z)
      val norm = math.sqrt(del.x * del.x + del.y + del.y + del.z * del.z)

      new Vector3(del.x/norm, del.y/norm, del.z/norm)
  }
}
