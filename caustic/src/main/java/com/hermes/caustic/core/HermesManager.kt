package com.hermes.caustic.core

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.customview.widget.ViewDragHelper.Callback
import com.hermes.caustic.core.api.models.FetchChangelogResponse
import com.hermes.caustic.core.managers.NetworkManager
import com.hermes.caustic.databinding.MainViewBinding
import com.hermes.caustic.ui.shelters.ChangelogListShelter
import com.hermes.caustic.ui.shelters.LoadingViewShelter
import retrofit2.Call
import retrofit2.Response
import java.lang.ref.WeakReference

open class HermesManager private constructor ( var activity: WeakReference<Activity>, private var widgetSlug: String, private var hermesPublicKey: String, private var parentGroup: WeakReference<ConstraintLayout>) {

    private var networkManager = NetworkManager()

    private lateinit var activityMainViewBinding : MainViewBinding
    private lateinit var changelogListShelter : ChangelogListShelter
    private lateinit var loadingViewShelter: LoadingViewShelter

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



    private fun setUpMainChangelogView()  {
        val inflater: LayoutInflater = LayoutInflater.from(activity.get()).context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        activityMainViewBinding = MainViewBinding.inflate(inflater)
        activityMainViewBinding.root.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,  ConstraintLayout.LayoutParams.MATCH_PARENT)
        activityMainViewBinding.root.visibility = View.GONE
        activityMainViewBinding.root.setOnApplyWindowInsetsListener { _, windowInsets ->
            val statusBarSize = windowInsets.systemWindowInsetTop
            val navBarSize = windowInsets.systemWindowInsetBottom
//            val param = activityMainViewBinding.topBanner.layoutParams as ViewGroup.MarginLayoutParams
//            param.setMargins(0, statusBarSize,0, 0)
            //activityMainViewBinding.topBanner.layoutParams = param
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
        changelogListShelter = ChangelogListShelter(this, activityMainViewBinding.changelogList)
        loadingViewShelter = LoadingViewShelter(this, activityMainViewBinding.loadingView)
    }

    private fun setOnClickListeners(){
        activityMainViewBinding.closeButton.setOnClickListener {
            hideChangelogView()
        }
    }

    private fun hideChangelogView(){
        activityMainViewBinding.root.visibility = View.GONE
    }

    fun changeReactions(){

    }

    fun handleBackStack(){
        hideChangelogView()
    }

    fun showChangelogView(){
        activityMainViewBinding.root.visibility = View.VISIBLE
        fetchChangelogs()
    }



    private fun showLoader(){
        loadingViewShelter.showShelter()
    }

    private fun hideLoader(){
        loadingViewShelter.hideShelter()
    }

    private fun fetchChangelogs(){
        networkManager.fetchChangelogs(hermesPublicKey, widgetSlug).enqueue(object :
            retrofit2.Callback<FetchChangelogResponse> {
            override fun onResponse(call: Call<FetchChangelogResponse>, response: Response<FetchChangelogResponse>) {
                if (response.isSuccessful) {
                    // Handle the retrieved post data
                    val post = response.body()
                     post?.data?.let {

                         changelogListShelter.setData(it.changelogs)
                         changelogListShelter.showShelter()
                    }
                    hideLoader()
                } else {
                    // Handle error
                    hideLoader()
                }
            }
            override fun onFailure(call: Call<FetchChangelogResponse>, t: Throwable) {
                // Handle failure
                hideLoader()
            }
        })
    }

}