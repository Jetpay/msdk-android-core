package kz.jetpay.msdk.core.android.card

import android.os.Bundle
import android.widget.Toast
import com.paymentpage.msdk.core.domain.interactors.pay.card.sale.SavedCardSaleRequest
import kz.jetpay.msdk.core.android.App
import kz.jetpay.msdk.core.android.PayBaseActivity
import kz.jetpay.msdk.core.android.R

class SavedCardSaleActivity : PayBaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_card_sale)

        val savedCards = App.getMsdkSession().getSavedAccounts()
        if (savedCards.isNullOrEmpty()) {
            Toast
                .makeText(applicationContext, "Not found any saved cards", Toast.LENGTH_LONG)
                .show()
            finish()
            return
        }
        progressDialog.show()

        //SavedCardSaleRequest - sale with saved card
        //SavedCardAuthRequest - auth with saved card

        interactor.execute(
            SavedCardSaleRequest(
                cvv = "123",
                accountId = savedCards.first().id
            ),
            this
        )
    }
}