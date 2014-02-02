package Animation;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.AlphaModifier;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.modifier.IModifier;

import com.example.iwrite.MainActivity;

public class HandTutorial
{

	public static void handTutorialCreate()
	{
		MainActivity.handTutorial = new Sprite(500, 400, MainActivity.mHandTutorialTextureRegion, 
				MainActivity.vertexBufferObjectManager);
		MainActivity.mScene.attachChild(MainActivity.handTutorial);
		MainActivity.handTutorial.setAlpha(0);
		
		AlphaModifier alphaMod = new AlphaModifier((float) 0.8, (float) 0, 1);
		DelayModifier delayMod = new DelayModifier((float) 0.00, new IEntityModifierListener()
		{ 

					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) 
					{

					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						handTutorialStart(MainActivity.handTutorial.getX(), 
								MainActivity.handTutorial.getY(),
								MainActivity.bookIcon.getX()+70, 
								MainActivity.bookIcon.getY()+70);
					}
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(alphaMod ,delayMod);
		MainActivity.handTutorial.registerEntityModifier(sequenceMod);
	}
	
	public static void handTutorialStart(float x1, float y1, float x2, float y2)
	{
		MoveModifier moveMod = new MoveModifier(2, x1, x2, y1, y2);
		DelayModifier delayMod = new DelayModifier((float) 2, new IEntityModifierListener()
		{  

					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) 
					{

					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						
					}
				});
		
		SequenceEntityModifier sequenceMod = new SequenceEntityModifier(delayMod,moveMod);
		LoopEntityModifier loopMod = new LoopEntityModifier(sequenceMod);
		
		MainActivity.handTutorial.registerEntityModifier(loopMod);
	}
}
