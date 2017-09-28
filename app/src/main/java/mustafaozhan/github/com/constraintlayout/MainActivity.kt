package mustafaozhan.github.com.constraintlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var constraintLayout: ConstraintLayout? = null
    private val applyConstraintSet = ConstraintSet()
    private val resetConstraintSet = ConstraintSet()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constraintLayout = findViewById(R.id.main) as ConstraintLayout
        resetConstraintSet.clone(constraintLayout)
        applyConstraintSet.clone(constraintLayout)


        var default = true
        imgWallpaper.setOnClickListener {

            default = if (default) {
                fullScreenEffect(it.id)
                !default
            } else {
                resetEffect()
                !default
            }

        }
        imgLogo.setOnClickListener {

            default = if (default) {
                fullScreenEffect(it.id)
                !default

            } else {
                resetEffect()
                !default
            }

        }

    }

    private fun resetEffect() {

        TransitionManager.beginDelayedTransition(constraintLayout)
        resetConstraintSet.applyTo(constraintLayout)
    }

    private fun fullScreenEffect(id: Int) {
        hideOthers(id)
        TransitionManager.beginDelayedTransition(constraintLayout)
        applyConstraintSet.clear(id)
        applyConstraintSet.connect(id, ConstraintSet.LEFT, R.id.main, ConstraintSet.LEFT, 0)
        applyConstraintSet.connect(id, ConstraintSet.RIGHT, R.id.main, ConstraintSet.RIGHT, 0)
        applyConstraintSet.connect(id, ConstraintSet.TOP, R.id.main, ConstraintSet.TOP, 0)
        applyConstraintSet.connect(id, ConstraintSet.BOTTOM, R.id.main, ConstraintSet.BOTTOM, 0)

        applyConstraintSet.applyTo(constraintLayout)

    }

    private fun hideOthers(id: Int) {

        if (id == R.id.imgWallpaper)
            applyConstraintSet.setVisibility(R.id.imgLogo, ConstraintSet.GONE)
        else
            applyConstraintSet.setVisibility(R.id.imgWallpaper, ConstraintSet.GONE)


        applyConstraintSet.setVisibility(R.id.btnCancel, ConstraintSet.GONE)
        applyConstraintSet.setVisibility(R.id.btnVote, ConstraintSet.GONE)

        applyConstraintSet.setVisibility(R.id.txtInformation, ConstraintSet.GONE)
        applyConstraintSet.setVisibility(R.id.txtName, ConstraintSet.GONE)
        applyConstraintSet.setVisibility(R.id.txtNameResult, ConstraintSet.GONE)
        applyConstraintSet.setVisibility(R.id.txtRelease, ConstraintSet.GONE)
        applyConstraintSet.setVisibility(R.id.txtReleaseResult, ConstraintSet.GONE)


    }
}
