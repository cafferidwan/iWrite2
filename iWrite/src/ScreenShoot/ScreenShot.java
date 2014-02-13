package ScreenShoot;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.util.ScreenCapture;
import org.andengine.entity.util.ScreenCapture.IScreenCaptureCallback;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.util.FileUtils;
import android.graphics.BitmapFactory;
import com.example.iwrite.MainActivity;

public class ScreenShot 
{

	public ScreenShot()
	{
		
		MainActivity.cursor.setVisible(false);
		//final float time = System.currentTimeMillis();
		MainActivity.screenCapture.capture(264, 90, MainActivity.viewWidth, MainActivity.viewHeight,FileUtils.getAbsolutePathOnInternalStorage
				(MainActivity.MainActivityInstace.getApplicationContext(), "/screen"+".jpg") , new IScreenCaptureCallback() 
		{ 
			@Override
			public void onScreenCaptured(final String pFilePath) 
			{
				MainActivity.MainActivityInstace.runOnUiThread(new Runnable()
				{
					@Override
					public void run() 
					{
						//Debug.d("Screenshot: " + pFilePath + " taken!");
						MainActivity.changeTexture = 1;
						new setTexture(FileUtils.getAbsolutePathOnInternalStorage
								(MainActivity.MainActivityInstace.getApplicationContext(), "/screen"+".jpg"));
					} 
				});
			}

			@Override
			public void onScreenCaptureFailed(final String pFilePath, final Exception pException)
			{
				MainActivity.MainActivityInstace.runOnUiThread(new Runnable()
				{
					@Override
					public void run() 
					{
						MainActivity.changeTexture = 0;
					}
				});
			}
		});

	}
	
	public static class setTexture
	{
		public setTexture(String address)
		{ 
			//this.mDrawnPictureRegion = textureRegion;
			MainActivity.source = new BitmapTextureAtlasSource(
					BitmapFactory.decodeFile(address));
			MainActivity.texture = new BitmapTextureAtlas(MainActivity.MainActivityInstace.getTextureManager(),
					1000, 1000);
			MainActivity.texture.addTextureAtlasSource(MainActivity.source, 0, 0);
			MainActivity.texture.load();
			MainActivity.textureRegion = (TextureRegion) TextureRegionFactory.createFromSource(
					MainActivity.texture, MainActivity.source, 0, 0);
		}
		
	}
	
	//calling for screen shot
	public static void takeScreenShot()
		{
		MainActivity.screenCapture = new ScreenCapture();
			MainActivity.mScene.attachChild(MainActivity.screenCapture);
			
			MainActivity.mScene.registerUpdateHandler(new TimerHandler((float)0.5, new ITimerCallback() 
			{
				@Override
				public void onTimePassed(TimerHandler pTimerHandler)
				{
					// TODO Auto-generated method stub
					
					//trigger the screen shot
					new ScreenShot();
				} 
			}));
		}
}
