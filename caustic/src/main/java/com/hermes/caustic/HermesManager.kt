package com.hermes.caustic

import android.app.Activity
import androidx.constraintlayout.widget.ConstraintLayout
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

}