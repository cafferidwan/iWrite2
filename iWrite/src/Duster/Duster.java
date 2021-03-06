package Duster;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.debug.Debug;
import org.andengine.util.modifier.ease.EaseBounceOut;
import android.content.Intent;
import com.example.iwrite.MainActivity;

public class Duster
{

	//create duster
	public static void createDuster()
	{
		MainActivity.duster = new Sprite(MainActivity.CAMERA_WIDTH/2+100, -400, 
				MainActivity.mDusterTextureRegion, MainActivity.vertexBufferObjectManager)
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
			{
				switch (pSceneTouchEvent.getAction())
				{
				case TouchEvent.ACTION_DOWN:
					
					//if the pop up is active, then disabling the book icon from pressing again
					if(MainActivity.isPopupActive == false)
					{
						//when duster icon pressed start finish duster animation 
						MainActivity.dusterFinishCounter++;
					
						Debug.d("dustercounter:"+MainActivity.dusterCounter);
						if(MainActivity.dusterFinishCounter==1)
						{	
							finishDuster();
						}
					}
					
					break;

				case TouchEvent.ACTION_UP:

					break;

				}

				return true;
			}
		};
		MainActivity.duster.setScale((float) 0.5);
		MainActivity.mScene.registerTouchArea(MainActivity.duster);
		MainActivity.mScene.attachChild(MainActivity.duster);
		MainActivity.duster.setZIndex(4);
		
	}
	
	//start duster animation
	public static void startDuster()
	{
		Path createDusterPath = new Path(2).to(MainActivity.CAMERA_WIDTH/2+100, -300)
				.to(MainActivity.CAMERA_WIDTH/2+190,
				MainActivity.CAMERA_HEIGHT/2);

	
		MainActivity.duster.registerEntityModifier(new PathModifier((float) 1.3,
				createDusterPath, null, new IPathModifierListener() 
		{
					@Override
					public void onPathStarted(final PathModifier pPathModifier,
							final IEntity pEntity)
					{
						
					}

					@Override
					public void onPathWaypointStarted( final PathModifier pPathModifier,
							final IEntity pEntity, final int pWaypointIndex) 
					{

					}

					@Override
					public void onPathWaypointFinished( final PathModifier pPathModifier,
							final IEntity pEntity, final int pWaypointIndex) 
					{

					}

					@Override
					public void onPathFinished( final PathModifier pPathModifier,
							final IEntity pEntity) 
					{

					}
				}, EaseBounceOut.getInstance()));
	}
	
	//for deleting all the white chalks and fish cursor
	public static void delete()
	{
		for(int i=0; i<=MainActivity.aCounter; i++)
		{
			MainActivity.mScene.detachChild(MainActivity.whiteChalk[i]);
		}
//		MainActivity.aCounter = 0 ;
//		MainActivity.mScene.detachChild(MainActivity.cursor);

//		MainActivity.spriteCounter = 1;
//		AnimationDrawTutorial.createNumberSpriteAndCursor(2);
	}
	
	//Sliding monkey hand animation for restarting the application
	public static void finishDuster() 
	{

		MainActivity.slidingScreen = new Sprite(0, -800, MainActivity.mSlidingScreenTextureRegion, MainActivity.vertexBufferObjectManager);
		MainActivity.mScene.attachChild(MainActivity.slidingScreen);
			
		Path finishingPath = new Path(2).to(-1200, -150).to(MainActivity.CAMERA_WIDTH  + 10, -150);

		MainActivity.slidingScreen.registerEntityModifier(new PathModifier((float) 1.8, finishingPath, null, new IPathModifierListener()
		{
				@Override
				public void onPathStarted(final PathModifier pPathModifier,final IEntity pEntity) 
				{
					
					delete();
					MainActivity.mScene.clearEntityModifiers();
//					MainActivity.mScene.detachChildren();
					MainActivity.mScene.detachSelf();
					MainActivity.mScene.dispose();
					
					//Restarting the activity
					MainActivity.mScene.registerUpdateHandler(new TimerHandler((float)1, new ITimerCallback() 
					{
								
						@Override
						public void onTimePassed(TimerHandler pTimerHandler)
						{
							// TODO Auto-generated method stub
							
									
							//Resetting the stars
							MainActivity.aCounter=0;
							
							MainActivity.mScene.detachChild(MainActivity.handTutorial);
							MainActivity.mScene.unregisterUpdateHandler(MainActivity.timer1);
							MainActivity.MainActivityInstace.finish();
							MainActivity.MainActivityInstace.startActivity(new Intent(MainActivity.MainActivityInstace.getBaseContext(),
									MainActivity.class));
						}
					}));
				}
	 
						@Override
						public void onPathWaypointStarted(final PathModifier pPathModifier,final IEntity pEntity, final int pWaypointIndex) 
						{
							
						}

						@Override
						public void onPathWaypointFinished(final PathModifier pPathModifier,final IEntity pEntity, final int pWaypointIndex) 
						{

						}

						@Override
						public void onPathFinished(final PathModifier pPathModifier,final IEntity pEntity)
						{
							
						}
					}));
		}
}
