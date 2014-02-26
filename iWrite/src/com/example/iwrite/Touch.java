package com.example.iwrite;

import org.andengine.input.touch.TouchEvent;
import org.andengine.util.debug.Debug;

import Letters.LetterStructureA;
import Letters.LetterStructureAa;
import Letters.LetterStructureAkar;
import Letters.LetterStructureBo;
import Letters.LetterStructureCho;
import Letters.LetterStructureDo;
import Letters.LetterStructureDoh;
import Letters.LetterStructureE;
import Letters.LetterStructureEkar;
import Letters.LetterStructureGo;
import Letters.LetterStructureHo;
import Letters.LetterStructureKho;
import Letters.LetterStructureKo;
import Letters.LetterStructureLo;
import Letters.LetterStructureMo;
import Letters.LetterStructureNo;
import Letters.LetterStructurePo;
import Letters.LetterStructureRaw;
import Letters.LetterStructureTalibaSha;
import Letters.LetterStructureTo;
import Letters.LetterStructureToh;
import Letters.LetterStructureU;
import Letters.LetterStructureUkar;
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
				//For letter Go
				else if(MainActivity.letter == 10)
				{
					//building the structure for the letter with number sprite
					LetterStructureGo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Ho
				else if(MainActivity.letter == 11)
				{
					//building the structure for the letter with number sprite
					LetterStructureHo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Kho
				else if(MainActivity.letter == 12)
				{
					//building the structure for the letter with number sprite
					LetterStructureKho.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Cho
				else if(MainActivity.letter == 13)
				{
					//building the structure for the letter with number sprite
					LetterStructureCho.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter No
				else if(MainActivity.letter == 14)
				{
					//building the structure for the letter with number sprite
					LetterStructureNo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter No
				else if(MainActivity.letter == 15)
				{
					//building the structure for the letter with number sprite
					LetterStructureA.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Do
				else if(MainActivity.letter == 16)
				{
					//building the structure for the letter with number sprite
					LetterStructureDo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter U
				else if(MainActivity.letter == 17)
				{
					//building the structure for the letter with number sprite
					LetterStructureU.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter To
				else if(MainActivity.letter == 18)
				{
					//building the structure for the letter with number sprite
					LetterStructureTo.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Toh
				else if(MainActivity.letter == 19)
				{
					//building the structure for the letter with number sprite
					LetterStructureToh.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Doh
				else if(MainActivity.letter == 20)
				{
					//building the structure for the letter with number sprite
					LetterStructureDoh.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Ukar
				else if(MainActivity.letter == 21)
				{
					//building the structure for the letter with number sprite
					LetterStructureUkar.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Ekar
				else if(MainActivity.letter == 22)
				{
					//building the structure for the letter with number sprite
					LetterStructureEkar.getStructure(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY());
				}
				//For letter Akar
				else if(MainActivity.letter == 23)
				{
					//building the structure for the letter with number sprite
					LetterStructureAkar.getStructure(pSceneTouchEvent.getX(),
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
