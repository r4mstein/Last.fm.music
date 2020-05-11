package com.r4mste1n.main.artist_info

import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.chip.Chip
import com.r4mste1n.R
import com.r4mste1n.root.base.BaseActivity
import com.r4mste1n.root.base.BaseView
import com.r4mste1n.root.extensions.ImageTransformType
import com.r4mste1n.root.extensions.convertDpToPix
import com.r4mste1n.root.extensions.formatCount
import com.r4mste1n.root.extensions.loadImage
import kotlinx.android.synthetic.main.fr_artist_info.view.*


/**
 * Created by Alex Shtain on 25.04.2020.
 */
class ArtistInfoView : BaseView<Contract.Presenter>(), Contract.View {

    override fun setupUI() {
        (context as BaseActivity).setToolbarTitle(
            context?.getString(R.string.artist_info_toolbar_title) ?: ""
        )
    }

    override fun setArtistPhoto(link: String) {
        rootView?.ivPhoto?.loadImage(url = link, transformType = ImageTransformType.CircleCrop)
    }

    override fun setArtistName(name: String) {
        rootView?.tvName?.text = name
    }

    override fun setArtistTags(tags: List<String>) {
        tags.forEach { tag ->
            rootView?.llTagsContainer?.addView(getTagChip(tag))
        }
    }

    private fun getTagChip(tag: String) = Chip(context).apply {
        text = tag
        setChipBackgroundColorResource(R.color.red_500_alpha_100)
        setTextColor(ContextCompat.getColor(context, android.R.color.white))

        context?.let {
            textSize = 16f
            typeface = ResourcesCompat.getFont(context, R.font.firasans_regular)
            layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                setMargins(
                    context.convertDpToPix(4).toInt(),
                    0,
                    context.convertDpToPix(4).toInt(),
                    0
                )
            }
        }
    }

    override fun setHearersCount(count: String) {
        rootView?.tvHearersCount?.text =
            context?.resources?.getString(R.string.listeners, count.formatCount())
    }

    override fun setPlayCount(count: String) {
        rootView?.tvPlayCount?.text =
            context?.resources?.getString(R.string.play_count, count.formatCount())
    }

    override fun setBio(bio: String) {
        rootView?.tvBio?.text = bio
    }

    override fun setBioPublished(date: String) {
        rootView?.tvPublished?.text = context?.resources?.getString(R.string.published, date)
    }

}