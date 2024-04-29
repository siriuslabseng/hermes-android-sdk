package com.hermes.caustic.core

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.hermes.caustic.databinding.MainViewBinding
import java.lang.ref.WeakReference

open class HermesManager private constructor (var activity: WeakReference<Activity>, private var widgetSlug: String, var hermesPublicKey: String, private var parentGroup: WeakReference<ConstraintLayout>) {

    companion object {
        @Volatile
        private var instance: HermesManager? = null

        @Synchronized
        fun getInstance(activity: Activity, widgetSlug: String, hermesPublicKey: String, parentGroup: ConstraintLayout): HermesManager {
            if (instance == null) {
                instance = HermesManager(WeakReference(activity), widgetSlug, hermesPublicKey, WeakReference(parentGroup))
            }

            return instance!!
        }
    }

    init {
        setUpMainChangelogView()
        createAllShelters()
        setOnClickListeners()
    }

    private lateinit var activityMainViewBinding : MainViewBinding

    private fun setUpMainChangelogView()  {
        val inflater: LayoutInflater = LayoutInflater.from(activity.get()).context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        activityMainViewBinding = MainViewBinding.inflate(inflater)
        activityMainViewBinding.root.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,  ConstraintLayout.LayoutParams.MATCH_PARENT)
        activityMainViewBinding.root.visibility = View.GONE
        activityMainViewBinding.root.setOnApplyWindowInsetsListener { _, windowInsets ->
            val statusBarSize = windowInsets.systemWindowInsetTop
            val navBarSize = windowInsets.systemWindowInsetBottom
//            val param = activityMainViewBinding.topView.layoutParams as ViewGroup.MarginLayoutParams
//            param.setMargins(0, statusBarSize,0, 0)
//            activityMainViewBinding.topView.layoutParams = param
//
//            val bottomParam = activityMainViewBinding.attribution.layoutParams as ViewGroup.MarginLayoutParams
//            bottomParam.setMargins(0, 0,0, navBarSize + 40)
//            activityMainViewBinding.attribution.layoutParams = bottomParam

            //val statusHeightParam = activityMainViewBinding.statusBar.layoutParams as ViewGroup.MarginLayoutParams
            //activityMainViewBinding.statusBar.layoutParams = ViewGroup.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, statusBarSize)

            windowInsets
        }

        parentGroup.get()?.addView(activityMainViewBinding.root)
    }

    private fun createAllShelters(){

    }

    private fun setOnClickListeners(){

    }

    fun handleBackStack(){

    }

    fun showChangelogView(){
        activityMainViewBinding.root.visibility = View.VISIBLE
    }

}