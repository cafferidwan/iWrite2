package Animation;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.debug.Debug;
import org.andengine.util.modifier.ease.EaseBounceOut;
import com.example.iwrite.MainActivity;
import com.example.iwrite.NumberSprites;
import com.example.iwrite.R;

public class MonkeyTutorial 
{

	//creating monkeyTutorial
	public static void monkeyTutorialCreate()
	{
		MainActivity.monkeyTutorial = new AnimatedSprite(100, -400, MainActivity.mMonkeyTextureRegion,
				MainActivity.vertexBufferObjectManager) 
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, 
					final float pTouchAreaLocalY) 
			{
				switch (pSceneTouchEvent.getAction())
				{
				case TouchEvent.ACTION_DOWN: 
				{

				}
					break;

				case TouchEvent.ACTION_UP:

					break;

				}

				return true;
			}
		};
		
		//animating the monkey tutorial
		MainActivity.monkeyTutorial.animate(new long[] { 1000, 1000, 1000, 100, 100, 4000,
				1000, 1000, 100, 100 }, 0, 9, true);
		MainActivity.mScene.registerTouchArea(MainActivity.monkeyTutorial);
		MainActivity.mScene.attachChild(MainActivity.monkeyTutorial);
		
	}

	
	//starting the monkey tutorial
	public static void monkeyTutorialstart(final float xA1, final float yA1, final float xA2, final float yA2,
			final float x1, final float y1, final float x2, final float y2,final float x3, final float y3,
			final float x4, final float y4, final float x5,final float y5, final float x6, final float y6,
			final float x7, final float y7, final float x8, final float y8, final float x9, final float y9)
	{

		Path createMonkeyPath = new Path(2).to(100, -600).to(0, 3);

		MainActivity.monkeyTutorial.registerEntityModifier(new PathModifier(
				(float) 4.3, createMonkeyPath, null, new IPathModifierListener() 
				{
					@Override
					public void onPathStarted(final PathModifier pPathModifier,
							final IEntity pEntity)
					{
						// play sound
						MainActivity.audioPlay = true;
						NumberSprites.playAudio(R.raw.one);
					}

					@Override
					public void onPathWaypointStarted(final PathModifier pPathModifier,
							final IEntity pEntity, final int pWaypointIndex) 
					{

					}

					@Override
					public void onPathWaypointFinished(final PathModifier pPathModifier,
							final IEntity pEntity, final int pWaypointIndex) 
					{

					}

					@Override
					public void onPathFinished(final PathModifier pPathModifier,
							final IEntity pEntity) 
					{
						// adding some delay
						MainActivity.mScene.registerUpdateHandler(new TimerHandler(
										(float) 3.0, new ITimerCallback() 
										{
											@Override
											public void onTimePassed(TimerHandler pTimerHandler) 
											{
												// TODO Auto-generated method stub

												// draw the animation tutorial
												AnimationDrawTutorial.animatedChalk1(
														xA1, yA1, xA2, yA2,
														x1, y1, x2, y2, x3, y3, x4, y4,
														x5, y5, x6, y6, x7, y7, x8, y8,
														x9, y9);
											}
										}));

					}
				}, EaseBounceOut.getInstance()));
	}

	
	// monkey tutorial animation draw
	public static void monkeyTutorialAnimationDraw(float x, float y)
	{
		MainActivity.bCounter++;
		MainActivity.tutorialWhiteChalk[MainActivity.bCounter] = new Sprite(x,
				y, MainActivity.mWhiteChalkTextureRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.tutorialWhiteChalk[MainActivity.bCounter].setZIndex(2);
		MainActivity.mScene
				.attachChild(MainActivity.tutorialWhiteChalk[MainActivity.bCounter]);
		MainActivity.tutorialWhiteChalk[MainActivity.bCounter]
				.setScale((float) 0.6);
		MainActivity.mScene.sortChildren();
		Debug.d("bCounter:" + MainActivity.bCounter);

		// removing number sprite during the tutorial
		for (int a = 1; a < 4; a++)
		{
			if (MainActivity.numberSprites[a] != null)
			{
				if (MainActivity.tutorialWhiteChalk[MainActivity.bCounter].getX() > 
				MainActivity.numberSprites[a].getX() + 60)
				{
					MainActivity.mScene
							.detachChild(MainActivity.numberSprites[a]);
				}
			}
		}
		
		
	}
	
	
}
