package com.hitta.android.assignment.common.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog

/**
 * Dialog that contains a title, a message and one button
 */
class SimpleDialogFragment : DialogFragment() {

    private var listener: DialogButtonListener? = null

    companion object {

        private const val DIALOG_TITLE_KEY = "DIALOG_TITLE_KEY"

        private const val DIALOG_MESSAGE_KEY = "DIALOG_MESSAGE_KEY"

        private const val DIALOG_BUTTON_KEY = "DIALOG_BUTTON_KEY"

        fun newInstance(title: String, message: String, button: String): SimpleDialogFragment {
            val bundle = Bundle()
            bundle.putString(DIALOG_TITLE_KEY, title)
            bundle.putString(DIALOG_MESSAGE_KEY, message)
            bundle.putString(DIALOG_BUTTON_KEY, button)
            val dialogFragment = SimpleDialogFragment()
            dialogFragment.arguments = bundle
            return dialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments?.getString(DIALOG_TITLE_KEY)
        val message = arguments?.getString(DIALOG_MESSAGE_KEY)
        val button = arguments?.getString(DIALOG_BUTTON_KEY)

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