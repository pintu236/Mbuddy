package com.indieme.mbuddy.view.ui.base

import android.os.Bundle
import android.widget.*
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.indieme.mbuddy.R
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {
    lateinit var mTextViewScreenTitle: TextView;
    lateinit var mImageButtonBack: ImageButton;
    lateinit var mProgressDialog: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mProgressDialog = ProgressDialog(this)
//        mProgressDialog.setMessage("Loading")
//        mProgressDialog.setCancelable(false)
//        mProgressDialog.isIndeterminate = true
    }

    override fun setContentView(layoutResID: Int) {

        var coordinatorLayout: CoordinatorLayout =
            layoutInflater.inflate(R.layout.activity_base, null) as CoordinatorLayout
        var activityContainer: FrameLayout = coordinatorLayout.findViewById(R.id.layout_container)
        mTextViewScreenTitle = coordinatorLayout.findViewById(R.id.tv_toolbar_title) as TextView
        mImageButtonBack = coordinatorLayout.findViewById(R.id.ib_back);

        layoutInflater.inflate(layoutResID, activityContainer, true)

        super.setContentView(coordinatorLayout)
    }

    //    fun showProgressDialog() {
//        if(!mProgressDialog.isShowing) {
//            mProgressDialog.show()
//        }
//    }
//
//    fun dismissProgressDialog() {
//        if (mProgressDialog.isShowing) {
//            mProgressDialog.dismiss()
//        }
//    }
    fun setScreenTitle(resId: Int) {
        mTextViewScreenTitle.text = getString(resId)
    }

    fun setScreenTitle(title: String) {
        mTextViewScreenTitle.text = title
    }

    fun getBackButton(): ImageButton {
        return mImageButtonBack;
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    fun showMessage(stringRes: Int) {
        Toast.makeText(this, getString(stringRes), Toast.LENGTH_SHORT).show()
    }
}