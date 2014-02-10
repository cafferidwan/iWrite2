package com.example.iwrite;

import org.andengine.entity.sprite.Sprite;

import Animation.HandTutorial;
import Popup.PopUp;
import android.media.MediaPlayer;
 
public class NumberSprites 
{
	
	//when a sprite collides a number sprite then it is called;
	//it removes the number sprite and enables the next state for drawing
	public static void remove(int collisionSprite, int removeSpriteNumber, int stateNumber)
	{
		
		if(MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[collisionSprite]))
		{
			//removing when it is in the last state
			if(collisionSprite == 16)
			{ 
				MainActivity.mScene.detachChild(MainActivity.numberSprites[16]);
				
				//trigger for taking screen shot
				MainActivity.screenShotCounter = 1;
				//create book icon
				PopUp.createBookIcon();
				
				MainActivity.isActionMoving = false;
				
				//start the hand tutorial 
//				MainActivity.tutorialCounter++;
//				if(MainActivity.tutorialCounter==1)
//				{
					HandTutorial.handTutorialCreate();
//				}
			}
			MainActivity.mScene.detachChild(MainActivity.numberSprites[removeSpriteNumber]);
			MainActivity.numberSprites[removeSpriteNumber].setY(MainActivity.CAMERA_HEIGHT+500);
			MainActivity.wCounter =MainActivity. aCounter+2;
			MainActivity.state = stateNumber;
			
			//play sound
			MainActivity.audioPlay = true;
			playAudio(R.raw.star);
			
		}
	}
	
	
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
