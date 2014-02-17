package Letters;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.util.debug.Debug;
import Duster.Duster;
import Popup.PopUp;
import com.example.iwrite.MainActivity;
import com.example.iwrite.NumberSprites;
import com.example.iwrite.R;
import com.example.iwrite.StructureDrawAnimation;

public class LetterStructurePo 
{
	
	//create numberSprite and cursor 
	public static void createNumberSpriteAndCursor()
	{
			 
		//creating the first line of numbers
		MainActivity.spriteCounterLimit = 3;
		StructureDrawAnimation.scale(MainActivity.moOutLineX -50, MainActivity.moOutLineY +25, 1);
					
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
		 
		if(MainActivity.spriteCounterLimit == 3) 
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX-1*MainActivity.spriteCounter +10, 
					MainActivity.moOutLineY+50*MainActivity.spriteCounter -60, MainActivity.spriteCounter); 
		}
		else if(MainActivity.spriteCounterLimit == 4)
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+30*MainActivity.spriteCounter - 150 ,
					MainActivity.moOutLineY-50*MainActivity.spriteCounter +260,
					MainActivity.spriteCounter);
		}
		else if(MainActivity.spriteCounterLimit == 7)
		{
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+60*MainActivity.spriteCounter - 300 ,
					MainActivity.moOutLineY+40*MainActivity.spriteCounter -250,
					MainActivity.spriteCounter);
		}
		
		else if(MainActivity.spriteCounterLimit == 10)   
		{ 
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+140 , 
					70+MainActivity.moOutLineY-30*MainActivity.spriteCounter+300,
					MainActivity.spriteCounter);
		}
		else if(MainActivity.spriteCounterLimit == 13)   
		{ 
			MainActivity.spriteCounter++;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+140 , 
					70+MainActivity.moOutLineY+90*MainActivity.spriteCounter-1070,
					MainActivity.spriteCounter);
		}
//		else if(MainActivity.spriteCounterLimit == 17)
//		{
//			MainActivity.spriteCounter++;
//			StructureDrawAnimation.scale(MainActivity.moOutLineX+200 , 
//					70+MainActivity.moOutLineY+80*MainActivity.spriteCounter-1250,
//					MainActivity.spriteCounter);
//		}
//		
//		else if(MainActivity.spriteCounterLimit == 19)
//		{
//			MainActivity.spriteCounter++;
//			StructureDrawAnimation.scale(MainActivity.moOutLineX+240 , 
//					MainActivity.moOutLineY-30,
//					MainActivity.spriteCounter);
//		}
	
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
				
				remove(3,2,3);
			}
		}
		else if(MainActivity.state==3)
		{
			//MainActivity.mScene.detachChild(MainActivity.numberSprites[3]);
			//creating new line of numbers
			MainActivity.spriteCounterLimit=4;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+90,
					MainActivity.moOutLineY+10, MainActivity.spriteCounter); 
			MainActivity.state=4;
		}
		else if(MainActivity.state==4)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[3].getX()+MainActivity.numberSprites[3].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[3].getY()+MainActivity.numberSprites[3].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-65 
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
			MainActivity.mScene.detachChild(MainActivity.numberSprites[4]);
			
			//creating new line of numbers
			MainActivity.spriteCounterLimit=7;
			StructureDrawAnimation.scale(MainActivity.moOutLineX-20,
					MainActivity.moOutLineY+10, MainActivity.spriteCounter); 
			NumberSprites.setCursorPosition(MainActivity.numberSprites[5]);
			
			MainActivity.state=6;
		}
		else if(MainActivity.state==6)
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
				
				remove(6,5,7); 
			}
		}   
		else if(MainActivity.state==7)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[6].getX()+MainActivity.numberSprites[6].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[6].getY()+MainActivity.numberSprites[6].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -65 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35  
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
				
				remove(7,6,8);
			}
		}
		else if(MainActivity.state==8)
		{
			MainActivity.mScene.detachChild(MainActivity.numberSprites[7]);
			
			MainActivity.spriteCounterLimit=10;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+140 ,
					MainActivity.moOutLineY-40, MainActivity.spriteCounter);
		
			NumberSprites.setCursorPosition(MainActivity.numberSprites[8]);
			
			MainActivity.state=10;
		}
		else if(MainActivity.state==10)
		{
			StructureDrawAnimation.Draw(x, y);
			
			//NumberSprites.setCursorPosition(MainActivity.numberSprites[8]);
			
			MainActivity.posX = MainActivity.numberSprites[8].getX()+MainActivity.numberSprites[8].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[8].getY()+MainActivity.numberSprites[8].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>100 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-105 
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
				 
				remove(9,8,11); 
			}
		}
		else if(MainActivity.state==11)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[9].getX()+MainActivity.numberSprites[9].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[9].getY()+MainActivity.numberSprites[9].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[9]);
				
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

				remove(10,9,13);
			}
		}
		else if(MainActivity.state==13)
		{
			StructureDrawAnimation.Draw(x, y); 
			
			MainActivity.posX = MainActivity.numberSprites[10].getX()+MainActivity.numberSprites[10].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[10].getY()+MainActivity.numberSprites[10].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -50 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>90 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-75 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[10]);
				
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
	                
				remove(12,11,14);
			}
		}
		else if(MainActivity.state==14)
		{
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[12].getX()+MainActivity.numberSprites[12].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[12].getY()+MainActivity.numberSprites[12].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-60 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[12]);
				
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
				
				remove(13,12,15);
			}
		}
		else if(MainActivity.state==15)
		{
			MainActivity.mScene.detachChild(MainActivity.numberSprites[13]);
			MainActivity.spriteCounterLimit=17;
			StructureDrawAnimation.scale(MainActivity.moOutLineX+160 ,
					MainActivity.moOutLineY+80*MainActivity.spriteCounter-1180, MainActivity.spriteCounter); 
			MainActivity.state=17;
		}
		else if(MainActivity.state==17)
		{

			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[14].getX()+MainActivity.numberSprites[14].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[14].getY()+MainActivity.numberSprites[14].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[14]);
				
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
	                
				remove(14,13,18);
			}
		} 
		else if(MainActivity.state==18)
		{
			
			StructureDrawAnimation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[14].getX()+MainActivity.numberSprites[14].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[14].getY()+MainActivity.numberSprites[14].getHeight()/2-20;
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-50 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(MainActivity.numberSprites[14]);
				
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
				
				remove(14,14,19); 
			}
		} 
		
		
	}
	
	
	public static void remove(int collisionSprite, int removeSpriteNumber, int stateNumber)
	{
		
		if(MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[collisionSprite]))
		{
			Debug.d("colli:"+collisionSprite);
			//removing when it is in the last state
			if(collisionSprite == 14)
			{ 
				MainActivity.mScene.detachChild(MainActivity.numberSprites[14]);
				
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
