package com.example.iwrite;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.ScreenCapture;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import Animation.HandTutorial;
import Animation.MonkeyTutorial;
import Duster.Duster;
import Popup.PopUp;
import ScreenShoot.BitmapTextureAtlasSource;
import ScreenShoot.ScreenShot;
import android.media.MediaPlayer;
import android.view.Display;

public class MainActivity extends SimpleBaseGameActivity implements IOnSceneTouchListener 
	{

	public static int CAMERA_WIDTH, CAMERA_HEIGHT;
	public Camera mCamera;
	public static Scene mScene;
	public static VertexBufferObjectManager vertexBufferObjectManager;
	public static MainActivity MainActivityInstace;

	public static BitmapTextureAtlas mBitmapTextureAtlasBlackBoard,
			mBitmapTextureAtlasMoOutLine, mBitmapTextureAtlasBackGround,
			mBitmapTextureAtlasWhiteChalk, mBitmapTextureAtlasStar,
			mBitmapTextureAtlasCursor;

	public static ITextureRegion mbackGroundTextureRegion,
			mBlackBoardTextureRegion, mMoOutLineTextureRegion,
			mWhiteChalkTextureRegion, mStarTextureRegion,
			mCursorTextureRegion;
	
	public static ITextureRegion mPopUpBlackBoardTextureRegion,
			mBookIconRegion, mCreatePopUpRegion,
			mCorrectLetterRegion, mHandTutorialTextureRegion,
			mCrossRegion, mDusterTextureRegion,
			mSlidingScreenTextureRegion, mMoExampleTextureRegion;
	
	private BuildableBitmapTextureAtlas mAnimatedBitmapTextureAtlas,
							mAnimatedMonkeyBitmapTextureAtlas;
	public static TiledTextureRegion mFishTextureRegion,
							mMonkeyTextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasPieceChalk,
	 mBitmapTextureAtlasBookIcon, mBitmapTextureAtlasHandWirtingBook,
	 mBitmapTextureAtlasBoard, mBitmapTextureAtlasHandCross, 
	 mBitmapTextureAtlasDuster, mBitmapTextureAtlasMonkeyBrush,
	 mBitmapTextureAtlasHandTutorial, mBitmapTextureAtlasMoExample;

	public static BitmapTextureAtlas[] mBitmapTextureAtlasNumber = new BitmapTextureAtlas[25];
	public static ITextureRegion[] mTextureRegionNumber = new ITextureRegion[25];
	public static Sprite[] numberSprites = new Sprite[25];
	public static Sprite[] whiteChalk = new Sprite[5000];
	public static Sprite[] tutorialWhiteChalk = new Sprite[5000];
	
	public static Sprite backGround, blackBoard, moOutLine;
	public static Sprite bookIcon, handTutorial, duster, slidingScreen;
	public static Sprite createPopUp, correctLetter, drawnPicture, cross, board;
	public static AnimatedSprite cursor;
	public static MonkeyTutorial monkeyTutorial;
	public static Rectangle rectangle;
	public static float moOutLineX, moOutLineY;

	public static int iCounter, jCounter, shakeCounter = 0, sCounter, wCounter;
	public static String DEBUG_TAG = MainActivity.class.getSimpleName();
	public static int aCounter = 0, bCounter, serialCounter = 1, totalLoadNumberPic = 18,
			totalNumberSprite;
	public static int monkeyTutorialStart;
	public static int spriteCounter;
	public static int spriteCounterLimit;
	public static int  state = 0;
	public static Rectangle rect;
	public static float posX;
	public static float posY;
	public static boolean isShaking, isPopupActive,
						  isHandTutorialActive;
	public static int touch, popUpValue, tutorialCounter;
	public static int soundCounter;
	public static Boolean audioPlay = false;
	static MediaPlayer mediaPlayer = new MediaPlayer();
	public static TimerHandler timer1;
	
	//Screen Shot texture
	public static ScreenCapture screenCapture;
	public static TextureRegion textureRegion;
	public static BitmapTextureAtlas texture;
	public static BitmapTextureAtlasSource source;
	public static int changeTexture = 0;
	public static boolean screenShot = false;
	public static int viewWidth, viewHeight;
	
	@Override
	public EngineOptions onCreateEngineOptions()
	{
		// TODO Auto-generated method stub
		MainActivityInstace = this;
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HEIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();

		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	}

	@Override
	protected void onCreateResources() 
	{
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("iWriteGFX/");

		mBitmapTextureAtlasBackGround = new BitmapTextureAtlas(
				this.getTextureManager(), 1600, 864, TextureOptions.BILINEAR);

		mBitmapTextureAtlasBlackBoard = new BitmapTextureAtlas(
				this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);

		mBitmapTextureAtlasMoOutLine = new BitmapTextureAtlas(
				this.getTextureManager(), 254, 262, TextureOptions.BILINEAR);

		mBitmapTextureAtlasWhiteChalk = new BitmapTextureAtlas(
				this.getTextureManager(), 50, 50, TextureOptions.BILINEAR);

		mBitmapTextureAtlasStar = new BitmapTextureAtlas(
				this.getTextureManager(), 50, 50, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasMoExample = new BitmapTextureAtlas(
				this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		//popup
		mBitmapTextureAtlasBookIcon = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasHandWirtingBook = new BitmapTextureAtlas(this.getTextureManager(), 1600, 800, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasBoard = new BitmapTextureAtlas(this.getTextureManager(), 600, 600, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasHandCross = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasDuster = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasMonkeyBrush = new BitmapTextureAtlas(this.getTextureManager(), 1300, 600, TextureOptions.BILINEAR);

		mBitmapTextureAtlasHandTutorial = new BitmapTextureAtlas(this.getTextureManager(), 100, 100, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasDuster = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasMonkeyBrush = new BitmapTextureAtlas(this.getTextureManager(), 1300, 600, TextureOptions.BILINEAR);
		
		//popup
		mBookIconRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBookIcon, this,
				"bookIcon.png", 0, 0,  1, 1);
				
		mCreatePopUpRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHandWirtingBook, this,
				"handwritingbook.png", 0, 0,  1, 1);
				
		mCrossRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHandCross, this,
				"cross.png", 0, 0,  1, 1);
		
		mDusterTextureRegion =  BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasDuster, this,
				"duster.png", 0, 0,  1, 1);
				
		mHandTutorialTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHandTutorial, this,
				"hand.png", 0, 0,  1, 1);
		
		mPopUpBlackBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBoard, this,
				"board.png", 0, 0,  1, 1); 
		
		mDusterTextureRegion =  BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasDuster, this,
				"duster.png", 0, 0,  1, 1);
		
		mSlidingScreenTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMonkeyBrush, this,
				"monkeyBrush3.png", 0, 0,  1, 1);

		mMoExampleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMoExample, this,
				"moExample.png", 0, 0,  1, 1);
		
		// All the numbers
		for (int i = 1; i <= totalLoadNumberPic; i++) 
		{
			mBitmapTextureAtlasNumber[i] = new BitmapTextureAtlas(
					this.getTextureManager(), 150, 150, TextureOptions.BILINEAR);
		}

		mbackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasBackGround, this,
						"JungleBG.png", 0, 0, 1, 1);

		mBlackBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasBlackBoard, this,
						"blackboard.png", 0, 0, 1, 1);

		mMoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasMoOutLine, this,
						"moOutlineCrop.png", 0, 0, 1, 1);

		mWhiteChalkTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasWhiteChalk, this,
						"chalk2.png", 0, 0, 1, 1);

		mStarTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasStar, this,
						"star.png", 0, 0, 1, 1);

		// All the numbers
		for (int i = 1; i <= 4; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + i + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 5; i <= 7; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-4) + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 8; i <= 9; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-7) + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 10; i <= 13; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-9) + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 14; i <= 16; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-13) + ".png", 0, 0, 1, 1);
		}

		mBitmapTextureAtlasBackGround.load();
		mBitmapTextureAtlasBlackBoard.load();
		mBitmapTextureAtlasMoOutLine.load();
		mBitmapTextureAtlasWhiteChalk.load();
		mBitmapTextureAtlasStar.load();
		mBitmapTextureAtlasWhiteChalk.load();
		
		mBitmapTextureAtlasBookIcon.load();
		mBitmapTextureAtlasHandWirtingBook.load();
		mBitmapTextureAtlasBoard.load();
		mBitmapTextureAtlasHandCross.load();
		mBitmapTextureAtlasDuster.load();
		mBitmapTextureAtlasMonkeyBrush.load();
		mBitmapTextureAtlasHandTutorial.load();
		mBitmapTextureAtlasMoExample.load();

		// All the numbers
		for (int i = 1; i <= totalLoadNumberPic; i++) 
		{
			mBitmapTextureAtlasNumber[i].load();
		}

		mAnimatedBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 614, 104, TextureOptions.NEAREST);
		mFishTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedBitmapTextureAtlas, this, "fish.png", 6, 1);
		
		try 
		{
			this.mAnimatedBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
		mAnimatedMonkeyBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 2000, 267, TextureOptions.NEAREST);
		mMonkeyTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedMonkeyBitmapTextureAtlas, this, "monkeyTutorial.png", 10, 1);
		
		try 
		{
			this.mAnimatedMonkeyBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedMonkeyBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
	}

	@Override
	protected Scene onCreateScene()
	{
		// TODO Auto-generated method stub
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));

		mScene.setOnSceneTouchListener(this);
		vertexBufferObjectManager = getVertexBufferObjectManager();
		
		serialCounter = 1;
		totalNumberSprite = 4;
		sCounter = 0;
		wCounter = 0;
		monkeyTutorialStart = 0;
		state = 0;
		spriteCounter = 1;
		spriteCounterLimit = 0;
		posX = 0;
		posY = 0;
		isShaking = false;
		isPopupActive  = false;
		isHandTutorialActive = false;
		touch = 0;
		soundCounter=0;
		bCounter = 0;
		changeTexture = 0;
		jCounter = 0;
		tutorialCounter = 0;

		//getting the renderView width and height for taking the screen shot
		viewWidth = MainActivity.MainActivityInstace.mRenderSurfaceView.getWidth() - 525;
		viewHeight = MainActivity.MainActivityInstace.mRenderSurfaceView.getHeight() - 165;
		
		backGround = new Sprite(0, 0, mbackGroundTextureRegion,
				getVertexBufferObjectManager());
		backGround.setHeight(CAMERA_HEIGHT);
		backGround.setWidth(CAMERA_WIDTH);
		mScene.attachChild(backGround);

		moOutLineX = CAMERA_WIDTH / 2 - 130;
		moOutLineY = CAMERA_HEIGHT / 2 - 130;

		blackBoard = new Sprite(moOutLineX - 160, moOutLineY - 85,
				mBlackBoardTextureRegion, getVertexBufferObjectManager());
		blackBoard.setHeight((float) (blackBoard.getHeight() * 1.7));
		blackBoard.setWidth((float) (blackBoard.getWidth() * 1.5));
		mScene.attachChild(blackBoard);

		moOutLine = new Sprite(moOutLineX, moOutLineY, mMoOutLineTextureRegion,
				getVertexBufferObjectManager());
		mScene.attachChild(moOutLine);
		
		//creating the duster
		Duster.createDuster();
		
		rectangle = new Rectangle(10, 10, 40, 40, MainActivity.vertexBufferObjectManager);
		MainActivity.mScene.attachChild(rectangle);
		rectangle.setVisible(false);
		
		timer1 = new TimerHandler((float) 1.0f/120,true, new ITimerCallback() 
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) 
			{
				// TODO Auto-generated method stub 
				
				//starting the first step with monkey tutorial
				if(monkeyTutorialStart == 1 )
				{
					MonkeyTutorial.monkeyTutorialAnimationDraw(rectangle.getX()+20 ,
							rectangle.getY() +20);
				}
				//drawing the second time with removing number sprite
				else if(monkeyTutorialStart == 2 )
				{
					MonkeyTutorial.monkeyTutorialAnimationDraw(cursor.getX()+20 ,
							cursor.getY()+20);
				}
				
			}
		});
		mScene.registerUpdateHandler(timer1);

		//invisible rectangle for better collision detection
		rect = new Rectangle(0, 0, 40, 40, vertexBufferObjectManager);
		mScene.attachChild(rect);
		rect.setColor(Color.RED);
		rect.setVisible(false);
		
		
		monkeyTutorial = new MonkeyTutorial(100, -400, mMonkeyTextureRegion,
				getVertexBufferObjectManager());
		monkeyTutorial.animate(new long[]{1000, 1000, 1000, 100, 100, 4000, 1000, 1000, 100, 100}, 0, 9, true);
		mScene.registerTouchArea(monkeyTutorial);
		mScene.attachChild(monkeyTutorial);
		
		MonkeyTutorial.monkeyTutorialstart();
		
		//create book icon
//		PopUp.createBookIcon(); 
//		HandTutorial.handTutorialCreate();

		return mScene;
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) 
	{
		// TODO Auto-generated method stub

		
		if (pSceneTouchEvent.isActionDown()) 
		{
			touch = 1;
			return true;
		}
		else if (pSceneTouchEvent.isActionMove() && MainActivity.isPopupActive == false
				&& MainActivity.isHandTutorialActive == false)
		{
			touch++;
			
			//sorting the scene child
			MainActivity.mScene.sortChildren();
			
			//enabling only by moving, disabling the tap
			if (touch>2)
			{
				//positioning the invisible rectangle according to the touch point 
				rect.setPosition(pSceneTouchEvent.getX() - rect.getWidth() / 2,
						pSceneTouchEvent.getY() - rect.getHeight() / 2);
				//Debug.d("spriteCounter:" + MainActivity.spriteCounter); 
				Debug.d("State:" + state);

				//enabling drawing from the first number sprite
				if (rect.collidesWith(numberSprites[1])) 
				{
					soundCounter++;
					if(soundCounter==1)
					{
						//play sound
						MainActivity.audioPlay = true;
						NumberSprites.playAudio(R.raw.star);
					}
					state = 1;
				}
				
				NumberSprites.getStructure(pSceneTouchEvent.getX(),
						pSceneTouchEvent.getY());
				
				//take the screenShoot when triggered
				if(jCounter == 1)
				{
					ScreenShot.takeScreenShot();
				}
			}
			
			return true;
		}

		else if (pSceneTouchEvent.isActionUp()) 
		{
			touch = 0;
			return true;
		}

		return true;
	}
	
}
