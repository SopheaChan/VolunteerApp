package com.example.dell.valenteercontroller

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageSlideshowAdapter(context: Context): PagerAdapter() {
    private lateinit var inflater: LayoutInflater
    private val context: Context = context
    val imageList: IntArray =  intArrayOf(
        R.drawable.volunteer_image1,
        R.drawable.volunteer_image2,
        R.drawable.volunteer_image3
    )
    override fun isViewFromObject(p0: View, p1: Any): Boolean {
       return (p0==p1)
    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.image_layout, container, false)
        val img: ImageView = view.findViewById(R.id.image_layout)
//        img.setImageResource(images[position])
        //Set image to imageView using Glide, since Glide is faster than Picasso
        Glide.with(context).load(imageList[position]).into(img)
        //Add eventClickListener to each image
        img.setOnClickListener{
            Snackbar.make(img, "Images: " + (position + 1).toString(), 1000).show()
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

}