package Animation;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.AnimatedSprite;

import Letters.LetterStructureAa;
import Letters.LetterStructureBo;
import Letters.LetterStructureE;
import Letters.LetterStructureKo;
import Letters.LetterStructureLo;
import Letters.LetterStructureMo;
import Letters.LetterStructurePo;
import Letters.LetterStructureRaw;
import Letters.LetterStructureTalibaSha;

import com.example.iwrite.MainActivity;
import com.example.iwrite.NumberSprites;
import com.example.iwrite.R;
import com.example.iwrite.StructureDrawAnimation;

public class AnimationDrawTutorial 
{
	//animation for drawing with chalk during monkey tutorial
	public static void animatedChalk1(float xA1, float yA1, float xA2, float yA2, 
			final float x1, final float y1, final float x2, final float y2,final float x3, final float y3,
			final float x4, final float y4, final float x5,final float y5, final float x6, final float y6,
			final float x7, final float y7, final float x8, final float y8, final float x9, final float y9)
	{
		Path chalkPath = null;
		
		chalkPath = new Path(2)
		.to(xA1, yA1).to(xA2, yA2);
		
		
		MainActivity.rectangle.registerEntityModifier(new PathModifier((float)2.5, chalkPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				MainActivity.monkeyTutorialStart = 1;
				
				//disabling the touch
				MainActivity.isActionMoving = false;
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
					x1, y1, x2, y2, x3, y3, x4, y4,
					x5, y5, x6, y6, x7, y7, x8, y8,
					x9, y9);
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
							
							//start first line animation cursor tutorial
							createNumberSpriteAndCursor(1);
						}
			}));
		}
		//second time call
		else if(a==2) 
		{
			//createNumberSpriteAndCursor(2);
			MainActivity.isActionMoving = true;
			
			if(MainActivity.letter == 1)
			{
				//create number with cursor
				LetterStructureMo.createNumberSpriteAndCursor();
			}
			else if(MainActivity.letter == 2)
			{
				//create number with cursor
				LetterStructureAa.createNumberSpriteAndCursor();
			}
			else if(MainActivity.letter == 3)
			{
				//create number with cursor
				LetterStructureE.createNumberSpriteAndCursor();
			}
			else if(MainActivity.letter == 4)
			{
				//create number with cursor
				LetterStructureRaw.createNumberSpriteAndCursor();
			}
			else if(MainActivity.letter == 5)
			{
				//create number with cursor
				LetterStructureKo.createNumberSpriteAndCursor();
			}
			else if(MainActivity.letter == 6)
			{
				//create number with cursor
				LetterStructureBo.createNumberSpriteAndCursor();
			}
			else if(MainActivity.letter == 7)
			{
				//create number with cursor
				LetterStructureTalibaSha.createNumberSpriteAndCursor();
			}
			else if(MainActivity.letter == 8)
			{
				//create number with cursor
				LetterStructureLo.createNumberSpriteAndCursor();
			}
			else if(MainActivity.letter == 9)
			{
				//create number with cursor
				LetterStructurePo.createNumberSpriteAndCursor();
			}
		}
	}
	
	//create numberSprite and cursor
	public static void createNumberSpriteAndCursor(int a)
	{
		 
		//creating the first line of numbers
		MainActivity.spriteCounterLimit = 4;
		StructureDrawAnimation.scale(MainActivity.moOutLineX + 70 - 100, MainActivity.moOutLineY - 50, 1);
				
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
