package com.example.eoffice.util

import android.content.Context
import android.widget.Toast

class Utilities {
    companion object{
        var mToast: Toast? = null

        fun showToast(context: Context?, text: String?){
            if (context != null) {
                mToast?.cancel()
                mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
                mToast?.show()
            }
        }
    }
}