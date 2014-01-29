package com.example.iwrite;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;

public class AnimationTutorial 
{
	
	public static void animatedChalk2(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4,
			float x5, float y5, float x6, float y6, float x7, float y7, float x8, float y8,float x9, float y9,
			float x10, float y10, float x11, float y11, float x12, float y12, float x13,float y13, float x14, float y14,
			float x15, float y15, float x16, float y16)
	{
		Path chalkPath = null;
		
		chalkPath = new Path(16)
		.to(x1 , y1 ).to(x2, y2).to(x3, y3).to(x4, y4)
		.to(x5, y5).to(x6, y6).to(x7, y7).to(x8, y8)
		.to(x9, y9).to(x10, y10).to(x11, y11).to(x12, y12)
		.to(x13, y13).to(x14, y14).to(x15, y15).to(x16, y16)
		;
		
		MainActivity.rectangle.registerEntityModifier(new PathModifier((float)3.5, chalkPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{

			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{

			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{

			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{ 
			
			}
		}));
	}
	
	public static void animatedChalk1(float x1, float y1, float x2, float y2)
	{
		Path chalkPath = null;
		
		chalkPath = new Path(2)
		.to(x1, y1).to(x2, y2);
		
		MainActivity.rectangle.registerEntityModifier(new PathModifier((float)1.0, chalkPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				MainActivity.monkeyTutorialStart = 1;
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{

			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{

			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				
				MainActivity.monkeyTutorialStart = 0;
				
				AnimationTutorial.animatedChalk2(
						MainActivity.numberSprites[1].getX(), MainActivity.numberSprites[1].getY()+20, 
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+10,
						MainActivity.numberSprites[7].getX()+35, MainActivity.numberSprites[7].getY()+15,
						MainActivity.numberSprites[7].getX()+20, MainActivity.numberSprites[7].getY()+80, 
						MainActivity.numberSprites[7].getX()-80, MainActivity.numberSprites[7].getY()+60,
						MainActivity.numberSprites[7].getX()-100, MainActivity.numberSprites[7].getY()-15, 
						MainActivity.numberSprites[7].getX()-70, MainActivity.numberSprites[7].getY()-30, 
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+40, 
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+60, 
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+20, 
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+20, 
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+20, 
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+20, 
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+20, 
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+20,
						MainActivity.numberSprites[7].getX()+5, MainActivity.numberSprites[7].getY()+20);
			}
		}));
	}
}
