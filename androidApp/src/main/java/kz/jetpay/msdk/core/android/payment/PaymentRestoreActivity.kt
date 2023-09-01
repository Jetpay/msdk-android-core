package kz.jetpay.msdk.core.android.payment

import android.app.ProgressDialog
import android.os.Bundle
import com.paymentpage.msdk.core.domain.interactors.pay.restore.PaymentRestoreRequest
import kz.jetpay.msdk.core.android.PayBaseActivity
import kz.jetpay.msdk.core.android.R

class PaymentRestoreActivity : PayBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_restore)
        progressDialog = ProgressDialog(this@PaymentRestoreActivity)
        progressDialog.setMessage("Payment restoring")
        progressDialog.setCancelable(false)
        progressDialog.show()

        interactor.execute(PaymentRestoreRequest(), this)
    }

    override fun onDestroy() {
        super.onDestroy()
        interactor.cancel()
    }
}