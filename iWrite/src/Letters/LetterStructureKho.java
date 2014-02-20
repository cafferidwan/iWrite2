package Letters;

import org.andengine.entity.sprite.AnimatedSprite;
import Duster.Duster;
import Popup.PopUp;
import com.example.iwrite.MainActivity;
import com.example.iwrite.NumberSprites;
import com.example.iwrite.R;
import com.example.iwrite.StructureDrawAnimation;

public class LetterStructureKho 
{
	
	//create numberSprite and cursor
	public static void createNumberSpriteAndCursor()
	{
			 
		//creating the first line of numbers
		MainActivity.spriteCounterLimit = 2;
		StructureDrawAnimation.scale(MainActivity.moOutLineX + 70 - 100, MainActivity.moOutLineY -20, 1);
					
		//creating the fish cursor
		MainActivity.cursor = new AnimatedSprite(MainActivity.moOutLineX, MainActivity.moOutLineY, 
				MainActivity.mFishTextureRegion, MainActivity.vertexBufferObjectManager);
		MainActivity.cursor.animate(new long[]{100, 100, 100, 100, 100, 100}, 0, 5, true);
		MainActivity.cursor.setZIndex(3);
		MainActivity.mScene.attachChild(MainActivity.cursor);
					
		//setting the cursor to top of first number sprite
		NumberSprites.setCursorPosition(MainActivity.numberSprites[1]);
	
	}
	
	public static void Structure()
	{
		
		if(MainActivity.spriteCounterLimit == 2) 
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+70*MainActivity.spriteCounter - 90, 
					MainActivity.moOutLineY -30, MainActivity.spriteCounter); 
		}
		else if(MainActivity.spriteCounterLimit == 4)
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX-20*MainActivity.spriteCounter + 80 ,
					MainActivity.moOutLineY+80*MainActivity.spriteCounter - 250,
					MainActivity.spriteCounter);
		}
		else if(MainActivity.spriteCounterLimit == 6)
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX-50*MainActivity.spriteCounter +420 ,
					MainActivity.moOutLineY-30*MainActivity.spriteCounter + 340,
					MainActivity.spriteCounter);  
		} 
		
		else if(MainActivity.spriteCounterLimit == 7)
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+20 , 
					70+MainActivity.moOutLineY-30*MainActivity.spriteCounter +340,
					MainActivity.spriteCounter);
		}
		else if(MainActivity.spriteCounterLimit == 9)
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+170 , 
					70+MainActivity.moOutLineY-140,
					MainActivity.spriteCounter);
		}
		
	}

	public static void getStructure(float x, float y) 
	{
		

		if(MainActivity.state==1)
		{
			//Drawing the chalk
			StructureDrawAnimation.Draw(x, y); 
			
			//setting the position of posX, posY
			MainActivity.posX = MainActivity.numberSprites[1].getX()+MainActivity.numberSprites[1].getWidth()/2-20;
			MainActivity.posY = MainActivity.numberSprites[1].getY()+MainActivity.numberSprites[1].getHeight()/2-20;

			if( 
				   MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
				||MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{ 
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[1]);
				
				//if out of the area the remove white chalks
				for(int a=0; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
					}
				}
				
			}
			//if in the area and collides the right number sprite then remove and pass to the next number sprite
			else 
			{
				NumberSprites.setCursorRotation(x, y);
				
				remove(2, 1,2);
			}
			
		}  
		else if(MainActivity.state==2)
		{
			//creating new line of numbers
			MainActivity.spriteCounterLimit=4;
			StructureDrawAnimation.scale(MainActivity.moOutLineX +60,
					MainActivity.moOutLineY+30, MainActivity.spriteCounter); 
			MainActivity.state=3;
		}
		else if(MainActivity.state==3)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[2].getX()+MainActivity.numberSprites[2].getWidth()/2-20;
			MainActivity.posY = MainActivity.numberSprites[2].getY()+MainActivity.numberSprites[2].getHeight()/2-20;

			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 ||MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[2]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
					}
				}
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(3,2,4);
			}
		}
		else if(MainActivity.state==4)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[3].getX()+MainActivity.numberSprites[3].getWidth()/2-20;
			MainActivity.posY = MainActivity.numberSprites[3].getY()+MainActivity.numberSprites[3].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 ||MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
				)
			{
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[3]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
						//if wrong and not shaking the shake as wrong signal
						if(MainActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);

						}
					}
				}
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(4,3,5);
			}
		}
		else if(MainActivity.state==5)
		{
			//creating new line of numbers
			MainActivity.spriteCounterLimit=6;
			StructureDrawAnimation.scale(MainActivity.moOutLineX +70,
					MainActivity.moOutLineY+100, MainActivity.spriteCounter); 
			MainActivity.state=6;
		}
		else if(MainActivity.state==6)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[4].getX()+MainActivity.numberSprites[4].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[4].getY()+MainActivity.numberSprites[4].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[4]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
					}
				}
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(5,4,7);
			}
		}
		else if(MainActivity.state==7)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[5].getX()+MainActivity.numberSprites[5].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[5].getY()+MainActivity.numberSprites[5].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[5]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
					}
				}
				
			}
			else 
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(6,5,8);
			}
		}  
		else if(MainActivity.state==8)
		{
			MainActivity.spriteCounterLimit=7;
			StructureDrawAnimation.scale(MainActivity.moOutLineX-50*MainActivity.spriteCounter +470 ,
					MainActivity.moOutLineY-30*MainActivity.spriteCounter + 260, MainActivity.spriteCounter); 
			MainActivity.state=9;
		}
		else if(MainActivity.state==9)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[6].getX()+MainActivity.numberSprites[6].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[6].getY()+MainActivity.numberSprites[6].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -65 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-100  
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[6]); 
				
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
					}
				} 
			}
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(7,6,10);
			}
		}
		else if(MainActivity.state==10)
		{
			
			MainActivity.spriteCounterLimit=9;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+40*MainActivity.spriteCounter -200 ,
					MainActivity.moOutLineY+50*MainActivity.spriteCounter-470, MainActivity.spriteCounter); 
			
			MainActivity.state=11; 
			
		} 
		else if(MainActivity.state==11)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[7].getX()+MainActivity.numberSprites[7].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[7].getY()+MainActivity.numberSprites[7].getHeight()/2-20;
			
			if( 
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-100 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[7]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(8,7,12);
			} 
		}
		else if(MainActivity.state==12)
		{
			StructureDrawAnimation.Draw(x, y);
			
			NumberSprites.setCursorPosition(MainActivity.numberSprites[8]);
			
			MainActivity.posX = MainActivity.numberSprites[8].getX()+MainActivity.numberSprites[8].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[8].getY()+MainActivity.numberSprites[8].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[8]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(9,8,13);
			}
		}
	}
	
	
	public static void remove(int collisionSprite, int removeSpriteNumber, int stateNumber)
	{
		
		if(MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[collisionSprite]))
		{
			//removing when it is in the last state
			if(collisionSprite == 9)
			{ 
				MainActivity.mScene.detachChild(MainActivity.numberSprites[9]);
				
				//trigger for taking screen shot
				MainActivity.screenShotCounter = 1;
				//create book icon
				PopUp.createBookIcon();
				//start duster
				Duster.startDuster();
				
				MainActivity.isActionMoving = false;
				
				//start the hand tutorial 
//				MainActivity.tutorialCounter++;
//				if(MainActivity.tutorialCounter==1)
//				{
					//HandTutorial.handTutorialCreate();
//				}
			}
			MainActivity.mScene.detachChild(MainActivity.numberSprites[removeSpriteNumber]);
			MainActivity.numberSprites[removeSpriteNumber].setY(MainActivity.CAMERA_HEIGHT+500);
			MainActivity.wCounter =MainActivity. aCounter+2;
			MainActivity.state = stateNumber;
			
			//play sound
			MainActivity.audioPlay = true;
			NumberSprites.playAudio(R.raw.star);
			
		}
	}

}
