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

public class Animation 
{
	
	public static int spriteCounter;
	
	public static void scale(float x, float y, int c)
	{
			spriteCounter = MainActivity.spriteCounter;
			
			if(c<=MainActivity.spriteCounterLimit)
			{
			
			MainActivity.numberSprites[spriteCounter] = new Sprite(x, y, 
					MainActivity.mTextureRegionNumber[spriteCounter], MainActivity.vertexBufferObjectManager);
			MainActivity.numberSprites[spriteCounter].setScale((float)0.1);
			MainActivity.mScene.attachChild(MainActivity.numberSprites[spriteCounter]);
			MainActivity.mScene.registerTouchArea(MainActivity.numberSprites[spriteCounter]);
		
			//sp.setVisible(true);
			ScaleModifier scaleModifier = new ScaleModifier(1, 0.1f, 0.3f);
			LoopEntityModifier loopRotateMod = new LoopEntityModifier( new RotationModifier(4, 0, 360));
			DelayModifier delayMod = new DelayModifier((float) 0.05 , new IEntityModifierListener()
			{ 

						@Override
						public void onModifierStarted(IModifier<IEntity> arg0,
								IEntity arg1) 
						{

						}

						@Override
						public void onModifierFinished(IModifier<IEntity> arg0,
								IEntity arg1)
						{
							if(MainActivity.spriteCounterLimit == 4)
							{
								MainActivity.spriteCounter++;
								MainActivity.a=0;
								scale(MainActivity.moOutLineX+70*MainActivity.spriteCounter - 100, 
										MainActivity.moOutLineY -50, MainActivity.spriteCounter);
							}
							else if(MainActivity.spriteCounterLimit == 7)
							{
								MainActivity.spriteCounter++;
								MainActivity.a=0;
								scale(MainActivity.moOutLineX+30*MainActivity.spriteCounter - 150 ,
										MainActivity.moOutLineY+60*MainActivity.spriteCounter - 350,
										MainActivity.spriteCounter);
							}
							else if(MainActivity.spriteCounterLimit == 9)
							{
								MainActivity.spriteCounter++;
								MainActivity.a=0;
								scale(MainActivity.moOutLineX-50*MainActivity.spriteCounter +410 ,
										MainActivity.moOutLineY-30*spriteCounter + 340,
										MainActivity.spriteCounter);
							}
							else if(MainActivity.spriteCounterLimit == 12)
							{
								MainActivity.spriteCounter++;
								MainActivity.a=0;
								scale(MainActivity.moOutLineX+40*MainActivity.spriteCounter -345 ,
										MainActivity.moOutLineY+50*MainActivity.spriteCounter-430,
										MainActivity.spriteCounter);
							}
						}
					});
			
			SequenceEntityModifier sequenceMod = new SequenceEntityModifier(scaleModifier,delayMod, loopRotateMod);
			MainActivity.numberSprites[spriteCounter].registerEntityModifier(sequenceMod);
			}
	}

	public static void shake(int a, final Sprite sp, float x)
	{
		if(a<5) 
		{
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
						MainActivity.j++;
						sp.setPosition(sp.getX()-20, sp.getY());
						shake(MainActivity.j,sp, 20);
					} 
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(moveMod, delayMod);
		sp.registerEntityModifier(sequenceMod);
		}
		if(a==5)
		{
			sp.setPosition(sp.getX()+10, sp.getY());
			MainActivity.j=0;
		}
	}
}
