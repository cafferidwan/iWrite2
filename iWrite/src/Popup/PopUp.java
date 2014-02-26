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
	public static IEntity popUpArea;
	public static int popValue = 0;

	//create book icon
	public static void createBookIcon() 
	{
		//creating pop up after book icon
		createPopUp();
				
		// create book icon
		MainActivity.bookIcon = new Sprite(0, MainActivity.CAMERA_HEIGHT - 200, 
				MainActivity.mBookIconRegion, MainActivity.vertexBufferObjectManager) 
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, 
					final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
				case TouchEvent.ACTION_DOWN:

					popValue = 1;
					
					//if the pop up is active, then disabling the book icon from pressing again
					if(MainActivity.isPopupActive == false)
					{
						startPopUp(0);
					}

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
		MainActivity.mScene.sortChildren();
		
	}
	
	//creating the pop up
	public static void createPopUp()
	{
		
		//creating pop up area
		popUpArea = new Entity(100, MainActivity.CAMERA_HEIGHT + 100);
		MainActivity.mScene.attachChild(popUpArea);
		popUpArea.setZIndex(5);
		
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
		//Mo
		if(MainActivity.letter == 1)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mMoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Aa
		else if(MainActivity.letter == 2)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mAaFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//E
		else if(MainActivity.letter == 3)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mEFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Raw
		else if(MainActivity.letter == 4)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mRawFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Ko
		else if(MainActivity.letter == 5)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mKoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Bo
		else if(MainActivity.letter == 6)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mBoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Talibasha
		else if(MainActivity.letter == 7)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mTalibashaFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Lo
		else if(MainActivity.letter == 8)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mLoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Po
		else if(MainActivity.letter == 9)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mPoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Go
		else if(MainActivity.letter == 10)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mGoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Ho
		else if(MainActivity.letter == 11)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mHoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Kho
		else if(MainActivity.letter == 12)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mKhoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Kho
		else if(MainActivity.letter == 13)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mChoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//No
		else if(MainActivity.letter == 14)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mNoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//A
		else if(MainActivity.letter == 15)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mAFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Do
		else if(MainActivity.letter == 16)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mDoFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//U
		else if(MainActivity.letter == 17)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mUFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//To
		else if(MainActivity.letter == 18)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mToFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Toh
		else if(MainActivity.letter == 19)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mTohFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Doh
		else if(MainActivity.letter == 20)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mDohFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Ukar
		else if(MainActivity.letter == 21)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mUkarFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Ekar
		else if(MainActivity.letter == 22)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mEkarFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
		//Akar
		else if(MainActivity.letter == 23)
		{
			MainActivity.correctLetter = new Sprite(270, -130, MainActivity.mAkarFilledTextureRegion,
					MainActivity.vertexBufferObjectManager);
		}
			
		
		MainActivity.correctLetter.setScale((float) 0.4);
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

					//when the handtutorial is inactive, then it works
					if(MainActivity.isHandTutorialActive == false)
					{
						popValue = 2;
					
						startPopUp(1);
					}

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

	//pop up function for up and down
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
			MainActivity.drawnPicture = new Sprite(-40, -60, MainActivity.textureRegion,
					MainActivity.vertexBufferObjectManager);
			MainActivity.drawnPicture.setScale((float) 0.6);
			popUpArea.attachChild(MainActivity.drawnPicture);
		}

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
