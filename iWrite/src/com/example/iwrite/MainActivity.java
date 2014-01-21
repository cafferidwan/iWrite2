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
	
	public static ITextureRegion mbackGroundTextureRegion, mBlackBoardTextureRegion, 
	mMoOutLineTextureRegion, mWhiteChalkTextureRegion, mStarTextureRegion;
	
	public static BitmapTextureAtlas [] mBitmapTextureAtlasNumber = new BitmapTextureAtlas[25];
	public static ITextureRegion [] mTextureRegionNumber = new ITextureRegion[25];
	public static Sprite[] numberSprites= new Sprite[25];
	public static Sprite[] whiteChalk = new Sprite[5000];
	
	public static Sprite backGround, blackBoard, moOutLine;
	
	public static float moOutLineX, moOutLineY;
	
	public static int iCounter, jCounter, j=0, sCounter, wCounter;
	public static String DEBUG_TAG = MainActivity.class.getSimpleName();
	public static int aCounter = 0, serialCounter = 1, totalLoadNumberPic = 15, totalNumberSprite;
	public static int animation ;
	static int spriteCounter, spriteCounterLimit;
	static int a = 0, b = 0;
	static Rectangle rect ; 
	static float posX, posY;
	
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
		b = 0;
		spriteCounter = 1;
		spriteCounterLimit = 0;
		posX = 0;
		posY = 0;

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
		
		
		MainActivity.mScene.registerUpdateHandler(new TimerHandler((float)2, new ITimerCallback() 
		{
			 
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) 
			{
				// TODO Auto-generated method stub
				posX = moOutLineX+70 - 100;
				posY = moOutLineY -50;
				
				spriteCounterLimit = 4;
				Animation.scale(moOutLineX+70 - 100, moOutLineY -50, 1);
				
				//Animation.shake(1, numberSprites[1], 10);
			} 
		}));
		
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
		
		if(pSceneTouchEvent.isActionDown())
		{
			//Debug.d("action down");
			return true;
		}
		
		if(pSceneTouchEvent.isActionMove())
		{
			rect.setPosition(pSceneTouchEvent.getX()-rect.getWidth()/2, pSceneTouchEvent.getY()-rect.getHeight()/2);
			Debug.d("spriteCounter:"+MainActivity.spriteCounter);
			
			if(rect.collidesWith(numberSprites[1]))
			{
				b=1;
			}
			
			if(b==1)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY()); 
				
				remove(2, 1,2);
				
				if(
					   whiteChalk[aCounter].getX() - posX< -20 
					|| whiteChalk[aCounter].getY() - posY>100 
					|| whiteChalk[aCounter].getY() - posY<0
					|| whiteChalk[aCounter].collidesWith(numberSprites[3]) 
					|| whiteChalk[aCounter].collidesWith(numberSprites[4])
						)
				{
					for(int a=0; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				} 
				
			}  
			else if(b==2)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = moOutLineX+140 - 100;
				posY = moOutLineY - 50;
				
				remove(3,2,3);
				 
				if(
						whiteChalk[aCounter].getX() - posX< -20 
					|| whiteChalk[aCounter].getY() - posY>100
					|| whiteChalk[aCounter].getY() - posY<0
					|| whiteChalk[aCounter].collidesWith(numberSprites[4]) 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				} 
			}
			else if(b==3)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = moOutLineX+210 - 100;
				posY = moOutLineY - 50;
				
				remove(4,3,4);
				
				if(
						whiteChalk[aCounter].getX() - posX< -20 
					|| whiteChalk[aCounter].getY() - posY>100
					|| whiteChalk[aCounter].getY() - posY<0
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				} 
			}
			else if(b==4)
			{
				spriteCounterLimit=7;
				Animation.scale(MainActivity.moOutLineX ,
						MainActivity.moOutLineY+300 - 350, 5); 
				b=5;
			}
			else if(b==5)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = moOutLineX+180 - 150;
				posY = moOutLineY+300 - 350;
				
				remove(5,4,6);
					//b=4;
				
				if(
						whiteChalk[aCounter].getX() - posX< -20 
					|| whiteChalk[aCounter].getY() - posY>130
					|| whiteChalk[aCounter].getY() - posY<0
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				} 
			}
			else if(b==6)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
//				posX = numberSprites[6].getX();
//				posY = numberSprites[6].getY();
				
				remove(6,5,7);
					//b=4;
				
				if(
						whiteChalk[aCounter].getX() - posX< -20 
					|| whiteChalk[aCounter].getY() - posY>130
					|| whiteChalk[aCounter].getY() - posY<0
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				} 
			}
			else if(b==7)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
//				posX = numberSprites[7].getX();
//				posY = numberSprites[7].getY();
				
				remove(7,6,8);
					//b=4;
				
				if(
						whiteChalk[aCounter].getX() - posX< -20 
					|| whiteChalk[aCounter].getY() - posY>130
					|| whiteChalk[aCounter].getY() - posY<0
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
			}
			else if(b==8)
			{
				spriteCounterLimit=9;
				Animation.scale(moOutLineX-50*MainActivity.spriteCounter +410 ,
						MainActivity.moOutLineY-30*spriteCounter + 340, spriteCounter); 
				b=9;
			}
			else if(b==9)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
//				posX = numberSprites[8].getX();
//				posY = numberSprites[8].getY();
				
				remove(8,7,10);
					//b=4;
				
				if(
						whiteChalk[aCounter].getX() - posX< -20 
					|| whiteChalk[aCounter].getY() - posY>130
					|| whiteChalk[aCounter].getY() - posY<0
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
			}
			else if(b==10)
			{
				spriteCounterLimit=12;
				Animation.scale(MainActivity.moOutLineX+40*MainActivity.spriteCounter -345 ,
						MainActivity.moOutLineY+50*MainActivity.spriteCounter-430, spriteCounter); 
				b=11;
			}
			 
			
			return true;
		}
		
		if(pSceneTouchEvent.isActionUp())
		{
			//Debug.d("action up");
			a=0;
			return true;
		}
		
		return true;
	}
	
	public static void remove(int collisionSprite, int removeSpriteNumber, int stateNUmber)
	{
		if(whiteChalk[aCounter].collidesWith(numberSprites[collisionSprite]))
		{
			mScene.detachChild(numberSprites[removeSpriteNumber]);
			numberSprites[removeSpriteNumber].setY(CAMERA_HEIGHT+500);
			wCounter = aCounter;
			b = stateNUmber;
		}
	}
	
	public static void deleteWhiteChalk()
	{
		for(int a=0; a<=aCounter; a++)
		{
			mScene.detachChild(whiteChalk[a]);
		}
	}
	
	public static void Draw(float x, float y)
	{
		aCounter++;
		whiteChalk[aCounter] = new Sprite(x -25, y-30, mWhiteChalkTextureRegion, vertexBufferObjectManager);
		mScene.attachChild(MainActivity.whiteChalk[aCounter]);
		whiteChalk[aCounter].setScale((float) 0.6);
		Debug.d("I:"+aCounter); 
	}
	
}
