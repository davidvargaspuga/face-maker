package com.example.davidvargas.cs301_homework2;
//@David Vargas Puga
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class FaceView extends SurfaceView
{
    //initializes a Face
    Face face;

    public FaceView (Context context, AttributeSet set)
    {
        super(context, set); //invoke constructor of parent class
        //setFace(face);
        //face = new Face();//declares the Face
        setWillNotDraw(false);
    }

    public void setFace(Face f)
    {
        this.face = f;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas); //invoke constructor of parent class
        canvas.drawColor(Color.LTGRAY); //sets the of SurfaceView to light gray
        face.draw(canvas); //draws a face on the SurfaceView

    }


}
