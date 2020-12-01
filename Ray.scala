import scala.math.pow
import java.awt.Color


class Ray(val origin:Vector3, val rayDir:Vector3) {

    def checkIntersection(shape: Sphere): Boolean = {
        val a = rayDir.dot(rayDir)
        val b = 2.0 * rayDir.dot(origin - shape.origin)
        val c = (origin - shape.origin).dot(origin - shape.origin) - pow(shape.radius, 2)
        val disc = b * b - 4.0 * a * c

        val intersects = {
            if (disc < 0.0) false else true
        }
        intersects
    }


    def computeIntersectCoord(s: Sphere): Vector3 = {
        val a = 1.0
        val b = rayDir.dot(origin - s.origin) * 2.0
        val c = math.abs((origin - s.origin).dot(origin - s.origin)) - s.radius * s.radius
        val disc = b * b - 4.0 * a * c
        if (disc == 0.0) {
            val t = -b / 2.0 * a
            origin + (rayDir * t)
        }
        else {
            val t = twoInterceptTs(a, b, c, disc)
            origin + rayDir * t
        }
    }

    def twoInterceptTs(a: Double, b: Double, c: Double, disc: Double): Double = {
        //Just a helper function for computeIntersectCoord
        val t0 = (-b + math.sqrt(disc)) / 2.0 * a
        val t1 = (-b - math.sqrt(disc)) / 2.0 * a

        if (t1 < t0) t1 else t0
    }
}







