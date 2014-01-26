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
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.debug.Debug;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import android.view.Display;

public class MainActivity extends SimpleBaseGameActivity implements IOnSceneTouchListener 
	{

	static int CAMERA_WIDTH;
	static int CAMERA_HEIGHT;
	public Camera mCamera;
	public static Scene mScene;
	public static VertexBufferObjectManager vertexBufferObjectManager;
	public static MainActivity MainActivityInstace;

	public static BitmapTextureAtlas mBitmapTextureAtlasBlackBoard,
			mBitmapTextureAtlasMoOutLine, mBitmapTextureAtlasBackGround,
			mBitmapTextureAtlasWhiteChalk, mBitmapTextureAtlasStar;

	public static ITextureRegion mbackGroundTextureRegion,
			mBlackBoardTextureRegion, mMoOutLineTextureRegion,
			mWhiteChalkTextureRegion, mStarTextureRegion;

	public static BitmapTextureAtlas[] mBitmapTextureAtlasNumber = new BitmapTextureAtlas[25];
	public static ITextureRegion[] mTextureRegionNumber = new ITextureRegion[25];
	public static Sprite[] numberSprites = new Sprite[25];
	public static Sprite[] whiteChalk = new Sprite[5000];

	public static Sprite backGround, blackBoard, moOutLine;

	public static float moOutLineX, moOutLineY;

	public static int iCounter, jCounter, shakeCounter = 0, sCounter, wCounter;
	public static String DEBUG_TAG = MainActivity.class.getSimpleName();
	public static int aCounter = 0, serialCounter = 1, totalLoadNumberPic = 18,
			totalNumberSprite;
	static int animationStart;
	static int spriteCounter, spriteCounterLimit;
	static int  state = 0;
	static Rectangle rect;
	static float posX, posY;
	public static boolean isShaking;
	public static int touch;

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
	protected void onCreateResources() {
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

		// All the numbers
		for (int i = 1; i <= totalLoadNumberPic; i++) {
			mBitmapTextureAtlasNumber[i].load();
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
		animationStart = 0;
		state = 0;
		spriteCounter = 1;
		spriteCounterLimit = 0;
		posX = 0;
		posY = 0;
		isShaking = false;
		touch = 0;

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

		MainActivity.mScene.registerUpdateHandler(new TimerHandler((float) 2, new ITimerCallback() 
		{
					@Override
					public void onTimePassed(TimerHandler pTimerHandler)
					{
						// TODO Auto-generated method stub
						
						//creating the first line of numbers
						spriteCounterLimit = 4;
						Animation.scale(moOutLineX + 70 - 100, moOutLineY - 50, 1);
					}
				}));

		//invisible rectangle for better collision detection
		rect = new Rectangle(0, 0, 40, 40, vertexBufferObjectManager);
		mScene.attachChild(rect);
		rect.setColor(Color.RED);
		rect.setVisible(false);

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
		else if (pSceneTouchEvent.isActionMove())
		{
			Debug.d("animation:" + animationStart);
			touch++; 
			
			//enabling only by moving, disabling the tap
			if (touch>8)
			{
				rect.setPosition(pSceneTouchEvent.getX() - rect.getWidth() / 2,
						pSceneTouchEvent.getY() - rect.getHeight() / 2);
				Debug.d("spriteCounter:" + MainActivity.spriteCounter); 
				Debug.d("State:" + state);
				
				//enabling drawing from the first number sprite
				if (rect.collidesWith(numberSprites[1])) 
				{
					state = 1;
				}
				
				NumberSprites.getStructure(pSceneTouchEvent.getX(),
						pSceneTouchEvent.getY());

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
