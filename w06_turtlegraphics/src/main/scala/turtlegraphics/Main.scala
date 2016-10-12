package turtlegraphics

import cslib.window.SimpleWindow

import java.awt.Color

object Main {
  def main(args: Array[String]): Unit = {

    // Create the window and turtle objects
    val window = new SimpleWindow(1000, 500, "Turtlegraphics")
    val t = new Turtle(window, Point(0, 0), 0, false)
    val t2 = new Turtle(window = window, position = Point(0, 0), angle = 0, isPenDown = false)

    //RECTANGLE-TEST
    t.jumpTo(Point(600,100))
    window.writeText("t1 Rectangle")
    val r = Rectangle(Point(600,100), width = 100, height = 50, angle = 0)
    r.draw(t)



    // Move to an initial position
    t.jumpTo(Point(100, 200));
    t.turnNorth()
    window.writeText("t1")

    t2.jumpTo(Point(100, 350));
    t2.turnNorth()
    window.writeText("t2")

    // Draw a rectangle
    t.penDown()
    for (i <- 1 to 4) {
      t.turnRight(90)
      t.forward(100)
    }
    t.penUp()

    t2.penDown()
    for (i <- 1 to 4) {
      t2.turnRight(90)
      t2.forward(75)
    }
    t2.penUp()

    // Move 50 pixels to the right of the first rectangle
    t.turnRight(90)
    t.forward(200)
    t.turnNorth()
    window.writeText("t1")
    t2.turnRight(90)
    t2.forward(200)
    t2.turnNorth()
    window.writeText("t2")

    // Draw a rectangle
    t.penDown()
    for (i <- 1 to 4) {
      t.turnRight(90)
      t.forward(100)
    }
    t2.penDown()
    for (i <- 1 to 4) {
      t2.turnRight(90)
      t2.forward(100)
    }

    // ### MIN CIRKEL ###
    t.jumpTo(Point(200,50))
    window.writeText("t1")
                              t2.jumpTo(Point(300,50))
                              window.writeText("t2")
    t.jumpTo(Point(200,90))
                              t2.jumpTo(Point(300,90))
    t.turnNorth()
                              t2.turnNorth()
    val myLength = 10
    val myAngleToTurn = 36

    for (i <- 0 until 360) {
      t.forward(1)
      t.turnLeft(1)
    }

    t.jumpTo(Point(150,90))
    t.turnNorth()

    for (i <- 0 until 360 by 36) {
      t.forward(10)
      t.turnLeft(36)
                              t2.turnRight(myAngleToTurn)
                              t2.forward(myLength)
    }
//     ### Slut på min cirkel ###


    val aniWsizeX = 1000
    val aniWsizeY = 800
    val aniW = new SimpleWindow(aniWsizeX, aniWsizeY, "Animation")
    var aniWdelay = 5

    // #############################################################
    // Först två rektanglar som ska scale:a och rotera synkroniserat
    val aniT = new Turtle(aniW, Point(0, 0), 0, false)
      val aniT2 = new Turtle(aniW, Point(0, 0), 0, false)
    var aniRect  = Rectangle(Point(-250,-250), width = 30, height = 15, angle = 0)
      var aniRect2 = Rectangle(Point(-250,-250), width = 15, height = 30, angle = 90)
    var aniC = 0
      var aniC2 = 0
    val aniScaleLoopRange = 400
      val ani2ScaleLoopRange = 650
    var aniRectSpeedY = 1.0
      var aniRect2SpeedY = 1.0
    val aniRectGravFactor = 0.04
      val aniRect2GravFactor = 0.04

    // ########################
    // Här två andra rektanglar
    val aniT3 = new Turtle(aniW, Point(0, 0), 0, false)
    val aniT4 = new Turtle(aniW, Point(0, 0), 0, false)
    var aniRect3  = Rectangle(Point(500,250), width = 30, height = 15, angle = 0)
    var aniRect4 = Rectangle(Point(500,250), width = 15, height = 30, angle = 90)
    var aniC3 = 0
    var aniC4 = 0
    val ani3ScaleLoopRange = 400
    val ani4ScaleLoopRange = 650
    var aniRect3StepSizeX = 1
    var aniRect3StepSizeY = 1
    var aniRect4StepSizeX = 1
    var aniRect4StepSizeY = 1

    var mouseX = 0
    var mouseY = 0

      while(true) {
      aniW.clear()
      //Draw something here
      // Test black background
//      aniW.setLineWidth(5)
//        aniW.setLineColor(java.awt.Color.BLACK)
//      for (y <- 0 to aniWsizeY by 5) {
//        aniW.moveTo(0,y)
//          aniW.lineTo(aniWsizeX, y)
//      }
      // ########################################
      // ## De två första rektanglarna: #########
      // ## Synkroniserade scale- och   #########
      // ## rotationscyklar             #########
      // ########################################
      // ############## ANI #####################
      // ########################################
      aniW.setLineColor(java.awt.Color.GRAY)
      aniW.setLineWidth(1)
      aniRect = aniRect.rotateLeft(2.5 * math.sin(math.toRadians(0.90 * (aniC*360/aniScaleLoopRange))) + 0)
      aniC += 1

      if (aniC > aniScaleLoopRange) {aniC = 0}
      if (aniC <= aniScaleLoopRange/2) aniRect = aniRect.scale(1.01)
      else if (aniC > aniScaleLoopRange/2) aniRect = aniRect.scale(0.99)
      aniRect.draw(aniT)

      // ########################################
      // ############## ANI2 ####################
      // ########################################
          aniRect2 = aniRect2.rotateRight(2 * math.sin(math.toRadians(1 * (aniC2*360/ani2ScaleLoopRange))) + 0)
          aniC2 += 1

          if (aniC2 > ani2ScaleLoopRange) {aniC2 = 0}
          if (aniC2 <=ani2ScaleLoopRange/2) aniRect2 = aniRect2.scale(1.005)
          else if (aniC <=ani2ScaleLoopRange) aniRect2 = aniRect2.scale(0.995)
          aniRect2.draw(aniT2)
      //########################################
      //########################################
      //########################################

        // ########################################
        // ## Rektanglarna 3 och 4: ###############
        // ## Separata scale- och   ###############
        // ## rotationscyklar       ###############
        // ########################################
        // ############## ANI3 ####################
        // ########################################
        aniW.setLineColor(java.awt.Color.BLUE)
        aniW.setLineWidth(2)
        aniRect3 = aniRect3.rotateLeft(2.5 * math.sin(math.toRadians(0.90 * (aniC3*360/aniScaleLoopRange))) + 0)
        aniC3 += 1

        if (aniC3 > ani3ScaleLoopRange) {aniC3 = 0}
        if (aniC3 <= ani3ScaleLoopRange/2) aniRect3 = aniRect3.scale(1.01)
        else if (aniC3 > aniScaleLoopRange/2) aniRect3 = aniRect3.scale(0.99)
        aniRect3.draw(aniT)

        // ########################################
        // ############## ANI4 ###################
        // ########################################
        aniRect4 = aniRect4.rotateRight(2 * math.sin(math.toRadians(1 * (aniC4*360/ani4ScaleLoopRange))) + 0)
        aniC4 += 1

        if (aniC4 > ani4ScaleLoopRange) {aniC4 = 0}
        if (aniC4 <=ani4ScaleLoopRange/2) aniRect4 = aniRect4.scale(1.005)
        else if (aniC4 <=ani4ScaleLoopRange) aniRect4 = aniRect4.scale(0.995)
        aniRect4.draw(aniT2)
        // ########################################
        // ########## ANI/ANI2 GRAV ###############
        // ########################################
        // Vändning vid apex
        if (aniRectSpeedY > 0) aniRectSpeedY = aniRectSpeedY * (1+aniRectGravFactor)
        else if (aniRectSpeedY < 0) aniRectSpeedY = aniRectSpeedY * (1-aniRectGravFactor)
        // Vändning vid marken
        if(aniRect.getPos.y >= aniWsizeY) aniRectSpeedY = -1 * aniRectSpeedY
        if (aniRectSpeedY > -5*aniRect2GravFactor && aniRectSpeedY < 5*aniRect2GravFactor) aniRectSpeedY = 5*aniRect2GravFactor
        aniRect = aniRect.translate(0, aniRectSpeedY)

        // Vändning vid apex
        if (aniRect2SpeedY > 0) aniRect2SpeedY = aniRect2SpeedY * (1+aniRect2GravFactor)
        else if (aniRect2SpeedY < 0)aniRect2SpeedY = aniRect2SpeedY * (1-aniRect2GravFactor)
        // Vändning vid marken
        if(aniRect2.getPos.y >= aniWsizeY) aniRect2SpeedY = -1 * aniRect2SpeedY
        if (aniRect2SpeedY > -5*aniRect2GravFactor && aniRect2SpeedY < 5*aniRect2GravFactor) aniRect2SpeedY = 5*aniRect2GravFactor
        aniRect2 = aniRect2.translate(0, aniRect2SpeedY)

        // ########################################
        // #### FLYTTA ANI3/ANI4 KONTINUERLIGT ####
        // ########################################
        if(aniRect3.getPos.x == 0) aniRect3StepSizeX = -1 * aniRect3StepSizeX
        else if(aniRect3.getPos.x == aniWsizeX) aniRect3StepSizeX = -1 * aniRect3StepSizeX
        if(aniRect3.getPos.y == 0) aniRect3StepSizeY = -1 * aniRect3StepSizeY
        else if(aniRect3.getPos.y == aniWsizeY) aniRect3StepSizeY = -1 * aniRect3StepSizeY
        aniRect3 = aniRect3.translate(aniRect3StepSizeX, aniRect3StepSizeY)
        if(aniRect4.getPos.x == 0) aniRect4StepSizeX = -1 * aniRect4StepSizeX
        else if(aniRect4.getPos.x == aniWsizeX) aniRect4StepSizeX = -1 * aniRect4StepSizeX
        if(aniRect4.getPos.y == 0) aniRect4StepSizeY = -1 * aniRect4StepSizeY
        else if(aniRect4.getPos.y == aniWsizeY) aniRect4StepSizeY = -1 * aniRect4StepSizeY
        aniRect4 = aniRect4.translate(aniRect4StepSizeX, aniRect4StepSizeY)
        // ########################################
        // ##### Slut på ani3 och ani4 ############
        // ########################################

      // Registrera musens klickning
      aniW.waitForEvent(1)
      if (mouseX != aniW.getMouseX || mouseY != aniW.getMouseY) {
        // Flytta rektanglar 1 och 2 till muspekarens klickning
        aniRect = aniRect.translate(aniW.getMouseX - aniRect.getPos.x, aniW.getMouseY - aniRect.getPos.y)
        aniRect2 = aniRect2.translate(aniW.getMouseX - aniRect2.getPos.x, aniW.getMouseY - aniRect2.getPos.y)
        aniRectSpeedY = 1
        aniRect2SpeedY = 1
        mouseX = aniW.getMouseX
        mouseY = aniW.getMouseY
      }
      // Skriv ut infotext
      aniW.moveTo(5,12)
      aniW.setLineColor(java.awt.Color.GRAY)
      aniW.writeText("mousex: " + aniW.getMouseX + "         aniC: " + aniC + "         aniRect.width: " + aniRect.width)
      aniW.moveTo(5, 26)
      aniW.writeText("aniRect3StepSizeX: " + aniRect3StepSizeX + "      aniRect3StepSizeY: " + aniRect3StepSizeY)
      aniW.moveTo(5, 40)
      aniW.writeText("aniRectSpeedY: " + aniRectSpeedY)
      aniW.moveTo(5, 54)
      aniW.writeText("aniRect2SpeedY: " + aniRect2SpeedY)
      // Vänta så man ser vad som ritats innan det suddas
      var eventType = aniW.getEventType
      if (aniW.getKey == '1') aniWdelay = 15
      else if (aniW.getKey == '2') aniWdelay = 10
      else if (aniW.getKey == '3') aniWdelay = 5
      else if (aniW.getKey == '4') aniWdelay = 3
      else if (aniW.getKey == '5') aniWdelay = 1
      else if (aniW.getKey == '9') aniWdelay = 100
      else if (aniW.getKey == '0') aniWdelay = 250
      SimpleWindow.delay(aniWdelay)
    }

  }
}
