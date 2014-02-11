package Animation;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.AnimatedSprite;
import com.example.iwrite.MainActivity;
import com.example.iwrite.NumberSprites;
import com.example.iwrite.R;
import com.example.iwrite.StructureDrawAnimation;

public class AnimationDrawTutorial 
{
	//animation for drawing with chalk during monkey tutorial
	public static void animatedChalk1(float x1, float y1, float x2, float y2)
	{
		Path chalkPath = null;
		
		chalkPath = new Path(2)
		.to(x1, y1).to(x2, y2);
		
		
		MainActivity.rectangle.registerEntityModifier(new PathModifier((float)2.5, chalkPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				MainActivity.monkeyTutorialStart = 1;
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{

			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{

			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				
				MainActivity.monkeyTutorialStart = 0;
				
				//move to the next step of drawing with chalk
				AnimationDrawTutorial.animatedChalk2(
						MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
						MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
						MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
						MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
						MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
						MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
						MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
						MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
						MainActivity.moOutLineX+150, MainActivity.moOutLineY
						);
			}
		}));
	}
	
	//animation for drawing with chalk during monkey tutorial
	public static void animatedChalk2(float x1, float y1, float x2, float y2, float x3, float y3
			, float x4, float y4, float x5, float y5, float x6, float y6, float x7, float y7
			, float x8, float y8, float x9, float y9)
	{
		Path chalkPath2 = new Path(9)
		.to(x1 , y1 ).to(x2, y2).to(x3, y3).to(x4, y4)
		.to(x5, y5).to(x6, y6).to(x7, y7).to(x8, y8).to(x9, y9)
		;
		
		MainActivity.rectangle.registerEntityModifier(new PathModifier((float)5.0, chalkPath2, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				MainActivity.monkeyTutorialStart = 1;
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{

			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{

			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{ 
				MainActivity.monkeyTutorialStart = 0;
				
				//after finishing the tutorial remove the chalk draw
				MainActivity.mScene.registerUpdateHandler(new TimerHandler((float) 1, new ITimerCallback() 
				{
							@Override
							public void onTimePassed(TimerHandler pTimerHandler)
							{
								// TODO Auto-generated method stub
								removeTutorialDraw(1);
							}
				}));
			}
		}));
	}
	
	
	// remove the chalk draw during monkey tutorial
	public static void removeTutorialDraw(int a)
	{
		for(int i = 0; i<= MainActivity.bCounter; i++)
		{
			MainActivity.mScene.detachChild(MainActivity.tutorialWhiteChalk[i]);
		}
		MainActivity.bCounter = 0;
		
		//first time call
		if(a==1)
		{
			//play sound
			MainActivity.audioPlay = true;
			NumberSprites.playAudio(R.raw.one);
			
			MainActivity.mScene.registerUpdateHandler(new TimerHandler((float) 3, new ITimerCallback() 
			{
						@Override
						public void onTimePassed(TimerHandler pTimerHandler)
						{
							// TODO Auto-generated method stub
							createNumberSpriteAndCursor(1,4);
						}
			}));
			//go to the second step
			//createNumberSpriteAndCursor(1);
		}
		//second time call
		else if(a==2)
		{
			createNumberSpriteAndCursor(2,4);
		}
	}
	
	//create numberSprite and cursor
	public static void createNumberSpriteAndCursor(int a, int spriteLimit)
	{
		
		//creating the first line of numbers
		MainActivity.spriteCounterLimit = spriteLimit;
		StructureDrawAnimation.scale(MainActivity.moOutLineX + 70 - 120, MainActivity.moOutLineY - 50, 1);
		
		//creating the fish cursor
		MainActivity.cursor = new AnimatedSprite(MainActivity.moOutLineX, MainActivity.moOutLineY, 
				MainActivity.mFishTextureRegion, MainActivity.vertexBufferObjectManager);
		MainActivity.cursor.animate(new long[]{100, 100, 100, 100, 100, 100}, 0, 5, true);
		MainActivity.cursor.setZIndex(3);
		MainActivity.mScene.attachChild(MainActivity.cursor);
		
		//setting the cursor to top of first number sprite
		NumberSprites.setCursorPosition(MainActivity.numberSprites[1]);
		
		if(a==1)
		{
			//go to the next step or move the animated fish 
			animatedCursor(MainActivity.moOutLineX-10, 
					MainActivity.moOutLineY-20, 
					MainActivity.moOutLineX+180, 
					MainActivity.moOutLineY-20);
		}
		else if(a==2)
		{
			
		}
	}
	
	//moving the cursor with animation
	public static void animatedCursor(float x1, float y1, float x2, float y2)
	{
		Path chalkPath = null;
		
		chalkPath = new Path(2)
		.to(x1, y1).to(x2, y2);
		
		
		MainActivity.cursor.registerEntityModifier(new PathModifier((float)2.0, chalkPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				MainActivity.monkeyTutorialStart = 2;
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{

			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{

			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//play sound
				MainActivity.audioPlay = true;
				NumberSprites.playAudio(R.raw.one);
				
				//after moving the cursor/fish with removing the number sprites
				MainActivity.mScene.registerUpdateHandler(new TimerHandler((float) 3, new ITimerCallback() 
				{
							@Override
							public void onTimePassed(TimerHandler pTimerHandler)
							{
								// TODO Auto-generated method stub
								MainActivity.monkeyTutorialStart = 0;
								MainActivity.mScene.detachChild(MainActivity.cursor);
								MainActivity.mScene.detachChild(MainActivity.numberSprites[4]);
								
								MainActivity.spriteCounter = 1;
								//remove the draw
								removeTutorialDraw(2);
							}
				}));
		
			}
		}));
	}
	
	//Timer for drawing during monkey Tutorial
	public static void animationDrawTimer()
	{
		
		MainActivity.timer1 = new TimerHandler((float) 1.0f/120,true, new ITimerCallback() 
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) 
			{
				// TODO Auto-generated method stub 
				
				//starting the first step with monkey tutorial
				if(MainActivity.monkeyTutorialStart == 1 )
				{
					//calling for drawing first line of monkey tutorial draw
					MonkeyTutorial.monkeyTutorialAnimationDraw(MainActivity.rectangle.getX()+20 ,
							MainActivity.rectangle.getY() +20);
				}
				//drawing the second time with removing number sprite
				else if(MainActivity.monkeyTutorialStart == 2 )
				{
					MonkeyTutorial.monkeyTutorialAnimationDraw(MainActivity.cursor.getX()+20 ,
							MainActivity.cursor.getY()+20);
				}
				
			}
		});
	}
}
