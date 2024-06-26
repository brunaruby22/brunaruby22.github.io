#23 page 299 by Bruna Ruby Andreotti

import turtle
turtle.speed(5)
def main ():
    turtle.hideturtle()
    circle(0, -50, 100, 'white')
    circle(0, 110, 60, 'white')
    circle(0, 210, 40, 'white')
    circle(-10, 220, 5, 'beige')
    circle(10, 220, 5, 'beige')
    turtle.penup()
    turtle.right(90)
    turtle.forward(20)
    turtle.left(90)
    turtle.forward(10)
    turtle.right(180)
    turtle.pendown()
    turtle.forward (40)
    turtle.penup()
    turtle.right(90)
    turtle.forward (50)
    turtle.left(90)
    turtle.forward (20)
    turtle.right(90)
    turtle.pendown()
    square(40, 240, 20, 80, 'black')
    square(20, 260, 40, 40, 'black')
    turtle.penup()
    turtle.right(180)
    turtle.forward(125)
    turtle.left(90)
    turtle.forward(37)
    turtle.pendown()
    turtle.left (40)
    turtle.forward(50)
    turtle.left(45)
    turtle.forward(15)
    turtle.penup()
    turtle.right(180)
    turtle.forward(15)
    turtle.left(90)
    turtle.pendown()
    turtle.forward(15)
    turtle.penup()
    turtle.right(180)
    turtle.forward(15)
    turtle.left(45)
    turtle.forward(50)
    turtle.right(40)
    turtle.forward(112)
    turtle.pendown()
    turtle.right(10)
    turtle.forward(35)
    turtle.right(50)
    turtle.forward(30)
    turtle.left(65)
    turtle.forward(10)
    turtle.penup()
    turtle.right(180)
    turtle.forward(10)
    turtle.left(90)
    turtle.pendown()
    turtle.forward(10)
    
def circle (x, y, radius, color):
    turtle.penup()
    turtle.goto(x, y - radius)
    turtle.fillcolor(color)
    turtle.pendown()
    turtle.begin_fill()
    turtle.circle(radius)
    turtle.end_fill()

def square (x, y, width, length, color):
    turtle.penup()
    turtle.goto(x, y)
    turtle.fillcolor(color)
    turtle.pendown()
    turtle.begin_fill()
    for count in range (4):
        turtle.forward(width)
        turtle.left(90)
        turtle.forward(length)
        turtle.left(90)
    turtle.end_fill()

if (__name__=='__main__'):
    main()
    
