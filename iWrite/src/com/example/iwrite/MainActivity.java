package com.example.iwrite;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
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
	
	public static ITextureRegion mbackGroundTextureRegion, mBlackBoardTextureRegion, 
	mMoOutLineTextureRegion, mWhiteChalkTextureRegion, mStarTextureRegion;
	
	public static BitmapTextureAtlas [] mBitmapTextureAtlasNumber = new BitmapTextureAtlas[25];
	public static ITextureRegion [] mTextureRegionNumber = new ITextureRegion[25];
	public static NumberSprites[] numberSprites= new NumberSprites[25];
	public static DrawImage [] whiteChalk = new DrawImage[5000];
	
	public static Sprite backGround, blackBoard, moOutLine;
	
	public static float moOutLineX, moOutLineY;
	
	public static int iCounter, jCounter, j=0, sCounter, wCounter;
	public static String DEBUG_TAG = MainActivity.class.getSimpleName();
	public static int aCounter = 0, serialCounter = 1, totalLoadNumberPic = 15, totalNumberSprite;
	public static int animation ;
	
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
		 
		mBitmapTextureAtlasStar = new BitmapTextureAtlas(this.getTextureManager(), 50, 50, TextureOptions.BILINEAR);
		 
		//All the numbers
		for(int i=1; i<=totalLoadNumberPic; i++)
		{
			mBitmapTextureAtlasNumber[i] = new BitmapTextureAtlas(this.getTextureManager(), 150, 150, TextureOptions.BILINEAR);
		}
		
		mbackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBackGround, this,
				"JungleBG.png", 0, 0,  1, 1); 
		
		mBlackBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBlackBoard, this,
				"blackboard.png", 0, 0,  1, 1); 
				
		mMoOutLineTextureRegion =  BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMoOutLine, this,
				"moOutlineCrop.png", 0, 0,  1, 1); 
				
		mWhiteChalkTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWhiteChalk, this,
				"chalk2.png", 0, 0,  1, 1);
		
		mStarTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasStar, this,
				"star.png", 0, 0,  1, 1);
		
		//All the numbers
		for(int i=1; i<=totalLoadNumberPic; i++)
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
					"Number"+i+".png", 0, 0,  1, 1);
		}
		
		mBitmapTextureAtlasBackGround.load();
		mBitmapTextureAtlasBlackBoard.load();
		mBitmapTextureAtlasMoOutLine.load();
		mBitmapTextureAtlasWhiteChalk.load();
		mBitmapTextureAtlasStar.load();
		mBitmapTextureAtlasWhiteChalk.load();
		
		//All the numbers
		for(int i=1; i<=totalLoadNumberPic; i++)
		{
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
		animation = 0;

		backGround = new Sprite(0, 0, mbackGroundTextureRegion,
				getVertexBufferObjectManager());
		backGround.setHeight(CAMERA_HEIGHT);
		backGround.setWidth(CAMERA_WIDTH);
		mScene.attachChild(backGround);

		moOutLineX = CAMERA_WIDTH / 2 - 130;
		moOutLineY = CAMERA_HEIGHT / 2 - 130;
		
		blackBoard = new Sprite(moOutLineX-160, moOutLineY-85, mBlackBoardTextureRegion,
				getVertexBufferObjectManager());
		blackBoard.setHeight((float) (blackBoard.getHeight()*1.7));
		blackBoard.setWidth((float) (blackBoard.getWidth()*1.5));
		mScene.attachChild(blackBoard);

		moOutLine = new Sprite(moOutLineX, moOutLineY, mMoOutLineTextureRegion,
				getVertexBufferObjectManager());
		mScene.attachChild(moOutLine);
		
		for(int i=1; i<=4; i++)
		{	
			numberSprites[i] = new NumberSprites(moOutLineX+70*i - 100, moOutLineY -50, 
				mTextureRegionNumber[i], getVertexBufferObjectManager());
		
			mScene.attachChild(numberSprites[i]);
			mScene.registerTouchArea(numberSprites[i]);
			numberSprites[i].setScale((float) 0.3); 
			numberSprites[i].setVisible(false);
		
		}
		
		for(int l=5; l<=7; l++)
		{
			numberSprites[l] = new NumberSprites(moOutLineX+30*l - 150 , moOutLineY+60*l - 350, 
				mTextureRegionNumber[l], getVertexBufferObjectManager());
		
			mScene.attachChild(numberSprites[l]);
			mScene.registerTouchArea(numberSprites[l]);
			numberSprites[l].setScale((float) 0.3);
			numberSprites[l].setVisible(false);
		} 
		
		for(int m=8; m<=9; m++)
		{ 
			numberSprites[m] = new NumberSprites(moOutLineX-50*m +410 , moOutLineY-30*m + 340 , 
				mTextureRegionNumber[m], getVertexBufferObjectManager());
			
			mScene.attachChild(numberSprites[m]);
			mScene.registerTouchArea(numberSprites[m]);
			numberSprites[m].setScale((float) 0.3);
			numberSprites[m].setVisible(false);
		}
		
		for(int n=10; n<=12; n++)
		{
			numberSprites[n] = new NumberSprites(moOutLineX+40*n -345 , moOutLineY+50*n-430 , 
				mTextureRegionNumber[n], getVertexBufferObjectManager());
			
			mScene.attachChild(numberSprites[n]);
			mScene.registerTouchArea(numberSprites[n]);
			numberSprites[n].setScale((float) 0.3);
			numberSprites[n].setVisible(false);
		}
		
		for(int o=13; o<=15; o++)
		{
			numberSprites[o] = new NumberSprites(moOutLineX+120 , moOutLineY-70*o+1000, 
				mTextureRegionNumber[o], getVertexBufferObjectManager());
			
			mScene.attachChild(numberSprites[o]);
			mScene.registerTouchArea(numberSprites[o]);
			numberSprites[o].setScale((float) 0.3);
			numberSprites[o].setVisible(false);
		}
		
		MainActivity.mScene.registerUpdateHandler(new TimerHandler((float)1, new ITimerCallback() 
		{
			 
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) 
			{
				// TODO Auto-generated method stub
				iCounter=1;
				jCounter=4;
				Animation.scale( numberSprites[1]);
				//Animation.shake(1, numberSprites[1], 10);
			} 
		}));
		
		MainActivity.mScene.registerUpdateHandler(new TimerHandler((float)0.07, true, new ITimerCallback() 
		{
			
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) 
			{
				// TODO Auto-generated method stub
				
			} 
		}));
		
		return mScene;
	}
	
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) 
	{
		// TODO Auto-generated method stub
		
		if(pSceneTouchEvent.isActionDown())
		{
			//Debug.d("action down");
			return true;
		}
		
		if(pSceneTouchEvent.isActionMove())
		{
			if(animation == 0)
			{
			aCounter++;
			whiteChalk[aCounter] = new DrawImage(pSceneTouchEvent.getX() -25, pSceneTouchEvent.getY()-30, mWhiteChalkTextureRegion, getVertexBufferObjectManager());
			mScene.attachChild(MainActivity.whiteChalk[aCounter]);
			whiteChalk[aCounter].setScale((float) 0.6);
			Debug.d("I:"+aCounter); 
			
			if(whiteChalk[aCounter].collidesWith(numberSprites[serialCounter]))
			{
				//numberSprites[serialCounter].setVisible(false);
				mScene.detachChild(numberSprites[serialCounter]); 
				serialCounter++;
				//Debug.d("serial:"+serialCounter);
				
				if(serialCounter>4 && sCounter == 0)
				{
					aCounter= 0;
					//wCounter = aCounter;
					Debug.d("wCounter:"+wCounter);
					sCounter++;
					iCounter=5;
					jCounter=7;
					Animation.scale( numberSprites[5]);
					
				}
				if(serialCounter>7 && sCounter == 1)
				{	
					aCounter= 0;
					wCounter = aCounter;
					Debug.d("wCounter:"+wCounter);  
					sCounter++;
					iCounter=8;
					jCounter=9;
					Animation.scale( numberSprites[8]);
				
				}
				if(serialCounter>9 && sCounter == 2)
				{	 
					aCounter= 0;
					wCounter = aCounter;
					Debug.d("wCounter:"+wCounter);
					sCounter++;
					iCounter=10;
					jCounter=12;
					Animation.scale( numberSprites[10]);
				
				}
				if(serialCounter>12 && sCounter == 3)
				{	 
					aCounter= 0;
					wCounter = aCounter;
					Debug.d("wCounter:"+wCounter);
					sCounter++;
					iCounter=13;
					jCounter=15;
					Animation.scale( numberSprites[13]);
				
				}
			}
			
			if(numberSprites[serialCounter]!= null && whiteChalk[aCounter]!= null)
			{ 
				if(distance(whiteChalk[aCounter], numberSprites[serialCounter])==true)
				{
					for(int k=wCounter; k<aCounter; k++)
					{
						mScene.detachChild(whiteChalk[k]);
					}
				}
			}
			}
			return true;
		}
		
		if(pSceneTouchEvent.isActionUp())
		{
			//Debug.d("action up");
			return true;
		}
		
		return true;
	}
	
	public static boolean distance(Sprite a , Sprite b)
	{
		double dist = Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
		
		if(dist>80)
		{
			return true;
		}
		else
			return false;
	}
}
