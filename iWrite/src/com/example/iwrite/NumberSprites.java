package com.example.iwrite;



public class NumberSprites 
{

	public static void createNumberSprites()
	{
		for(int y=1; y<16; y++)
		{
			if(MainActivity.whiteChalk[MainActivity.aCounter]!= null && MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[y]))
			{
//				MainActivity.a++;
//				if(MainActivity.a==1)
//				{
					MainActivity.numberSprites[y].setY(MainActivity.CAMERA_HEIGHT+1000);
					MainActivity.mScene.detachChild(MainActivity.numberSprites[y]);
					//MainActivity.spriteCounter++; 
					//Debug.d("MainActivity.spriteCounter:"+MainActivity.spriteCounter);
					//Animation.scale(MainActivity.moOutLineX+70*MainActivity.spriteCounter - 100, MainActivity.moOutLineY -50);
//				}
			}
		}
		
//		for(int y=4; y<7; y++)
//		{
//			if(MainActivity.whiteChalk[MainActivity.aCounter]!= null && MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[y]))
//			{
//				MainActivity.a++;
//				if(MainActivity.a==1)
//				{
//					MainActivity.numberSprites[y].setY(MainActivity.CAMERA_HEIGHT+200);
//					MainActivity.mScene.detachChild(MainActivity.numberSprites[y]);
//					//MainActivity.spriteCounter++; 
//					//Debug.d("MainActivity.spriteCounter:"+MainActivity.spriteCounter);
//					//Animation.scale(MainActivity.moOutLineX+30*MainActivity.spriteCounter - 150 , MainActivity.moOutLineY+60*MainActivity.spriteCounter - 350);
//				}
//			}
//		}
//		
//		for(int y=7; y<9; y++)
//		{
//			if(MainActivity.whiteChalk[MainActivity.aCounter]!= null && MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[y]))
//			{
//				MainActivity.a++;
//				if(MainActivity.a==1)
//				{
//					MainActivity.numberSprites[y].setY(MainActivity.CAMERA_HEIGHT+200);
//					MainActivity.mScene.detachChild(MainActivity.numberSprites[y]);
//					//MainActivity.spriteCounter++; 
//					//Debug.d("MainActivity.spriteCounter:"+MainActivity.spriteCounter);
//					//Animation.scale(MainActivity.moOutLineX-50*MainActivity.spriteCounter +410 , MainActivity.moOutLineY-30*MainActivity.spriteCounter + 340 );
//				}
//			}
//		}
//		
//		for(int y=9; y<12; y++)
//		{
//			if(MainActivity.whiteChalk[MainActivity.aCounter]!= null && MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[y]))
//			{
//				MainActivity.a++;
//				if(MainActivity.a==1)
//				{
//					MainActivity.numberSprites[y].setY(MainActivity.CAMERA_HEIGHT+200);
//					MainActivity.mScene.detachChild(MainActivity.numberSprites[y]);
//					//MainActivity.spriteCounter++;
//					//Debug.d("MainActivity.spriteCounter:"+MainActivity.spriteCounter);
//					//Animation.scale(MainActivity.moOutLineX+40*MainActivity.spriteCounter -345 , MainActivity.moOutLineY+50*MainActivity.spriteCounter-430 );
//				}
//			}
//		}
//		
//		for(int y=12; y<16; y++)
//		{
//			if(MainActivity.whiteChalk[MainActivity.aCounter]!= null && MainActivity.whiteChalk[MainActivity.aCounter].collidesWith(MainActivity.numberSprites[y]))
//			{
//				MainActivity.a++;
//				if(MainActivity.a==1)
//				{
//					MainActivity.numberSprites[y].setY(MainActivity.CAMERA_HEIGHT+200);
//					MainActivity.mScene.detachChild(MainActivity.numberSprites[y]);
//					if(MainActivity.spriteCounter<15)
//					{
//						//MainActivity.spriteCounter++;
//						//Debug.d("MainActivity.spriteCounter:"+MainActivity.spriteCounter);
//						//Animation.scale(MainActivity.moOutLineX+120 , MainActivity.moOutLineY-70*MainActivity.spriteCounter+1000 );
//					}
//					
//				}
//			}
//		}
		
	}

}
