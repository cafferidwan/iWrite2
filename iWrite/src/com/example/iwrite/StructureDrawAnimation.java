package com.example.iwrite;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.RotationModifier;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.modifier.IModifier;
import Letters.LetterStructureAa;
import Letters.LetterStructureBo;
import Letters.LetterStructureE;
import Letters.LetterStructureGo;
import Letters.LetterStructureHo;
import Letters.LetterStructureKo;
import Letters.LetterStructureLo;
import Letters.LetterStructureMo;
import Letters.LetterStructurePo;
import Letters.LetterStructureRaw;
import Letters.LetterStructureTalibaSha;

import com.example.iwrite.MainActivity;

public class StructureDrawAnimation 
{
	//scale animation for number sprite and setting the structure of the letter
	public static void scale(float x, float y, int c)
	{
			
			if(c<=MainActivity.spriteCounterLimit)
			{
			
				MainActivity.numberSprites[MainActivity.spriteCounter] = new Sprite(x, y, 
						MainActivity.mTextureRegionNumber[MainActivity.spriteCounter], MainActivity.vertexBufferObjectManager);
				
				MainActivity.numberSprites[MainActivity.spriteCounter].setScale((float)0.1);
				MainActivity.numberSprites[MainActivity.spriteCounter].setZIndex(0);
				MainActivity.mScene.attachChild(MainActivity.numberSprites[MainActivity.spriteCounter]);
				MainActivity.mScene.registerTouchArea(MainActivity.numberSprites[MainActivity.spriteCounter]);
		
				ScaleModifier scaleModifier = new ScaleModifier((float) 0.1, 0.1f, 0.3f);
				LoopEntityModifier loopRotateMod = new LoopEntityModifier( new RotationModifier(4, 0, 360));
				DelayModifier delayMod = new DelayModifier((float) 0.01, new IEntityModifierListener()
				{ 

						@Override
						public void onModifierStarted(IModifier<IEntity> arg0,
								IEntity arg1)
						{
							MainActivity.isActionMoving =false;
						}

						@Override
						public void onModifierFinished(IModifier<IEntity> arg0,
								IEntity arg1)
						{
							MainActivity.isActionMoving = true;
							//For letter Mo
							if(MainActivity.letter == 1)
							{
								LetterStructureMo.Structure();
							}
							//For letter Aa
							else if(MainActivity.letter == 2)
							{
								LetterStructureAa.Structure();
							}
							//For letter E
							else if(MainActivity.letter == 3)
							{
								LetterStructureE.Structure();
							}
							//For letter Raw
							else if(MainActivity.letter == 4)
							{
								LetterStructureRaw.Structure();
							}
							//For letter Ko
							else if(MainActivity.letter == 5)
							{
								LetterStructureKo.Structure();
							}
							//For letter Bo
							else if(MainActivity.letter == 6)
							{
								LetterStructureBo.Structure();
							}
							//For letter TalibaSha
							else if(MainActivity.letter == 7)
							{
								LetterStructureTalibaSha.Structure();
							}
							//For letter Lo
							else if(MainActivity.letter == 8)
							{
								LetterStructureLo.Structure();
							}
							//For letter Po
							else if(MainActivity.letter == 9)
							{
								LetterStructurePo.Structure();
							}
							//For letter Go
							else if(MainActivity.letter == 10)
							{
								LetterStructureGo.Structure();
							}
							//For letter Ho
							else if(MainActivity.letter == 11)
							{
								LetterStructureHo.Structure();
							}
							
						}
					});
			
				SequenceEntityModifier sequenceMod = new SequenceEntityModifier(scaleModifier,delayMod, loopRotateMod);
				MainActivity.numberSprites[MainActivity.spriteCounter].registerEntityModifier(sequenceMod);
			}
			else
			{

			}
	}

	
	//shake animation
	public static void shake(int a, final Sprite sp, float x)
	{
		if(a<5) 
		{
		
		MainActivity.isShaking = true;
		MoveModifier moveMod = new MoveModifier((float)0.08, sp.getX(), sp.getX()+x, sp.getY(), sp.getY());
		DelayModifier delayMod = new DelayModifier((float) 0.01 , new IEntityModifierListener()
		{

					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) 
					{
						//sp.setVisible(true);
						
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						MainActivity.shakeCounter++;
						sp.setPosition(sp.getX()-20, sp.getY());
						shake(MainActivity.shakeCounter,sp, 20);
					} 
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(moveMod, delayMod);
		sp.registerEntityModifier(sequenceMod);
		}
		else if(a==5)
		{
			sp.setPosition(sp.getX()+10, sp.getY());
			MainActivity.shakeCounter=0;
			MainActivity.isShaking = false;
		}
	}
	
	//Drawing with touch when in the right range
	public static void Draw(float x, float y)
	{
		MainActivity.aCounter++;
		MainActivity.whiteChalk[MainActivity.aCounter] = new Sprite(x -25, y-30, 
				MainActivity.mWhiteChalkTextureRegion, MainActivity.vertexBufferObjectManager);
//		MainActivity.whiteChalk[MainActivity.aCounter].setZIndex(1);
		MainActivity.mScene.attachChild(MainActivity.whiteChalk[MainActivity.aCounter]);
		MainActivity.whiteChalk[MainActivity.aCounter].setScale((float) 0.6);
		//MainActivity.mScene.sortChildren();
		//Debug.d("I:"+MainActivity.aCounter); 
	}
}
