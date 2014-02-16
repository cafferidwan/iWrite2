package Objects;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.color.Color;

import Animation.MonkeyTutorial;
import Duster.Duster;
import Letters.LetterStructureBo;
import Letters.LetterStructureE;
import Letters.LetterStructureMo;
import Letters.LetterStructureRaw;
import Letters.LetterStructureTalibaSha;

import com.example.iwrite.MainActivity;

public class createObjects 
{
	
	public static void createObject()
	{
		MainActivity.backGround = new Sprite(0, 0, MainActivity.mbackGroundTextureRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.backGround.setHeight(MainActivity.CAMERA_HEIGHT);
		MainActivity.backGround.setWidth(MainActivity.CAMERA_WIDTH);
		MainActivity.mScene.attachChild(MainActivity.backGround);
		
		
		MainActivity.blackBoard = new Sprite(MainActivity.moOutLineX - 100, MainActivity.moOutLineY -170,
				MainActivity.mBlackBoardTextureRegion, MainActivity.vertexBufferObjectManager);
		MainActivity.blackBoard.setHeight((float) (MainActivity.blackBoard.getHeight() * 1.5));
		MainActivity.blackBoard.setWidth((float) (MainActivity.blackBoard.getWidth() * 1.2));
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
		
		//MonkeyTutorial Create
		MonkeyTutorial.monkeyTutorialCreate();
		
		Duster.createDuster();
		
		//Outline of letter Mo
		if(MainActivity.letter == 1)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX, MainActivity.moOutLineY,
					MainActivity.mMoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
			MonkeyTutorial.monkeyTutorialstart(
					MainActivity.moOutLineX - 10,
					MainActivity.moOutLineY - 20,
					MainActivity.moOutLineX + 180,
					MainActivity.moOutLineY - 20,
					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
		}
		//Outline of letter Aa
		else if(MainActivity.letter == 2)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-200, MainActivity.moOutLineY-180,
					MainActivity.mAaOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.5);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
			MonkeyTutorial.monkeyTutorialstart( 
					MainActivity.moOutLineX - 20,
					MainActivity.moOutLineY - 20,
					MainActivity.moOutLineX + 180,
					MainActivity.moOutLineY - 20,
			
					//Edit From Here
					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
		}
		//Outline of letter e
		else if(MainActivity.letter == 3)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mEOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.8);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//create number with cursor
//			LetterStructureE.createNumberSpriteAndCursor();
			
			//MonkeyTutorial start 
			MonkeyTutorial.monkeyTutorialstart(
					MainActivity.moOutLineX - 10,
					MainActivity.moOutLineY - 20,
					MainActivity.moOutLineX + 180,
					MainActivity.moOutLineY - 20,
				
					//Edit From Here
					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY); 
			 
		}
		//Outline of letter raw
		else if(MainActivity.letter == 4)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mRawOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart( 
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 10,
//			
//					//Edit From Here
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15,
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			LetterStructureRaw.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Ko
		else if(MainActivity.letter == 5)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mKoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart( 
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 10,
//
//					//Edit From Here
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15,
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			LetterStructureRaw.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Bo
		else if(MainActivity.letter == 6)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mBoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart( 
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 10,
//			
//					//Edit From Here
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15,
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			LetterStructureBo.createNumberSpriteAndCursor();
		}
		//Outline of letter TalibaSha
		else if(MainActivity.letter == 7)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mTalibaShaOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
				MainActivity.OutLine.setScale((float)0.9);
				MainActivity.mScene.attachChild(MainActivity.OutLine);
					
				//MonkeyTutorial start 
//				MonkeyTutorial.monkeyTutorialstart( 
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 10,
//
//					//Edit From Here
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15,
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
					
				LetterStructureTalibaSha.createNumberSpriteAndCursor(); 
		}
	}
	
}
