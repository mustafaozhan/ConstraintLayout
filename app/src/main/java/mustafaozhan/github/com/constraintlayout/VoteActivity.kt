package mustafaozhan.github.com.constraintlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_vote.*


class VoteActivity : AppCompatActivity() {
    private var constraintLayout: ConstraintLayout? = null
    private val applyConstraintSet = ConstraintSet()
    private val resetConstraintSet = ConstraintSet()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote)

        constraintLayout = findViewById(R.id.main) as ConstraintLayout
        resetConstraintSet.clone(constraintLayout)
        applyConstraintSet.clone(constraintLayout)

        var default = true
        img.setOnClickListener {

            default = if (default) {
                applyEffect()
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

    private fun applyEffect() {
        TransitionManager.beginDelayedTransition(constraintLayout)

        applyConstraintSet.clear(R.id.img)
        applyConstraintSet.connect(R.id.img, ConstraintSet.LEFT, R.id.main, ConstraintSet.LEFT, 0)
        applyConstraintSet.connect(R.id.img, ConstraintSet.RIGHT, R.id.main, ConstraintSet.RIGHT, 0)
        applyConstraintSet.connect(R.id.img, ConstraintSet.TOP, R.id.main, ConstraintSet.TOP, 0)
        applyConstraintSet.connect(R.id.img, ConstraintSet.BOTTOM, R.id.main, ConstraintSet.BOTTOM, 0)
        applyConstraintSet.applyTo(constraintLayout)
    }

    override fun onBackPressed() {
        finish()
    }
}
