class Vector3(val x: Double, val y: Double, val z: Double) {

    def +(v: Vector3) = new Vector3(x+v.x, y+v.y, z+v.z)
    def -(v: Vector3) = new Vector3(x-v.x, y-v.y, z-v.z)
    def *(s: Double) = new Vector3(s*x, s*y, s*z)

    def dot(v: Vector3) = (x*v.x + y*v.y + z*v.z).toDouble
    def cross(v: Vector3) = new Vector3(y*v.z - z*v.y, z*v.x - x*v.z, x*v.y - y*v.x)

    def normalize(): Vector3 = {
        val mag = math.sqrt(x * x + y * y + z * z)
        new Vector3(x/mag, y/mag, z/mag)
    }

}
