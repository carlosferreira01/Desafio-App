package com.provatokenlab.extensions

import android.app.Activity
import com.provatokenlab.R


fun Activity.executeTransitionInOut(isTransitionOut: Boolean){
    if (isTransitionOut)
        overridePendingTransition(R.anim.anim_transition_right_in, R.anim.anim_transition_right_out)
    else
        overridePendingTransition(R.anim.anim_transition_left_in, R.anim.anim_transition_left_out)
}