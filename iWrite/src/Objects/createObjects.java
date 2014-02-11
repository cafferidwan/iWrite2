package Objects;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.color.Color;

import com.example.iwrite.MainActivity;

public class createObjects 
{
	public static int letter;
	
	public static void createObject(String letterWord)
	{
		MainActivity.backGround = new Sprite(0, 0, MainActivity.mbackGroundTextureRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.backGround.setHeight(MainActivity.CAMERA_HEIGHT);
		MainActivity.backGround.setWidth(MainActivity.CAMERA_WIDTH);
		MainActivity.mScene.attachChild(MainActivity.backGround);
		
		
		MainActivity.blackBoard = new Sprite(MainActivity.moOutLineX - 160, MainActivity.moOutLineY - 85,
				MainActivity.mBlackBoardTextureRegion, MainActivity.vertexBufferObjectManager);
		MainActivity.blackBoard.setHeight((float) (MainActivity.blackBoard.getHeight() * 1.7));
		MainActivity.blackBoard.setWidth((float) (MainActivity.blackBoard.getWidth() * 1.5));
		MainActivity.mScene.attachChild(MainActivity.blackBoard);
		

		//Rectangle for drawing during tutorial
		MainActivity.rectangle = new Rectangle(10, 10, 40, 40, MainActivity.vertexBufferObjectManager);
		MainActivity.mScene.attachChild(MainActivity.rectangle);
		MainActivity.rectangle.setVisible(false);
		
		//invisible rectangle for better collision detection
		MainActivity.rect = new Rectangle(0, 0, 40, 40, MainActivity.vertexBufferObjectManager);
		MainActivity.mScene.attachChild(MainActivity.rect);
		MainActivity.rect.setColor(Color.RED);
		MainActivity.rect.setVisible(false);
		
		
		
		if(letterWord.toLowerCase().equals("mo"))
		{
			//Outline of letter
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX, MainActivity.moOutLineY,
					MainActivity.mMoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			
			letter = 1;
			
		}
		else if(letterWord.toLowerCase().equals("aa"))
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-200, MainActivity.moOutLineY-180,
					MainActivity.mAaOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.5);
			
			letter = 2;
		}
		
		else if(letterWord.toLowerCase().equals("e"))
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-80, MainActivity.moOutLineY-110,
					MainActivity.mEOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
//			MainActivity.OutLine.setScale((float)0.5);
			MainActivity.OutLine.setScaleY((float)0.8);
			MainActivity.OutLine.setScaleX((float)0.8);
			letter = 3;
		}
		
		
		MainActivity.mScene.attachChild(MainActivity.OutLine);
		
	}
	
}
