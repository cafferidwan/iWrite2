package Animation;

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

import com.example.iwrite.MainActivity;

public class Animation 
{
	public static void scale(float x, float y, int c)
	{
			
			if(c<=MainActivity.spriteCounterLimit)
			{
			//MainActivity.animationStart = 1;
			
			MainActivity.numberSprites[MainActivity.spriteCounter] = new Sprite(x, y, 
					MainActivity.mTextureRegionNumber[MainActivity.spriteCounter], MainActivity.vertexBufferObjectManager);
			MainActivity.numberSprites[MainActivity.spriteCounter].setScale((float)0.1);
			MainActivity.numberSprites[MainActivity.spriteCounter].setZIndex(0);
			MainActivity.mScene.attachChild(MainActivity.numberSprites[MainActivity.spriteCounter]);
			MainActivity.mScene.registerTouchArea(MainActivity.numberSprites[MainActivity.spriteCounter]);
		
			//sp.setVisible(true);
			ScaleModifier scaleModifier = new ScaleModifier((float) 0.1, 0.1f, 0.3f);
			LoopEntityModifier loopRotateMod = new LoopEntityModifier( new RotationModifier(4, 0, 360));
			DelayModifier delayMod = new DelayModifier((float) 0.01, new IEntityModifierListener()
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
								scale(MainActivity.moOutLineX+70*MainActivity.spriteCounter - 100, 
										MainActivity.moOutLineY -50, MainActivity.spriteCounter);
							}
							else if(MainActivity.spriteCounterLimit == 7)
							{
								MainActivity.spriteCounter++;
								scale(MainActivity.moOutLineX+30*MainActivity.spriteCounter - 150 ,
										MainActivity.moOutLineY+60*MainActivity.spriteCounter - 350,
										MainActivity.spriteCounter);
							}
							else if(MainActivity.spriteCounterLimit == 9)
							{
								MainActivity.spriteCounter++;
								scale(MainActivity.moOutLineX-50*MainActivity.spriteCounter +410 ,
										MainActivity.moOutLineY-30*MainActivity.spriteCounter + 340,
										MainActivity.spriteCounter);
							}
							else if(MainActivity.spriteCounterLimit == 13)
							{
								MainActivity.spriteCounter++;
								scale(MainActivity.moOutLineX+40*MainActivity.spriteCounter -385 ,
										MainActivity.moOutLineY+50*MainActivity.spriteCounter-480,
										MainActivity.spriteCounter);
							}
							else if(MainActivity.spriteCounterLimit == 16)
							{
								MainActivity.spriteCounter++;
								scale(MainActivity.moOutLineX+120 , 
										70+MainActivity.moOutLineY-70*MainActivity.spriteCounter+1000,
										MainActivity.spriteCounter);
							}
							
						}
					});
			
			SequenceEntityModifier sequenceMod = new SequenceEntityModifier(scaleModifier,delayMod, loopRotateMod);
			MainActivity.numberSprites[MainActivity.spriteCounter].registerEntityModifier(sequenceMod);
			}
			else
			{
				//MainActivity.animationStart = 0;
			}
	}

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
}
