package zhupff.gadget.gradle

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.toBitmap
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private val logo: AppCompatImageView by lazy {
        AppCompatImageView(this).also {
            it.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT)
            it.scaleType = ImageView.ScaleType.FIT_CENTER
        }
    }

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(logo)

        val drawable = AppCompatResources.getDrawable(this, R.mipmap.ic_launcher)
        val bitmap = drawable!!.toBitmap(256, 256, Bitmap.Config.ARGB_8888)
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, FileOutputStream(cacheDir.resolve("logo.png")))

        logo.setImageBitmap(bitmap)
    }
}