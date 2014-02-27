package Objects;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.color.Color;
import Animation.MonkeyTutorial;
import Duster.Duster;
import Letters.LetterStructureA;
import Letters.LetterStructureAkar;
import Letters.LetterStructureBo;
import Letters.LetterStructureCho;
import Letters.LetterStructureDo;
import Letters.LetterStructureDoh;
import Letters.LetterStructureEkar;
import Letters.LetterStructureGo;
import Letters.LetterStructureHo;
import Letters.LetterStructureKho;
import Letters.LetterStructureLo;
import Letters.LetterStructureMo;
import Letters.LetterStructureNo;
import Letters.LetterStructurePo;
import Letters.LetterStructureRaw;
import Letters.LetterStructureTalibaSha;
import Letters.LetterStructureTo;
import Letters.LetterStructureToh;
import Letters.LetterStructureU;
import Letters.LetterStructureUkar;

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
//		MainActivity.rect.setVisible(false);
		
		//MonkeyTutorial Create
		MonkeyTutorial.monkeyTutorialCreate();
		
		Duster.createDuster();
		
		//Outline of letter Mo
		if(MainActivity.letter == 1)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX, MainActivity.moOutLineY,
					MainActivity.mMoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
//			MonkeyTutorial start 
			MonkeyTutorial.monkeyTutorialstart(2,
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
					MainActivity.moOutLineX+150, MainActivity.moOutLineY,
					
					MainActivity.moOutLineX+150, MainActivity.moOutLineY,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY,
					
					MainActivity.moOutLineX+150, MainActivity.moOutLineY,
					MainActivity.moOutLineX+150, MainActivity.moOutLineY
					);
			
//			LetterStructureMo.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Aa
		else if(MainActivity.letter == 2)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-200, MainActivity.moOutLineY-180,
					MainActivity.mAaOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.5);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
			MonkeyTutorial.monkeyTutorialstart(4,
					MainActivity.moOutLineX - 20,
					MainActivity.moOutLineY - 20,
					MainActivity.moOutLineX + 220,
					MainActivity.moOutLineY - 20,
			
					//Edit From Here
					MainActivity.moOutLineX+41, MainActivity.moOutLineY+56, 
					MainActivity.moOutLineX+73, MainActivity.moOutLineY+18,
					MainActivity.moOutLineX+107, MainActivity.moOutLineY+51,
					MainActivity.moOutLineX+100, MainActivity.moOutLineY+119,
					MainActivity.moOutLineX+54, MainActivity.moOutLineY+134,
					MainActivity.moOutLineX-8, MainActivity.moOutLineY+99,
					MainActivity.moOutLineX-38, MainActivity.moOutLineY+13,
					MainActivity.moOutLineX-38, MainActivity.moOutLineY+13,
					MainActivity.moOutLineX-38, MainActivity.moOutLineY+13,
					
					MainActivity.moOutLineX+104, MainActivity.moOutLineY+110, 
					MainActivity.moOutLineX+159, MainActivity.moOutLineY+183,
					MainActivity.moOutLineX+159, MainActivity.moOutLineY-12,
					MainActivity.moOutLineX+163, MainActivity.moOutLineY-12,
					
					MainActivity.moOutLineX+224, MainActivity.moOutLineY-8, 
					MainActivity.moOutLineX+224, MainActivity.moOutLineY+185
					);
		}
		//Outline of letter e
		else if(MainActivity.letter == 3)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mEOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.8);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
			MonkeyTutorial.monkeyTutorialstart(3,
					MainActivity.moOutLineX - 9,
					MainActivity.moOutLineY + 3,
					MainActivity.moOutLineX + 165,
					MainActivity.moOutLineY + 3,
					
					MainActivity.moOutLineX+50, MainActivity.moOutLineY+65, 
					MainActivity.moOutLineX+91, MainActivity.moOutLineY+40,
					MainActivity.moOutLineX+118, MainActivity.moOutLineY+54,
					MainActivity.moOutLineX+123, MainActivity.moOutLineY+105,
					MainActivity.moOutLineX+54, MainActivity.moOutLineY+134,
					MainActivity.moOutLineX+45, MainActivity.moOutLineY+140,
					MainActivity.moOutLineX+107, MainActivity.moOutLineY+167,
					MainActivity.moOutLineX+155, MainActivity.moOutLineY+205,
					MainActivity.moOutLineX+155, MainActivity.moOutLineY+205,
					
					MainActivity.moOutLineX+134, MainActivity.moOutLineY-3, 
					MainActivity.moOutLineX+104, MainActivity.moOutLineY-40,
					MainActivity.moOutLineX+19, MainActivity.moOutLineY-39,
					MainActivity.moOutLineX+1, MainActivity.moOutLineY-70,
					
					MainActivity.moOutLineX+1, MainActivity.moOutLineY-70,
					MainActivity.moOutLineX+1, MainActivity.moOutLineY-70
					); 
			 
		}
		//Outline of letter raw
		else if(MainActivity.letter == 4)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mRawOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
			MonkeyTutorial.monkeyTutorialstart(3,
					MainActivity.moOutLineX - 23,
					MainActivity.moOutLineY - 48,
					MainActivity.moOutLineX + 186,
					MainActivity.moOutLineY -48,
					
					MainActivity.moOutLineX+138, MainActivity.moOutLineY-10, 
					MainActivity.moOutLineX+15, MainActivity.moOutLineY+53,
					MainActivity.moOutLineX+41, MainActivity.moOutLineY+81,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY+158,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					
					MainActivity.moOutLineX+58, MainActivity.moOutLineY+159, 
					MainActivity.moOutLineX+58, MainActivity.moOutLineY+159, 
					MainActivity.moOutLineX+63, MainActivity.moOutLineY+159, 
					MainActivity.moOutLineX+63, MainActivity.moOutLineY+159, 
					
					MainActivity.moOutLineX+1, MainActivity.moOutLineY-70,
					MainActivity.moOutLineX+1, MainActivity.moOutLineY-70
					); 
			
//			LetterStructureRaw.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Ko
		else if(MainActivity.letter == 5)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mKoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
			MonkeyTutorial.monkeyTutorialstart(3,
					MainActivity.moOutLineX - 23,
					MainActivity.moOutLineY - 48,
					MainActivity.moOutLineX + 190,
					MainActivity.moOutLineY -48,
					
					MainActivity.moOutLineX+138, MainActivity.moOutLineY-10, 
					MainActivity.moOutLineX+15, MainActivity.moOutLineY+53,
					MainActivity.moOutLineX+41, MainActivity.moOutLineY+81,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY+158,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					
					MainActivity.moOutLineX+159, MainActivity.moOutLineY-8, 
					MainActivity.moOutLineX+220, MainActivity.moOutLineY+21, 
					MainActivity.moOutLineX+238, MainActivity.moOutLineY+88, 
					MainActivity.moOutLineX+190, MainActivity.moOutLineY+98, 
					
					MainActivity.moOutLineX+1, MainActivity.moOutLineY-70,
					MainActivity.moOutLineX+1, MainActivity.moOutLineY-70
					); 
			
//			LetterStructureRaw.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Bo
		else if(MainActivity.letter == 6)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mBoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
			MonkeyTutorial.monkeyTutorialstart(2,
					MainActivity.moOutLineX - 23,
					MainActivity.moOutLineY - 48,
					MainActivity.moOutLineX + 190,
					MainActivity.moOutLineY -48,
					
					MainActivity.moOutLineX+138, MainActivity.moOutLineY-10, 
					MainActivity.moOutLineX+15, MainActivity.moOutLineY+53,
					MainActivity.moOutLineX+41, MainActivity.moOutLineY+81,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY+158,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					MainActivity.moOutLineX+145, MainActivity.moOutLineY-25,
					
					MainActivity.moOutLineX+159, MainActivity.moOutLineY-8, 
					MainActivity.moOutLineX+220, MainActivity.moOutLineY+21, 
					MainActivity.moOutLineX+238, MainActivity.moOutLineY+88, 
					MainActivity.moOutLineX+190, MainActivity.moOutLineY+98, 
					
					MainActivity.moOutLineX+1, MainActivity.moOutLineY-70,
					MainActivity.moOutLineX+1, MainActivity.moOutLineY-70
					); 
			
//			LetterStructureBo.createNumberSpriteAndCursor();
		}
		//Outline of letter TalibaSha
		else if(MainActivity.letter == 7)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mTalibaShaOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
				MainActivity.OutLine.setScale((float)0.9);
				MainActivity.mScene.attachChild(MainActivity.OutLine);
					
				//MonkeyTutorial start 
				MonkeyTutorial.monkeyTutorialstart(3,
						MainActivity.moOutLineX - 33,
						MainActivity.moOutLineY - 25,
						MainActivity.moOutLineX + 50,
						MainActivity.moOutLineY -19,
						
						MainActivity.moOutLineX + 50,MainActivity.moOutLineY -19,
						MainActivity.moOutLineX+13, MainActivity.moOutLineY+74, 
						MainActivity.moOutLineX+57, MainActivity.moOutLineY+21,
						MainActivity.moOutLineX+90, MainActivity.moOutLineY+78,
						MainActivity.moOutLineX+65, MainActivity.moOutLineY+1,
						MainActivity.moOutLineX+114, MainActivity.moOutLineY-22,
						MainActivity.moOutLineX+163, MainActivity.moOutLineY+26,
						MainActivity.moOutLineX+163, MainActivity.moOutLineY-25,
						MainActivity.moOutLineX+163, MainActivity.moOutLineY+200, 
						
						MainActivity.moOutLineX+163, MainActivity.moOutLineY-25, 
						MainActivity.moOutLineX+180, MainActivity.moOutLineY-25, 
						MainActivity.moOutLineX+180, MainActivity.moOutLineY-25,
						MainActivity.moOutLineX+180, MainActivity.moOutLineY-25,
						
						MainActivity.moOutLineX+1, MainActivity.moOutLineY-70,
						MainActivity.moOutLineX+1, MainActivity.moOutLineY-70
						); 
					
//				LetterStructureTalibaSha.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Lo
		else if(MainActivity.letter == 8)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-60,
					MainActivity.mLoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
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
					
				LetterStructureLo.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Po
		else if(MainActivity.letter == 9)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mPoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
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
					
				LetterStructurePo.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Go
		else if(MainActivity.letter == 10)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mGoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
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
					
				LetterStructureGo.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Ho
		else if(MainActivity.letter == 11)
		{
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-110,
					MainActivity.mHoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
				MainActivity.OutLine.setScale((float)0.8);
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
					
				LetterStructureHo.createNumberSpriteAndCursor(); 
		}
		//Outline of letter Kho
		else if(MainActivity.letter == 12)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-80,
					MainActivity.mKhoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureKho.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter Cho
		else if(MainActivity.letter == 13)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mChoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			 
			LetterStructureCho.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter No
		else if(MainActivity.letter == 14)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mNoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureNo.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter A
		else if(MainActivity.letter == 15)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mAOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureA.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter Do
		else if(MainActivity.letter == 16)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mDoOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureDo.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter U
		else if(MainActivity.letter == 17)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mUOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureU.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter To
		else if(MainActivity.letter == 18)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-100,
					MainActivity.mToOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			 
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureTo.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter Toh
		else if(MainActivity.letter == 19)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-100,
					MainActivity.mTohOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			 
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureToh.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter Doh
		else if(MainActivity.letter == 20)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mDohOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			 
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureDoh.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter Ukar
		else if(MainActivity.letter == 21)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mUkarOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScale((float)0.9);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			 
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureUkar.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter Ekar
		else if(MainActivity.letter == 22)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mEkarOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScaleX((float)0.8);
			MainActivity.OutLine.setScaleY((float)0.7);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			 
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureEkar.createNumberSpriteAndCursor(); 
			
		}
		//Outline of letter Akar
		else if(MainActivity.letter == 23)
		{
			
			MainActivity.OutLine = new Sprite(MainActivity.moOutLineX-70, MainActivity.moOutLineY-70,
					MainActivity.mAkarOutLineTextureRegion, MainActivity.vertexBufferObjectManager);
			MainActivity.OutLine.setScaleX((float)0.8);
			MainActivity.OutLine.setScaleY((float)0.7);
			MainActivity.mScene.attachChild(MainActivity.OutLine);
			 
			//MonkeyTutorial start 
//			MonkeyTutorial.monkeyTutorialstart(
//					MainActivity.moOutLineX - 10,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX + 180,
//					MainActivity.moOutLineY - 20,
//					MainActivity.moOutLineX+10, MainActivity.moOutLineY-15, 
//					MainActivity.moOutLineX+80, MainActivity.moOutLineY+70,
//					MainActivity.moOutLineX+70, MainActivity.moOutLineY+120,
//					MainActivity.moOutLineX+30, MainActivity.moOutLineY+140,
//					MainActivity.moOutLineX, 	MainActivity.moOutLineY+110,
//					MainActivity.moOutLineX+20, MainActivity.moOutLineY+80,
//					MainActivity.moOutLineX+90, MainActivity.moOutLineY+90,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY+160,
//					MainActivity.moOutLineX+150, MainActivity.moOutLineY);
			
			
			LetterStructureAkar.createNumberSpriteAndCursor(); 
			
		}
	}
	
}
