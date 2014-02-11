package com.example.iwrite;

import org.andengine.engine.camera.Camera;
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

import Animation.AnimationDrawTutorial;
import Animation.MonkeyTutorial;
import Objects.createObjects;
import ScreenShoot.BitmapTextureAtlasSource;
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
			mBitmapTextureAtlasWhiteChalk, mBitmapTextureAtlasCursor;

	public static ITextureRegion mbackGroundTextureRegion,
			mBlackBoardTextureRegion, mMoOutLineTextureRegion,
			mWhiteChalkTextureRegion, mCursorTextureRegion,
			mPopUpBlackBoardTextureRegion, mBookIconRegion,
			mCreatePopUpRegion, mCorrectLetterRegion, 
			mHandTutorialTextureRegion,	mCrossRegion,
			mDusterTextureRegion, mSlidingScreenTextureRegion, 
			mMoExampleTextureRegion, mAaOutLineTextureRegion, 
			mEOutLineTextureRegion;
	
	private BuildableBitmapTextureAtlas mAnimatedBitmapTextureAtlas,
							mAnimatedMonkeyBitmapTextureAtlas;
	public static TiledTextureRegion mFishTextureRegion,
							mMonkeyTextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasPieceChalk,
	 mBitmapTextureAtlasBookIcon, mBitmapTextureAtlasHandWirtingBook,
	 mBitmapTextureAtlasBoard, mBitmapTextureAtlasHandCross, 
	 mBitmapTextureAtlasDuster, mBitmapTextureAtlasMonkeyBrush,
	 mBitmapTextureAtlasHandTutorial, mBitmapTextureAtlasMoExample,
	 mBitmapTextureAtlasAaOutLine, mBitmapTextureAtlasEOutLine;

	public static BitmapTextureAtlas[] mBitmapTextureAtlasNumber = new BitmapTextureAtlas[25];
	public static ITextureRegion[] mTextureRegionNumber = new ITextureRegion[25];
	public static Sprite[] numberSprites = new Sprite[25];
	public static Sprite[] whiteChalk = new Sprite[5000];
	public static Sprite[] tutorialWhiteChalk = new Sprite[5000];
	
	public static Sprite backGround, blackBoard, OutLine, aaOutLine;
	public static Sprite bookIcon, handTutorial, duster, slidingScreen;
	public static Sprite createPopUp, correctLetter, drawnPicture, cross, board;
	public static AnimatedSprite cursor;
	public static AnimatedSprite monkeyTutorial;
	public static Rectangle rectangle;
	public static float moOutLineX, moOutLineY;

	public static String DEBUG_TAG = MainActivity.class.getSimpleName();
	
	public static int iCounter, screenShotCounter, shakeCounter = 0, sCounter, wCounter;
	public static int aCounter = 0, bCounter, serialCounter = 1, totalLoadNumberPic = 20;
	public static int monkeyTutorialStart;
	public static int spriteCounter, dusterCounter, dusterFinishCounter ;
	public static int spriteCounterLimit;
	public static int  state = 0;
	public static Rectangle rect;
	public static float posX;
	public static float posY;
	public static boolean isShaking, isPopupActive,
						  isHandTutorialActive, isActionMoving;
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

		mBitmapTextureAtlasBackGround = new BitmapTextureAtlas(this.getTextureManager(), 1600, 864, TextureOptions.BILINEAR);

		mBitmapTextureAtlasBlackBoard = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);

		mBitmapTextureAtlasMoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 254, 262, TextureOptions.BILINEAR);

		mBitmapTextureAtlasWhiteChalk = new BitmapTextureAtlas(this.getTextureManager(), 50, 50, TextureOptions.BILINEAR);

		mBitmapTextureAtlasMoExample = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
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
		
		mBitmapTextureAtlasAaOutLine= new BitmapTextureAtlas(this.getTextureManager(), 700, 600, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasEOutLine= new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
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
		
		mAaOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasAaOutLine, this,
				"aaExample.png", 0, 0,  1, 1);
		
		mEOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasEOutLine, this,
				"eExample.png", 0, 0,  1, 1);
		
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
		
		for (int i = 14; i <= 17; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-13) + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 18; i <= 20; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-17) + ".png", 0, 0, 1, 1);
		}
		
		mBitmapTextureAtlasBackGround.load();
		mBitmapTextureAtlasBlackBoard.load();
		mBitmapTextureAtlasMoOutLine.load();
		mBitmapTextureAtlasWhiteChalk.load();
		mBitmapTextureAtlasWhiteChalk.load();
		
		mBitmapTextureAtlasBookIcon.load();
		mBitmapTextureAtlasHandWirtingBook.load();
		mBitmapTextureAtlasBoard.load();
		mBitmapTextureAtlasHandCross.load();
		mBitmapTextureAtlasDuster.load();
		mBitmapTextureAtlasMonkeyBrush.load();
		mBitmapTextureAtlasHandTutorial.load();
		mBitmapTextureAtlasMoExample.load();
		mBitmapTextureAtlasAaOutLine.load();
		mBitmapTextureAtlasEOutLine.load();

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
		isActionMoving = true;
		touch = 0;
		soundCounter=0;
		bCounter = 0;
		changeTexture = 0;
		screenShotCounter = 0;
		tutorialCounter = 0;
		dusterCounter = 0;
		dusterFinishCounter = 0;

		//getting the renderView width and height for taking the screen shot
		viewWidth = MainActivity.MainActivityInstace.mRenderSurfaceView.getWidth() - 525;
		viewHeight = MainActivity.MainActivityInstace.mRenderSurfaceView.getHeight() - 165;
		
		moOutLineX = CAMERA_WIDTH / 2 - 130;
		moOutLineY = CAMERA_HEIGHT / 2 - 130;
		
		//create objects
		createObjects.createObject("aa");
		
		//Timer for drawing during monkey Tutorial
		AnimationDrawTutorial.animationDrawTimer();
		mScene.registerUpdateHandler(timer1);

		//MonkeyTutorial Create
//		MonkeyTutorial.monkeyTutorialCreate();
		//MonkeyTutorial start
//		MonkeyTutorial.monkeyTutorialstart();
		
		//create book icon
//		PopUp.createBookIcon(); 
//		HandTutorial.handTutorialCreate();
		
		//create number with cursor
		AnimationDrawTutorial.createNumberSpriteAndCursor(2, 4);

		return mScene;
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) 
	{
		// TODO Auto-generated method stub
		return Touch.touchEvent(pSceneTouchEvent);
	}
	
}
