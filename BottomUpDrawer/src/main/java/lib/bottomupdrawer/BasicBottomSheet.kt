package lib.bottomupdrawer

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.jetbrains.annotations.NotNull

class BasicBottomSheet private constructor() {
    class Begin(@NotNull private val activity: AppCompatActivity) {
        private val bottomSheetBehavior = BottomSheetBehavior.from(activity.findViewById<ConstraintLayout>(R.id.bottomLayout))
        private val titleLayout: FrameLayout = activity.findViewById<FrameLayout>(R.id.TitleContainer)
        private val contentsLayout: FrameLayout = activity.findViewById<FrameLayout>(R.id.ContentsContainer)
        private val titleParams = titleLayout.layoutParams as ViewGroup.MarginLayoutParams
        private val contentsParams = contentsLayout.layoutParams as ViewGroup.MarginLayoutParams

        fun hide(isHide: Boolean) : Begin {
            bottomSheetBehavior.isHideable = isHide
            return this
        }

        fun peekHeight(dp: Int) : Begin {
            bottomSheetBehavior.peekHeight = dp.dp
            return this
        }

        fun addTitle(fragment: Fragment) : Begin {
            activity.supportFragmentManager
                .beginTransaction()
                .add(R.id.TitleContainer, fragment)
                .commit()
            return this
        }

        fun addContents(fragment: Fragment) : Begin {
            activity.supportFragmentManager
                .beginTransaction()
                .add(R.id.ContentsContainer, fragment)
                .commit()
            return this
        }

        fun titleMargin(left:Int, top:Int, right:Int, bottom:Int) {
            titleParams.setMargins(left.dp, top.dp, right.dp, bottom.dp)
        }

        fun contentsMargin(left:Int, top:Int, right:Int, bottom:Int) {
            contentsParams.setMargins(left.dp, top.dp, right.dp, bottom.dp)
        }

        fun addCallBack(callback : BottomSheetBehavior.BottomSheetCallback) : Begin {
            bottomSheetBehavior.addBottomSheetCallback(callback)
            return this
        }

        fun commit() = BasicBottomSheet()
    }
}