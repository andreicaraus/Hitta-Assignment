package com.hitta.android.assignment.common.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import com.hitta.android.assignment.utils.Constants

class SimpleDialogFragment : DialogFragment() {

    private var listener: DialogButtonListener? = null

    companion object {
        fun newInstance(title: String, message: String, button: String): SimpleDialogFragment {
            val bundle = Bundle()
            bundle.putString(Constants.DIALOG_TITLE_KEY, title)
            bundle.putString(Constants.DIALOG_MESSAGE_KEY, message)
            bundle.putString(Constants.DIALOG_BUTTON_KEY, button)
            val dialogFragment = SimpleDialogFragment()
            dialogFragment.arguments = bundle
            return dialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments?.getString(Constants.DIALOG_TITLE_KEY)
        val message = arguments?.getString(Constants.DIALOG_MESSAGE_KEY)
        val button = arguments?.getString(Constants.DIALOG_BUTTON_KEY)

        val alertDialogBuilder = AlertDialog.Builder(context!!)
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton(button) { dialog, _ ->
            dialog?.dismiss()
            listener?.onPositiveButtonPressed()
        }

        return alertDialogBuilder.create()
    }

    override fun onDestroy() {
        super.onDestroy()
        listener = null
    }

    fun setListener(listener: DialogButtonListener) {
        this.listener = listener
    }
}