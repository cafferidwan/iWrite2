package com.example.iwrite;

import org.andengine.input.touch.TouchEvent;
import org.andengine.util.debug.Debug;
import Letters.LetterStructureAa;
import Letters.LetterStructureBo;
import Letters.LetterStructureE;
import Letters.LetterStructureKo;
import Letters.LetterStructureLo;
import Letters.LetterStructureMo;
import Letters.LetterStructurePo;
import Letters.LetterStructureRaw;
import Letters.LetterStructureTalibaSha;
import ScreenShoot.ScreenShot;

public class Touch
{

	public static boolean touchEvent(TouchEvent pSceneTouchEvent)
	{
		if (pSceneTouchEvent.isActionDown()) 
		{
			MainActivity.touch = 1;
			Debug.d("Touch.x:"+(pSceneTouchEvent.getX()-50));
			Debug.d("Touch.y:"+(pSceneTouchEvent.getY()-50));
			
			return true;
		}
		else if (pSceneTouchEvent.isActionMove() && MainActivity.isPopupActive == false
				&& MainActivity.isHandTutorialActive == false && MainActivity.isActionMoving == true)
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
				
				
				Debug.d("spriteCounter:" + MainActivity.spriteCounter); 
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
				
				//For letter Mo
				if(MainActivity.letter == 1)
				{
					//building the structure for the letter with number sprite
					LetterStructureMo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Aa
				else if(MainActivity.letter == 2)
				{
					//building the structure for the letter with number sprite
					LetterStructureAa.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter E
				else if(MainActivity.letter == 3)
				{
					//building the structure for the letter with number sprite
					LetterStructureE.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Raw
				else if(MainActivity.letter == 4)
				{
					//building the structure for the letter with number sprite
					LetterStructureRaw.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Ko
				else if(MainActivity.letter == 5)
				{
					//building the structure for the letter with number sprite
					LetterStructureKo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Bo
				else if(MainActivity.letter == 6)
				{
					//building the structure for the letter with number sprite
					LetterStructureBo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter TalibaSha
				else if(MainActivity.letter == 7)
				{
					//building the structure for the letter with number sprite
					LetterStructureTalibaSha.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Lo
				else if(MainActivity.letter == 8)
				{
					//building the structure for the letter with number sprite
					LetterStructureLo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Po
				else if(MainActivity.letter == 9)
				{
					//building the structure for the letter with number sprite
					LetterStructurePo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				
				
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
