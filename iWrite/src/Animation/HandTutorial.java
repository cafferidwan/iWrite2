package Animation;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.AlphaModifier;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.modifier.IModifier;

import Duster.Duster;
import Popup.PopUp;

import com.example.iwrite.MainActivity;

public class HandTutorial
{
	public static LoopEntityModifier loopMod, loopMod1;

	public static void handTutorialCreate()
	{
		MainActivity.handTutorial = new Sprite(400, MainActivity.CAMERA_HEIGHT, MainActivity.mHandTutorialTextureRegion, 
				MainActivity.vertexBufferObjectManager);
		MainActivity.mScene.attachChild(MainActivity.handTutorial);
		MainActivity.handTutorial.setZIndex(6);
		MainActivity.handTutorial.setAlpha(0);
		
		AlphaModifier alphaMod = new AlphaModifier((float) 0.8, (float) 0, 1);
		DelayModifier delayMod = new DelayModifier((float) 0.00, new IEntityModifierListener()
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
						handTutorialStart(MainActivity.handTutorial.getX(), 
								MainActivity.handTutorial.getY(),
								MainActivity.bookIcon.getX()+70, 
								MainActivity.bookIcon.getY()+70);
					}
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(alphaMod ,delayMod);
		MainActivity.handTutorial.registerEntityModifier(sequenceMod);
	}
	
	public static void handTutorialStart(float x1, float y1, float x2, float y2)
	{
		MoveModifier moveMod = new MoveModifier(2, x1, x2, y1, y2);
		DelayModifier delayMod = new DelayModifier((float) 2, new IEntityModifierListener()
		{  

					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) 
					{
						MainActivity.isHandTutorialActive = true;
						MainActivity.mScene.sortChildren();
						
						if(PopUp.popValue == 1)
						{
							MainActivity.handTutorial.unregisterEntityModifier(loopMod);
							
							HandTutorial.handTutorialStart2(MainActivity.handTutorial.getX(), 
									MainActivity.handTutorial.getY(), 150, 150);
						}
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						
					}
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(delayMod,moveMod);
		loopMod = new LoopEntityModifier(sequenceMod);
		
		MainActivity.handTutorial.registerEntityModifier(loopMod);
	}
	
	public static void handTutorialStart2(float x1, float y1, float x2, float y2)
	{
		MoveModifier moveMod = new MoveModifier(1, x1, x2, y1, y2);
		DelayModifier delayMod = new DelayModifier((float) 2, new IEntityModifierListener()
		{  

					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) 
					{
						//MainActivity.isHandTutorialActive = true;
						MainActivity.mScene.sortChildren();
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						//MainActivity.isHandTutorialActive = false;

						MainActivity.mScene.registerUpdateHandler(new TimerHandler(5, new ITimerCallback()
						{
							@Override
							public void onTimePassed(TimerHandler pTimerHandler)
							{
								// TODO Auto-generated method stub
								 handTutorialStart3(MainActivity.handTutorial.getX(),
										 MainActivity.handTutorial.getY(),
										 550, 150);
							}
						}));
					}
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(delayMod,moveMod);
		//LoopEntityModifier loopMod = new LoopEntityModifier(sequenceMod);
		
		MainActivity.handTutorial.registerEntityModifier(sequenceMod);
		
	}
	 
	
	public static void handTutorialStart3(float x1, float y1, float x2, float y2)
	{
		MoveModifier moveMod = new MoveModifier(1, x1, x2, y1, y2);
		DelayModifier delayMod = new DelayModifier((float) 2, new IEntityModifierListener()
		{  

					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) 
					{
						//MainActivity.isHandTutorialActive = true;
						MainActivity.mScene.sortChildren();
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						//MainActivity.isHandTutorialActive = false;

						MainActivity.mScene.registerUpdateHandler(new TimerHandler(5, new ITimerCallback()
						{
							@Override
							public void onTimePassed(TimerHandler pTimerHandler)
							{
								// TODO Auto-generated method stub
								 handTutorialStart4(MainActivity.handTutorial.getX(),
										 MainActivity.handTutorial.getY(),
										 700, 50);
							}
						}));
					}
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(delayMod,moveMod);
		//LoopEntityModifier loopMod = new LoopEntityModifier(sequenceMod);
		
		MainActivity.handTutorial.registerEntityModifier(sequenceMod);
		
	}
	
	
	public static void handTutorialStart4(float x1, float y1, float x2, float y2)
	{
		MoveModifier moveMod = new MoveModifier(2, x1, x2, y1, y2);
		DelayModifier delayMod = new DelayModifier((float) 2, new IEntityModifierListener()
		{  
					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) 
					{
						//MainActivity.isHandTutorialActive = true;
						MainActivity.mScene.sortChildren();
						
						if(PopUp.popValue == 2)
						{
							//removing the tutorial
							handTutorialStart5(MainActivity.handTutorial.getX(),
									 MainActivity.handTutorial.getY(),
									 600, 250);
						}
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						MainActivity.isHandTutorialActive = false;
						
					}
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(delayMod,moveMod);
		loopMod1 = new LoopEntityModifier(sequenceMod);
		
		MainActivity.handTutorial.registerEntityModifier(loopMod1);
		
	}
	
	public static void handTutorialStart5(float x1, float y1, float x2, float y2)
	{
		MoveModifier moveMod = new MoveModifier(2, x1, x2, y1, y2);
		DelayModifier delayMod = new DelayModifier((float) 2, new IEntityModifierListener()
		{  
					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) 
					{
						//MainActivity.isHandTutorialActive = true;
						MainActivity.mScene.sortChildren();
						
						//Start the duster
						Duster.startDuster();
						
//						if(PopUp.popValue == 2)
//						{
//							//removing the tutorial
//							MainActivity.handTutorial.unregisterEntityModifier(HandTutorial.loopMod1);
//							MainActivity.mScene.detachChild(MainActivity.handTutorial);
//							MainActivity.handTutorial.setY(2000);  
//						}
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						MainActivity.isHandTutorialActive = false;
						
					}
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(delayMod,moveMod);
		loopMod1 = new LoopEntityModifier(sequenceMod);
		
		MainActivity.handTutorial.registerEntityModifier(loopMod1);
		
	}
	
}
