package com.example.iwrite;

import org.andengine.entity.sprite.Sprite;
import android.media.MediaPlayer;
 
public class NumberSprites 
{
	
	//set cursor/fish position
	public static void setCursorPosition(Sprite x)
	{
		MainActivity.cursor.setPosition(x.getX()+10, x.getY()+10);
		MainActivity.mScene.sortChildren();
	}
	
	//set cursor/fish rotation
	public static void setCursorRotation(float x, float y)
	{
		
		MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
				y-MainActivity.cursor.getHeight()/2);
		
		 float directionX = x;
         float directionY = y;

         float rotationAngle = (float) Math.atan2(directionY, directionX);
         MainActivity.cursor.setRotationCenter(MainActivity.cursor.getWidth()/2, MainActivity.cursor.getHeight() / 2);
         MainActivity.cursor.setRotation(org.andengine.util.math.MathUtils
                    .radToDeg(rotationAngle));
	}
	
	//Audio play Function
	public static void playAudio(int val)
	{
		if(MainActivity.audioPlay)
		{
			MainActivity.mediaPlayer = MediaPlayer.create(MainActivity.MainActivityInstace.getBaseContext(), val);
			try 
			{
				MainActivity.mediaPlayer.start();
				MainActivity.mediaPlayer.setLooping(false);
			} 
			catch (IllegalStateException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MainActivity.audioPlay = true;
		}
	}
}
