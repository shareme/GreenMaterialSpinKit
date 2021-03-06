/*
 Copyright ybq 2016
 Modifications Copyright(C) 2016 Fred Grott(GrottWorkShop)

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	    http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

 */
package com.github.shareme.greenmaterialspinkit.library.style;

import android.animation.ValueAnimator;

import com.github.shareme.greenmaterialspinkit.library.animation.SpriteAnimatorBuilder;
import com.github.shareme.greenmaterialspinkit.library.sprite.CircleSprite;
import com.github.shareme.greenmaterialspinkit.library.sprite.CircleSpriteGroup;
import com.github.shareme.greenmaterialspinkit.library.sprite.Sprite;


/**
 * Created by ybq.
 */
@SuppressWarnings("unused")
public class FadingCircle extends CircleSpriteGroup {

    @Override
    public Sprite[] onCreateChild() {
        Dot[] dots = new Dot[12];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new Dot();
            dots[i].setAnimationDelay(100 * i);
        }
        return dots;
    }

    class Dot extends CircleSprite {

        @Override
        public ValueAnimator getAnimation() {
            float fractions[] = new float[]{0f, 0.4f, 1f};
            return new SpriteAnimatorBuilder(this).
                    alpha(fractions, 0, 255, 0).
                    duration(1200).
                    easeInOut(fractions).build();
        }
    }
}
