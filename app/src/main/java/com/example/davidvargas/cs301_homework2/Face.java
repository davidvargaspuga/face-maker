package com.example.davidvargas.cs301_homework2;
//@David Vargas Puga
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Face {

    private int hairStyle;
    private Paint skinPaint = new Paint();
    private Paint eyePaint = new Paint ();
    private Paint hairPaint = new Paint();


    //constructor for the Face class
    public Face ()
    {
        this.Randomize(); //calls the Randomize method


    }


    //following method randomizes the hair style and the colors of the
    //skin, eyes, hair.
    public void Randomize ()
    {
        //generates a random number
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        //uses a random number to determine the attributes of the face that will be drawn
        switch(randomNumber)
        {
            case 0:
                skinPaint.setColor(Color.YELLOW);
                eyePaint.setColor(Color.BLUE);
                hairPaint.setColor(Color.RED);
                break;
            case 1:
                skinPaint.setColor(Color.MAGENTA);
                eyePaint.setColor(Color.GREEN);
                hairPaint.setColor(Color.GRAY);
                break;
            case 2:
                skinPaint.setColor(Color.WHITE);
                eyePaint.setColor(Color.CYAN);
                hairPaint.setColor(Color.BLACK);
                break;
        }
        hairStyle = random.nextInt(3);

    }


    //following method draws the face
    public void draw(Canvas canvas)
    {
        canvas.drawCircle(900,650,500, skinPaint); //draws head
        drawEye(canvas); //draws the eyes on the head
        drawHair(canvas); //draws the hair on the head
    }

    //following method draws two individual eyes
    public void drawEye(Canvas canvas)
    {
        canvas.drawCircle(725+(80/4), 500+(80/4), 80, eyePaint); //creates the iris of the eye
        canvas.drawCircle(725+(80/3), 500+(80/3), 80/2, new Paint(Color.BLACK)); //creates the diameter of pupil of the eye

        canvas.drawCircle(1000+(80/4), 500+(80/4), 80, eyePaint); //creates the iris of the eye
        canvas.drawCircle(1000+(80/3), 500+(80/3), 80/2, new Paint(Color.BLACK)); //creates the diameter of pupil of the eye

    }

    //following method can draw three different hair styles, dependent hairStyle integer
    public void drawHair(Canvas canvas)
    {
        switch (hairStyle)
        {
            case 1: //draws bowl-cut
                canvas.drawArc(325, 100, 1475, 775, 180F, 180F, true, hairPaint);
                break;
            case 2:
                //draws long hair
                canvas.drawArc(325, 100, 1475, 775, 180F, 180F, true, hairPaint);
                canvas.drawArc(250,175,1000, 1025, 90, 180F, true, hairPaint );
                canvas.drawArc(775,175,1550, 1025, -90, 180F, true, hairPaint );
                break;
            case 3:
                //draws short hair
                canvas.drawRect(425, 100, 1375, 400, hairPaint);
                break;
        }
    }

    //a setter method for the hair style drawn
    public void setHairStyle(int hairStyle)
    {
        this.hairStyle = hairStyle;


    }

    /**
     External Citation
     Date: 28 September 2018
     Problem: Did not know how to determine the indivual rgb
     values from an int color.
     Resource:
     https://stackoverflow.com/questions/17183587/convert
     -integer-color-value-to-rgb
     Solution: I used the example code from this post for several
     of the following methods.
     */

    //getter method for the rgb values of the skin color
    public int getSkinColor(int color)
    {
        //int skin = 0;
        int rgb = skinPaint.getColor();
        switch(color)
        {
            case 0:
                return ((rgb >> 16) & 0xFF); //retrieves red value

            case 1:
                return ((rgb >> 8) & 0xFF); //retrieves green value

            case 2:
                return ((rgb) & 0xFF); //retrieves blue value
        }
        return 0;
    }

    //getter method for the rgb values of the eye color
    public int getEyeColor(int color)
    {
        int rgb = eyePaint.getColor(); //converts paint to integer color
        switch(color)
        {
            case 0:
                return ((rgb >> 16) & 0xFF); // retrieves red value

            case 1:
                return ((rgb >> 8) & 0xFF); //retrieves green value

            case 2:
                return ((rgb) & 0xFF); //retrieves blue value
        }
        return 0;
    }

    //getter method for the rgb values of the hair color
    public int getHairColor(int color)
    {
        int rgb = hairPaint.getColor(); //converts paint to integer color
        switch(color)
        {
            case 0:
                return ((rgb >> 16) & 0xFF); //retrieves red value

            case 1:
                return ((rgb >> 8) & 0xFF); //retrieves green value

            case 2:
                return ((rgb) & 0xFF); //retrieves blue value
        }
        return 0;
    }


    //setter method for the rgb values of the skin color
    public void setSkinColor(int progress, int color)
    {
        int rgb = skinPaint.getColor(); //retrieves the integer of the color

        //following lines retrieve the current rgb values
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = (rgb) & 0xFF;

        //the new, specific rgb value will be implemented to the new color
        switch (color)
        {
            case 0: //red
                this.skinPaint.setARGB(255, progress, green, blue);
                break;
            case 1: //green
                this.skinPaint.setARGB(255, red, progress, blue);
                break;
            case 2: //blue
                this.skinPaint.setARGB(255, red, green, progress);
                break;
        }
    }

    //setter method for the rgb values of the hair color
    public void setHairColor(int progress, int color)
    {
        int rgb = hairPaint.getColor(); //retrieves the integer of the color

        //following lines retrieve the current rgb values
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = (rgb) & 0xFF;

        //the new, specific rgb value will be implemented to the new color
        switch (color)
        {
            case 0: //red
                this.hairPaint.setARGB(255, progress, green, blue);
                break;
            case 1: //green
                this.hairPaint.setARGB(255, red, progress, blue);
                break;
            case 2: //blue
                this.hairPaint.setARGB(255, red, green, progress);
                break;
        }
    }

    //setter method for the rgb values of the eye color
    public void setEyeColor(int progress, int color)
    {
        int rgb = eyePaint.getColor(); //retrieves the integer of the color

        //following lines retrieve the current rgb values
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = (rgb) & 0xFF;

        //the new, specific rgb value will be implemented to the new color
        switch (color)
        {
            case 0: //red
                this.eyePaint.setARGB(255, progress, green, blue);
                break;
            case 1: //green
                this.eyePaint.setARGB(255, red, progress, blue);
                break;
            case 2: //blue
                this.eyePaint.setARGB(255, red, green, progress);
                break;
        }
    }
}
