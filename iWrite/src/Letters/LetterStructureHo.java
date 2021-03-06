package Letters;

import org.andengine.entity.sprite.AnimatedSprite;
import Duster.Duster;
import Popup.PopUp;
import com.example.iwrite.MainActivity;
import com.example.iwrite.NumberSprites;
import com.example.iwrite.R;
import com.example.iwrite.StructureDrawAnimation;

public class LetterStructureHo 
{
	
	public static void Structure()
	{
		
		if(MainActivity.spriteCounterLimit == 4)
		{ 
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+60*MainActivity.spriteCounter - 100, 
					MainActivity.moOutLineY -50, MainActivity.spriteCounter);
		}
		else if(MainActivity.spriteCounterLimit == 7)
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX-70*MainActivity.spriteCounter+520 ,
					MainActivity.moOutLineY+60*MainActivity.spriteCounter - 350,
					MainActivity.spriteCounter);
		}
		else if(MainActivity.spriteCounterLimit == 9)
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+60*MainActivity.spriteCounter -410 ,
					MainActivity.moOutLineY+50*MainActivity.spriteCounter -290,
					MainActivity.spriteCounter);
		}
		else if(MainActivity.spriteCounterLimit == 12)
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX-80*MainActivity.spriteCounter +940 ,
					MainActivity.moOutLineY-40*MainActivity.spriteCounter+340,
					MainActivity.spriteCounter);
		}
		
	}
	
	
	//Creating the structure for the Letter by positioning co-ordinates and also drawing with chalk
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
				||MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
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
			StructureDrawAnimation.Draw(x, y);
				
			MainActivity.posX = MainActivity.numberSprites[2].getX()+MainActivity.numberSprites[2].getWidth()/2-20;
			MainActivity.posY = MainActivity.numberSprites[2].getY()+MainActivity.numberSprites[2].getHeight()/2-20;

			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 ||MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
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
					
					remove(3,2,3);
				}
			}
			else if(MainActivity.state==3)
			{
				StructureDrawAnimation.Draw(x, y);
				
				MainActivity.posX = MainActivity.numberSprites[3].getX()+MainActivity.numberSprites[3].getWidth()/2-20;
				MainActivity.posY = MainActivity.numberSprites[3].getY()+MainActivity.numberSprites[3].getHeight()/2-20;
				
				if(
						 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
						 ||MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
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
					
					remove(4,3,4);
				}
			}
			else if(MainActivity.state==4)
			{
				MainActivity.mScene.detachChild(MainActivity.numberSprites[4]);
				//creating new line of numbers
				MainActivity.spriteCounterLimit=7;
				StructureDrawAnimation.scale(MainActivity.moOutLineX +30,
						MainActivity.moOutLineY-10, MainActivity.spriteCounter); 
				MainActivity.state=5;
			}
			else if(MainActivity.state==5)
			{
				StructureDrawAnimation.Draw(x, y);
				
				MainActivity.posX = MainActivity.numberSprites[5].getX()+MainActivity.numberSprites[5].getWidth()/2-20; 
				MainActivity.posY = MainActivity.numberSprites[5].getY()+MainActivity.numberSprites[5].getHeight()/2-20;
				
				if(
						 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
						 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
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
					
					remove(6,5,6);
				}
			}
			else if(MainActivity.state==6)
			{
				StructureDrawAnimation.Draw(x, y);
				
				MainActivity.posX = MainActivity.numberSprites[6].getX()+MainActivity.numberSprites[6].getWidth()/2-20; 
				MainActivity.posY = MainActivity.numberSprites[6].getY()+MainActivity.numberSprites[6].getHeight()/2-20;
				
				if(
						 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
						 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
							|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
							|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
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
					
					remove(7,6,7);
				}
			}  
			else if(MainActivity.state==7)
			{
				MainActivity.spriteCounterLimit=9;
				StructureDrawAnimation.scale(MainActivity.moOutLineX-50*MainActivity.spriteCounter +470 ,
						MainActivity.moOutLineY-30*MainActivity.spriteCounter + 350, MainActivity.spriteCounter); 
				MainActivity.state=8;
			}
			else if(MainActivity.state==8)
			{
				StructureDrawAnimation.Draw(x, y);
				
				MainActivity.posX = MainActivity.numberSprites[7].getX()+MainActivity.numberSprites[7].getWidth()/2-20; 
				MainActivity.posY = MainActivity.numberSprites[7].getY()+MainActivity.numberSprites[7].getHeight()/2-20;
				
				if(
						 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
						 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
							|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
							|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35  
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
					
					remove(8,7,9);
				}
			}
			else if(MainActivity.state==9)
			{
				StructureDrawAnimation.Draw(x, y);
				
				MainActivity.posX = MainActivity.numberSprites[8].getX()+MainActivity.numberSprites[8].getWidth()/2-20; 
				MainActivity.posY = MainActivity.numberSprites[8].getY()+MainActivity.numberSprites[8].getHeight()/2-20;
				
				if(
						 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
						 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
							|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
							|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
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
					
					remove(9,8,10);
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
//					HandTutorial.handTutorialCreate();
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
	
	public static void createNumberSpriteAndCursor()
	{

		//creating the first line of numbers
		MainActivity.spriteCounterLimit = 4;
		StructureDrawAnimation.scale(MainActivity.moOutLineX -30, MainActivity.moOutLineY - 50, 1);
						
		//creating the fish cursor
		MainActivity.cursor = new AnimatedSprite(MainActivity.moOutLineX, MainActivity.moOutLineY, 
				MainActivity.mFishTextureRegion, MainActivity.vertexBufferObjectManager);
		MainActivity.cursor.animate(new long[]{100, 100, 100, 100, 100, 100}, 0, 5, true);
		MainActivity.cursor.setZIndex(3);
		MainActivity.mScene.attachChild(MainActivity.cursor);
						
		//setting the cursor to top of first number sprite
		NumberSprites.setCursorPosition(MainActivity.numberSprites[1]);
						
	}
}
