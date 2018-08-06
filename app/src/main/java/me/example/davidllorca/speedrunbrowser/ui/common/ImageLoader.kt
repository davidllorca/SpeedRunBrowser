package me.example.davidllorca.speedrunbrowser.ui.common

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Helper class responsible for load images.
 *
 */
class ImageLoader {

    fun loadImage(uri: String?, target: ImageView) {
        Picasso.get()
                .load(uri)
                .into(target)
    }
}