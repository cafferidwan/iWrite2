package Popup;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.modifier.ease.EaseBounceOut;

import com.example.iwrite.MainActivity;

public class PopUp
{
	static IEntity popUpArea;

	public static void createBookIcon() 
	{
		// create book icon
		MainActivity.bookIcon = new Sprite(30, MainActivity.CAMERA_HEIGHT - 200, 
				MainActivity.mBookIconRegion,
				MainActivity.vertexBufferObjectManager) 
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, 
					final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
				case TouchEvent.ACTION_DOWN:

					startPopUp(0);

					break;

				case TouchEvent.ACTION_UP:

					break;

				}

				return true;
			}
		};
		MainActivity.mScene.registerTouchArea(MainActivity.bookIcon);
		MainActivity.bookIcon.setScale((float) 0.6);
		MainActivity.mScene.attachChild(MainActivity.bookIcon);
		
		//creating pop up after book icon
		createPopUp();
		
	}
	
	public static void createPopUp()
	{
		
		//creating pop up area
		popUpArea = new Entity(100, MainActivity.CAMERA_HEIGHT + 100);
		MainActivity.mScene.attachChild(popUpArea);
		popUpArea.setZIndex(4);
		
		//creating pop up window
		MainActivity.createPopUp = new Sprite(-500, -300, MainActivity.mCreatePopUpRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.createPopUp.setScale((float) 0.5);
		popUpArea.attachChild(MainActivity.createPopUp);

		//creating board
		MainActivity.board = new Sprite(180, -200, MainActivity.mPopUpBlackBoardTextureRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.board.setScale((float) 0.6);
		popUpArea.attachChild(MainActivity.board);

		//creating correct letter
		MainActivity.correctLetter = new Sprite(340, -70, MainActivity.mMoOutLineTextureRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.correctLetter.setScale((float) 0.6);
		popUpArea.attachChild(MainActivity.correctLetter);
		
		//creating another board
		MainActivity.board = new Sprite(-180, -200, MainActivity.mPopUpBlackBoardTextureRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.board.setScale((float) 0.6);
		popUpArea.attachChild(MainActivity.board);

		
		//closing the pop up window by pressing cross button
		MainActivity.cross = new Sprite(530, -150, MainActivity.mCrossRegion,
				MainActivity.vertexBufferObjectManager) 
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
			{
				switch (pSceneTouchEvent.getAction())
				{
				case TouchEvent.ACTION_DOWN:

					startPopUp(1);

					break;

				case TouchEvent.ACTION_UP:

					break;

				}

				return true;
			}
		};
		MainActivity.mScene.registerTouchArea(MainActivity.cross);
		MainActivity.cross.setScale((float) 0.3);
		popUpArea.attachChild(MainActivity.cross);
	}

	public static void startPopUp(final int upDown) 
	{

		MainActivity.popUpValue = upDown;
		Path createPopUpPath = null;

		// Down to up or opening pop up
		if (upDown == 0) 
		{
			MainActivity.isPopupActive = true;

			createPopUpPath = new Path(2).to(100,
					MainActivity.CAMERA_HEIGHT + 500).to(100, 100);
		}
		// Up to down or closing pop up
		else if (upDown == 1) 
		{
			createPopUpPath = new Path(2).to(100, 100).to(100,
					MainActivity.CAMERA_HEIGHT + 500);
		}


		// If screen shot taken, then show screen shot image
		if (MainActivity.changeTexture == 1) 
		{
			MainActivity.drawnPicture = new Sprite(-40, -68, MainActivity.textureRegion,
					MainActivity.vertexBufferObjectManager);
			MainActivity.drawnPicture.setScale((float) 0.6);
			popUpArea.attachChild(MainActivity.drawnPicture);
		}
		// If no screen shot taken, then show normal image
//		else if (MainActivity.changeTexture == 0)
//		{
//			MainActivity.board = new Sprite(-180, -200, MainActivity.mPopUpBlackBoardTextureRegion,
//					MainActivity.vertexBufferObjectManager);
//			MainActivity.board.setScale((float) 0.6);
//			popUpArea.attachChild(MainActivity.board);
//		}

		popUpArea.registerEntityModifier(new PathModifier((float) 1.3,
				createPopUpPath, null, new IPathModifierListener() 
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
						if(upDown == 1)
						{
							MainActivity.isPopupActive = false;
						}
					}
				}, EaseBounceOut.getInstance()));
	}
}
