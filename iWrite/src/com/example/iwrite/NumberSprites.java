package com.example.iwrite;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;
import android.media.MediaPlayer;

 
public class NumberSprites 
{
	
	public static void getStructure(float x, float y)
	{
		
		if(MainActivity.state==1)
		{
			//Drawing the chalk
			Draw(x, y); 
			
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
				MainActivity.cursor.setPosition(MainActivity.numberSprites[1].getX()+50,
						MainActivity.numberSprites[1].getY()+50);
				//MainActivity.mScene.sortChildren();
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				remove(2, 1,2);
			}
			
		}  
		else if(MainActivity.state==2)
		{
			Draw(x, y);
			
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
				MainActivity.cursor.setPosition(MainActivity.numberSprites[2].getX()+50,
						MainActivity.numberSprites[2].getY()+50);
				//MainActivity.mScene.sortChildren();
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(3,2,3);
			}
		}
		else if(MainActivity.state==3)
		{
			Draw(x, y);
			
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
				MainActivity.cursor.setPosition(MainActivity.numberSprites[3].getX()+50,
						MainActivity.numberSprites[3].getY()+50);
				////MainActivity.mScene.sortChildren();
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
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
			Draw(x, y);
			
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
				MainActivity.cursor.setPosition(MainActivity.numberSprites[5].getX()+50,
						MainActivity.numberSprites[5].getY()+50);
				//MainActivity.mScene.sortChildren();
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(6,5,6);
			}
		}
		else if(MainActivity.state==6)
		{
			Draw(x, y);
			
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
				MainActivity.cursor.setPosition(MainActivity.numberSprites[6].getX()+50,
						MainActivity.numberSprites[6].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
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
			Draw(x, y);
			
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
				MainActivity.cursor.setPosition(MainActivity.numberSprites[7].getX()+50,
						MainActivity.numberSprites[7].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(8,7,9);
			}
		}
		else if(MainActivity.state==9)
		{
			Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[8].getX()+MainActivity.numberSprites[8].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[8].getY()+MainActivity.numberSprites[8].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			//rect(MainActivity.posX, MainActivity.posY);
			 
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				MainActivity.cursor.setPosition(MainActivity.numberSprites[8].getX()+50,
						MainActivity.numberSprites[8].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
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
			Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[9].getX()+MainActivity.numberSprites[9].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[9].getY()+MainActivity.numberSprites[9].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				MainActivity.cursor.setPosition(MainActivity.numberSprites[9].getX()+50,
						MainActivity.numberSprites[9].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(10,9,12);
			}
		}
		else if(MainActivity.state==12)
		{
			Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[10].getX()+MainActivity.numberSprites[10].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[10].getY()+MainActivity.numberSprites[10].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				MainActivity.cursor.setPosition(MainActivity.numberSprites[10].getX()+50,
						MainActivity.numberSprites[10].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(11,10,13);
			}
		}
		else if(MainActivity.state==13)
		{
			Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[11].getX()+MainActivity.numberSprites[11].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[11].getY()+MainActivity.numberSprites[11].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				MainActivity.cursor.setPosition(MainActivity.numberSprites[11].getX()+50,
						MainActivity.numberSprites[11].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(12,11,14);
			}
		}
		
		else if(MainActivity.state==14)
		{
			Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[12].getX()+MainActivity.numberSprites[12].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[12].getY()+MainActivity.numberSprites[12].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>40 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				MainActivity.cursor.setPosition(MainActivity.numberSprites[12].getX()+50,
						MainActivity.numberSprites[12].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
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
			Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[13].getX()+MainActivity.numberSprites[13].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[13].getY()+MainActivity.numberSprites[13].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				MainActivity.cursor.setPosition(MainActivity.numberSprites[13].getX()+50,
						MainActivity.numberSprites[13].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(14,13,18);
			}
		} 
		else if(MainActivity.state==18)
		{
			Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[14].getX()+MainActivity.numberSprites[14].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[14].getY()+MainActivity.numberSprites[14].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				MainActivity.cursor.setPosition(MainActivity.numberSprites[14].getX()+50,
						MainActivity.numberSprites[14].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(15,14,19); 
			}
		} 
		else if(MainActivity.state==19)
		{
			Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[15].getX()+MainActivity.numberSprites[15].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[15].getY()+MainActivity.numberSprites[15].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				MainActivity.cursor.setPosition(MainActivity.numberSprites[15].getX()+50,
						MainActivity.numberSprites[15].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(16,15,20); 
			}
		}
		else if(MainActivity.state==20)
		{
			Draw(x, y);
			
			MainActivity.posX = MainActivity.numberSprites[16].getX()+MainActivity.numberSprites[16].getWidth()/2-20; 
			MainActivity.posY = MainActivity.numberSprites[16].getY()+MainActivity.numberSprites[16].getHeight()/2-20;
			
			//Debug.d("dist.x:"+(MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX));
			//Debug.d("dist.y:"+(MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY));
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
					)
			{

				
				//set the cursor to the last collided number sprite
				MainActivity.cursor.setPosition(MainActivity.numberSprites[16].getX()+50,
						MainActivity.numberSprites[16].getY()+50);
				//MainActivity.mScene.sortChildren();
				
				
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
				MainActivity.cursor.setPosition(x - MainActivity.cursor.getWidth()/2,
						y-MainActivity.cursor.getHeight()/2);
				
				remove(17,16,20); 
			}
		}
	}

	public static void remove(int collisionSprite, int removeSpriteNumber, int stateNUmber)
	{
//		if(
//		MainActivity.whiteChalk[MainActivity.aCounter].getX()> 
//		MainActivity.numberSprites[collisionSprite].getX()-50 &&
//		
//		MainActivity.whiteChalk[MainActivity.aCounter].getX()<
//		MainActivity.numberSprites[collisionSprite].getX()+50 &&
//		
//		MainActivity.whiteChalk[MainActivity.aCounter].getY()<
//		MainActivity.numberSprites[collisionSprite].getY()+50 &&
//		
//		MainActivity.whiteChalk[MainActivity.aCounter].getY()>
//		MainActivity.numberSprites[collisionSprite].getY()-50
//				)
//		{
//			Debug.d("collided 1");
//		}
//		else
//		{
//			Debug.d("No collision");
//		}
		
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
	
	public static void area(float x, float y, float a, float b)
	{
		float rx = a-x;
		float ry = b-y;
		Rectangle rect = new Rectangle(x, y, rx, ry, MainActivity.vertexBufferObjectManager);
		MainActivity.mScene.attachChild(rect);
		rect.setColor(Color.GREEN);
	}

	
	public static void Draw(float x, float y)
	{
		MainActivity.aCounter++;
		MainActivity.whiteChalk[MainActivity.aCounter] = new Sprite(x -25, y-30, 
				MainActivity.mWhiteChalkTextureRegion, MainActivity.vertexBufferObjectManager);
		MainActivity.whiteChalk[MainActivity.aCounter].setZIndex(1);
		MainActivity.mScene.attachChild(MainActivity.whiteChalk[MainActivity.aCounter]);
		MainActivity.whiteChalk[MainActivity.aCounter].setScale((float) 0.6);
		MainActivity.mScene.sortChildren();
		//Debug.d("I:"+MainActivity.aCounter); 
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
