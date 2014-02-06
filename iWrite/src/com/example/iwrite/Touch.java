package com.example.iwrite;

import org.andengine.input.touch.TouchEvent;
import org.andengine.util.debug.Debug;

import ScreenShoot.ScreenShot;

public class Touch
{

	public static boolean touchEvent(TouchEvent pSceneTouchEvent)
	{
		if (pSceneTouchEvent.isActionDown()) 
		{
			MainActivity.touch = 1;
			return true;
		}
		else if (pSceneTouchEvent.isActionMove() && MainActivity.isPopupActive == false
				&& MainActivity.isHandTutorialActive == false)
		{
			MainActivity.touch++;
			
			//sorting the scene child
			MainActivity.mScene.sortChildren();
			
			//enabling only by moving, disabling the tap
			if (MainActivity.touch>2)
			{
				//positioning the invisible rectangle according to the touch point 
				MainActivity.rect.setPosition(pSceneTouchEvent.getX() - MainActivity.rect.getWidth() / 2,
						pSceneTouchEvent.getY() - MainActivity.rect.getHeight() / 2);
				
				
				//Debug.d("spriteCounter:" + MainActivity.spriteCounter); 
				Debug.d("State:" + MainActivity.state);

				//enabling drawing from the first number sprite
				if (MainActivity.rect.collidesWith(MainActivity.numberSprites[1])) 
				{
					MainActivity.soundCounter++;
					if(MainActivity.soundCounter==1)
					{
						//play sound
						MainActivity.audioPlay = true;
						NumberSprites.playAudio(R.raw.star);
					}
					MainActivity.state = 1;
				}
				
				//building the structure for the letter with number sprite
				NumberSprites.getStructure(pSceneTouchEvent.getX(),
						pSceneTouchEvent.getY());
				
				//take the screenShoot when triggered
				if(MainActivity.screenShotCounter == 1)
				{
					ScreenShot.takeScreenShot();
				}
			}
			
			return true;
		}

		else if (pSceneTouchEvent.isActionUp()) 
		{
			MainActivity.touch = 0;
			return true;
		}
		return true;
	}
}