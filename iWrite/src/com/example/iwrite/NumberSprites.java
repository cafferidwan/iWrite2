package com.example.iwrite;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import Animation.Animation;
import Animation.HandTutorial;
import Popup.PopUp;
import android.media.MediaPlayer;

 
public class NumberSprites 
{
	
	public static void getStructure(float x, float y)
	{
		
		if(MainActivity.state==1)
		{
			//Drawing the chalk
			Animation.Draw(x, y); 
			
			//setting the position of posX, posY
			MainActivity.posX = MainActivity.numberSprites[1].getX()+MainActivity.numberSprites[1].getWidth()/2-20;
			MainActivity.posY = MainActivity.numberSprites[1].getY()+MainActivity.numberSprites[1].getHeight()/2-20;

			if( 
				   MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
				   ||MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
				|| MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[3]) 
				|| MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[4])
					)
			{
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[1]);
				
				//if out of the area the remove white chalks
				for(int a=0; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				}
				
			}
			//if in the area and collides the right number sprite then remove and pass to the
			//next number sprite
			else 
			{
				setCursorRotation(x, y);
				
				remove(2, 1,2);
			}
			
		}  
		else if(MainActivity.state==2)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[2].getX()+MainActivity.numberSprites[2].getWidth()/2-20;
			MainActivity.posY = MainActivity.numberSprites[2].getY()+MainActivity.numberSprites[2].getHeight()/2-20;

			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 ||MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
				|| MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[4]) 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[2]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				}
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(3,2,3);
			}
		}
		else if(MainActivity.state==3)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[3].getX()+MainActivity.numberSprites[3].getWidth()/2-20;
			MainActivity.posY = MainActivity.numberSprites[3].getY()+MainActivity.numberSprites[3].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 ||MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
				|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
				)
			{
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[3]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
						//if wrong and not shaking the shake as wrong signal
						if(MainActivity.isShaking == false)
						{
							Animation.shake(1, MainActivity.moOutLine, 10);

						}
					}
				}
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(4,3,4);
			}
		}
		else if(MainActivity.state==4)
		{
			//creating new line of numbers
			MainActivity.spriteCounterLimit=7;
			Animation.scale(MainActivity.moOutLineX ,
					MainActivity.moOutLineY+300 - 350, MainActivity.spriteCounter); 
			MainActivity.state=5;
		}
		else if(MainActivity.state==5)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[5].getX()+MainActivity.numberSprites[5].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[5].getY()+MainActivity.numberSprites[5].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[5]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				}
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(6,5,6);
			}
		}
		else if(MainActivity.state==6)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[6].getX()+MainActivity.numberSprites[6].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[6].getY()+MainActivity.numberSprites[6].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[6]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				}
				
			}
			else 
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(7,6,7);
			}
		}  
		else if(MainActivity.state==7)
		{
			MainActivity.spriteCounterLimit=9;
			Animation.scale(MainActivity.moOutLineX-50*MainActivity.spriteCounter +410 ,
					MainActivity.moOutLineY-30*MainActivity.spriteCounter + 340, MainActivity.spriteCounter); 
			MainActivity.state=8;
		}
		else if(MainActivity.state==8)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[7].getX()+MainActivity.numberSprites[7].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[7].getY()+MainActivity.numberSprites[7].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35  
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[7]);
				
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
			}
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(8,7,9);
			}
		}
		else if(MainActivity.state==9)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[8].getX()+MainActivity.numberSprites[8].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[8].getY()+MainActivity.numberSprites[8].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			 
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[8]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(9,8,10);
			} 
		}
		else if(MainActivity.state==10)
		{
			MainActivity.spriteCounterLimit=13;
			Animation.scale(MainActivity.moOutLineX+40*MainActivity.spriteCounter -385 ,
					MainActivity.moOutLineY+50*MainActivity.spriteCounter-450, MainActivity.spriteCounter); 
			MainActivity.state=11;
		} 
		
		
		else if(MainActivity.state==11)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[9].getX()+MainActivity.numberSprites[9].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[9].getY()+MainActivity.numberSprites[9].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[9]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(10,9,12);
			}
		}
		else if(MainActivity.state==12)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[10].getX()+MainActivity.numberSprites[10].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[10].getY()+MainActivity.numberSprites[10].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[10]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(11,10,13);
			}
		}
		else if(MainActivity.state==13)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[11].getX()+MainActivity.numberSprites[11].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[11].getY()+MainActivity.numberSprites[11].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[11]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
	                
				remove(12,11,14);
			}
		}
		
		else if(MainActivity.state==14)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[12].getX()+MainActivity.numberSprites[12].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[12].getY()+MainActivity.numberSprites[12].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>40 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[12]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(13,12,16);
			}
		}
		else if(MainActivity.state==16)
		{
			MainActivity.spriteCounterLimit=16;
			Animation.scale(MainActivity.moOutLineX+120 , 
					80+MainActivity.moOutLineY-70*MainActivity.spriteCounter+1000, MainActivity.spriteCounter); 
			MainActivity.state=17; 
		}
		else if(MainActivity.state==17)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[13].getX()+MainActivity.numberSprites[13].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[13].getY()+MainActivity.numberSprites[13].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[13]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
	                
				remove(14,13,18);
			}
		} 
		else if(MainActivity.state==18)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[14].getX()+MainActivity.numberSprites[14].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[14].getY()+MainActivity.numberSprites[14].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[14]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(15,14,19); 
			}
		} 
		else if(MainActivity.state==19)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[15].getX()+MainActivity.numberSprites[15].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[15].getY()+MainActivity.numberSprites[15].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[15]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
				
				remove(16,15,20); 
			}
		}
		else if(MainActivity.state==20)
		{
			Animation.Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[16].getX()+MainActivity.numberSprites[16].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[16].getY()+MainActivity.numberSprites[16].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{

				
				//set the cursor to the last collided number sprite
				setCursorPosition(MainActivity.numberSprites[16]);
				
				//if out of the area the remove white chalks
				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
				{
					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(MainActivity.isShaking == false)
					{
						Animation.shake(1, MainActivity.moOutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				setCursorRotation(x, y);
	                
				remove(17,16,21); 
			}
		}
		
	}

	public static void remove(int collisionSprite, int removeSpriteNumber, int stateNUmber)
	{
		
		if(MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[collisionSprite]))
		{
			if(collisionSprite == 4)
			{
				MainActivity.mScene.detachChild(MainActivity.numberSprites[4]);
			}
			//removing the last number sprite
			if(collisionSprite == 16)
			{ 
				MainActivity.mScene.detachChild(MainActivity.numberSprites[16]);
				
				//trigger for taking screen shot
				MainActivity.jCounter = 1;
				//create book icon
				PopUp.createBookIcon();
				HandTutorial.handTutorialCreate();
				
			}
			MainActivity.mScene.detachChild(MainActivity.numberSprites[removeSpriteNumber]);
			MainActivity.numberSprites[removeSpriteNumber].setY(MainActivity.CAMERA_HEIGHT+500);
			MainActivity.wCounter =MainActivity. aCounter+2;
			MainActivity.state = stateNUmber;
			
			//play sound
			MainActivity.audioPlay = true;
			playAudio(R.raw.star);
			
		}
	}
	
	
	public static void rect(float x, float y)
	{
		Rectangle rect = new Rectangle(x, y, 30, 30, MainActivity.vertexBufferObjectManager);
		MainActivity.mScene.attachChild(rect);
		rect.setColor(Color.RED);
	}
	
	//set cursor position
	public static void setCursorPosition(Sprite x)
	{
		MainActivity.cursor.setPosition(x.getX()+10, x.getY()+10);
		MainActivity.mScene.sortChildren();
	}
	
	//set cursor rotation
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
