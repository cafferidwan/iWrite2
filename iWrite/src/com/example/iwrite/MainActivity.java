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
	public static int aCounter = 0, serialCounter = 1, totalLoadNumberPic = 18, totalNumberSprite;
	static int animationStart;
	int lineCounter1 ;
	static int spriteCounter, spriteCounterLimit;
	static int a = 0, b = 0;
	static Rectangle rect ; 
	static float posX, posY;
	static int[] lineCounter = new int[50];
	
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
		animationStart = 0;
		b = 0;
		spriteCounter = 1;
		spriteCounterLimit = 0;
		posX = 0;
		posY = 0;
		lineCounter1 = 0;
		lineCounter[0]=0;
		lineCounter[1]=0;
		lineCounter[2]=0;
		lineCounter[3]=0;
		lineCounter[4]=0;
		lineCounter[5]=0;
		lineCounter[6]=0;
		lineCounter[7]=0;
		lineCounter[8]=0;
		lineCounter[9]=0;
		lineCounter[10]=0;
		

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
			Debug.d("animation:"+animationStart);
			if(animationStart == 0)
			{
			rect.setPosition(pSceneTouchEvent.getX()-rect.getWidth()/2, pSceneTouchEvent.getY()-rect.getHeight()/2);
			Debug.d("spriteCounter:"+MainActivity.spriteCounter);
			Debug.d("State:"+b);
			if(rect.collidesWith(numberSprites[1]))
			{
				lineCounter[1]++;
				if(lineCounter[1]==1)
				{
					b=1;
				}
			}
			
			if(b==1)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY()); 
				
				posX = numberSprites[1].getX()+numberSprites[1].getWidth()/2-20;
				posY = numberSprites[1].getY()+numberSprites[1].getHeight()/2-20;
				
				if( 
					   whiteChalk[aCounter].getX() - posX< -55 
					|| whiteChalk[aCounter].getY() - posY>30 
					|| whiteChalk[aCounter].getY() - posY<-55 
					|| whiteChalk[aCounter].collidesWith(numberSprites[3]) 
					|| whiteChalk[aCounter].collidesWith(numberSprites[4])
						)
				{
					for(int a=0; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				}
				else 
				{
					remove(2, 1,2);
				}
				
			}  
			else if(b==2)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[2].getX()+numberSprites[2].getWidth()/2-20;
				posY = numberSprites[2].getY()+numberSprites[2].getHeight()/2-20;
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
					|| whiteChalk[aCounter].getY() - posY>30 
					|| whiteChalk[aCounter].getY() - posY<-55 
					|| whiteChalk[aCounter].collidesWith(numberSprites[4]) 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				} 
				else
				{
					remove(3,2,3);
				}
			}
			else if(b==3)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[3].getX()+numberSprites[3].getWidth()/2-20;
				posY = numberSprites[3].getY()+numberSprites[3].getHeight()/2-20;
				
				//rect(posX, posY);
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
					|| whiteChalk[aCounter].getY() - posY>30 
					|| whiteChalk[aCounter].getY() - posY<-55 
					)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				} 
				else
				{
					remove(4,3,4);
				}
			}
			else if(b==4)
			{
				//creating new line of numbers
				spriteCounterLimit=7;
				Animation.scale(MainActivity.moOutLineX ,
						MainActivity.moOutLineY+300 - 350, spriteCounter); 
				b=5;
//				}
			}
			else if(b==5)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[5].getX()+numberSprites[5].getWidth()/2-20; 
				posY = numberSprites[5].getY()+numberSprites[5].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>50 
							|| whiteChalk[aCounter].getY() - posY<-55 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				} 
				else
				{
					remove(6,5,6);
				}
			}
			else if(b==6)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[6].getX()+numberSprites[6].getWidth()/2-20; 
				posY = numberSprites[6].getY()+numberSprites[6].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>50 
							|| whiteChalk[aCounter].getY() - posY<-55 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					}
					
				}
				else 
				{
					remove(7,6,7); 
				}
			}  
			else if(b==7)
			{
				spriteCounterLimit=9;
				Animation.scale(moOutLineX-50*MainActivity.spriteCounter +410 ,
						MainActivity.moOutLineY-30*spriteCounter + 340, spriteCounter); 
				b=8;
			}
			else if(b==8)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[7].getX()+numberSprites[7].getWidth()/2-20; 
				posY = numberSprites[7].getY()+numberSprites[7].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>50 
							|| whiteChalk[aCounter].getY() - posY<-35  
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
				}
				else
				{
					remove(8,7,9);
				}
			}
			else if(b==9)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[8].getX()+numberSprites[8].getWidth()/2-20; 
				posY = numberSprites[8].getY()+numberSprites[8].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				//rect(posX, posY);
				 
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>30 
							|| whiteChalk[aCounter].getY() - posY<-35 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
				else
				{
					remove(9,8,10);
				} 
			}
			else if(b==10)
			{
				spriteCounterLimit=13;
				Animation.scale(MainActivity.moOutLineX+40*MainActivity.spriteCounter -385 ,
						MainActivity.moOutLineY+50*MainActivity.spriteCounter-450, spriteCounter); 
				b=11;
			} 
			
			
			else if(b==11)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[9].getX()+numberSprites[9].getWidth()/2-20; 
				posY = numberSprites[9].getY()+numberSprites[9].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				//rect(posX, posY);
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>30 
							|| whiteChalk[aCounter].getY() - posY<-35 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
				else
				{
					remove(10,9,12);
				}
			}
			else if(b==12)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[10].getX()+numberSprites[10].getWidth()/2-20; 
				posY = numberSprites[10].getY()+numberSprites[10].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				//rect(posX, posY);
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>30 
							|| whiteChalk[aCounter].getY() - posY<-35 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
				else
				{
					remove(11,10,13);
				}
			}
			else if(b==13)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[11].getX()+numberSprites[11].getWidth()/2-20; 
				posY = numberSprites[11].getY()+numberSprites[11].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				//rect(posX, posY);
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>30 
							|| whiteChalk[aCounter].getY() - posY<-35 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
				else
				{
					remove(12,11,14);
				}
			}
			
			else if(b==14)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[12].getX()+numberSprites[12].getWidth()/2-20; 
				posY = numberSprites[12].getY()+numberSprites[12].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				//rect(posX, posY);
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>30 
							|| whiteChalk[aCounter].getY() - posY<-35 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
				else
				{
					remove(13,12,16);
				}
			}
			else if(b==16)
			{
				spriteCounterLimit=16;
				Animation.scale(MainActivity.moOutLineX+120 , 
						80+MainActivity.moOutLineY-70*MainActivity.spriteCounter+1000, spriteCounter); 
				b=17; 
			}
			else if(b==17)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[13].getX()+numberSprites[13].getWidth()/2-20; 
				posY = numberSprites[13].getY()+numberSprites[13].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				//rect(posX, posY);
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>30 
							|| whiteChalk[aCounter].getY() - posY<-35 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
				else
				{
					remove(14,13,18);
				}
			} 
			else if(b==18)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[14].getX()+numberSprites[14].getWidth()/2-20; 
				posY = numberSprites[14].getY()+numberSprites[14].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				//rect(posX, posY);
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>30 
							|| whiteChalk[aCounter].getY() - posY<-55 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
				else
				{
					remove(15,14,19); 
				}
			} 
			else if(b==19)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[15].getX()+numberSprites[15].getWidth()/2-20; 
				posY = numberSprites[15].getY()+numberSprites[15].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				//rect(posX, posY);
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>30 
							|| whiteChalk[aCounter].getY() - posY<-55 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
				else
				{
					remove(16,15,20); 
				}
			}
			else if(b==20)
			{
				Draw(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				
				posX = numberSprites[16].getX()+numberSprites[16].getWidth()/2-20; 
				posY = numberSprites[16].getY()+numberSprites[16].getHeight()/2-20;
				
				Debug.d("dist.x:"+(whiteChalk[aCounter].getX() - posX));
				Debug.d("dist.y:"+(whiteChalk[aCounter].getY() - posY));
				
				//rect(posX, posY);
				
				if(
						 whiteChalk[aCounter].getX() - posX< -55 
						 	|| whiteChalk[aCounter].getX() - posX>30 
							|| whiteChalk[aCounter].getY() - posY>30 
							|| whiteChalk[aCounter].getY() - posY<-55 
						)
				{
					for(int a=wCounter; a<=aCounter; a++)
					{
						mScene.detachChild(whiteChalk[a]);
					} 
					
				} 
				else
				{
					remove(17,16,20); 
				}
			}
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
	
	public static void rect(float x, float y)
	{
		Rectangle rect = new Rectangle(x, y, 30, 30, vertexBufferObjectManager);
		mScene.attachChild(rect);
		rect.setColor(Color.RED);
	}
	
	public static void remove(int collisionSprite, int removeSpriteNumber, int stateNUmber)
	{
		if(whiteChalk[aCounter].collidesWith(numberSprites[collisionSprite]))
		{
			if(collisionSprite == 4)
			{
				mScene.detachChild(numberSprites[4]);
			}
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
