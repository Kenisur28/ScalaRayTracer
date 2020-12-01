import java.awt.image.BufferedImage
import java.awt.{Graphics2D,Color,Font,BasicStroke}


object Main {

    def main(args: Array[String]) : Unit = {
        val size = (1920,1080)
        val plane_orig = (0.0, 0.0, -0.05)
        val camera = new Vector3(plane_orig._1, plane_orig._2, plane_orig._3)
        val lightSource = new Vector3(100.0, 100.0, 100.0)

        val shapes: List[Sphere] = List(new Sphere(new Vector3(0.0, 0.0, 2.951), 3.0, Color.BLUE, 0.7))
        val pntLight = new Vector3(-30,40,200)

        val xAxis = -size._1/2 until size._1/2
        val yAxis = (-size._2/2 until size._2/2).reverse

        var scene = collection.mutable.Buffer.fill(size._1, size._2)(Color.BLACK)
        println("Starting Tracing!")
        //for each pixel in scene
        for (i <- 0 until xAxis.length) {
            for(j <- 0 until yAxis.length) {
                //create a new ray from the camera through the center of the pixel
                val r = new Ray(camera, new Vector3(xAxis(i) + 0.5, yAxis(j) + 0.5, 5.0))
                for(s <- 0 until shapes.length) {
                    if(!(r.checkIntersection(shapes(s)))) {
                        scene(i)(j) = Color.BLACK
                    } else {
                        scene(i)(j) = shapes(s).color


                    }
                }
            }

        }

        //create scene buffer
        val canvas = new BufferedImage(size._1, size._2, BufferedImage.TYPE_INT_RGB)
        for(px <- 0 until size._1; py <- 0 until size._2) {
            canvas.setRGB(px, py, scene(px)(py).getRGB())
        }

        // write image to a file
        javax.imageio.ImageIO.write(canvas, "png", new java.io.File("drawing.png"))
        println("DONE")
    }
}


