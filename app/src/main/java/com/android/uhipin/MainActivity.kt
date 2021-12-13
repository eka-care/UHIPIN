package com.android.uhipin

import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.android.uhilibrary.PinManager

// Below is demo activity of Application which will be using uhi library common for all client applications
class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        var itemLayout = findViewById<RelativeLayout>(R.id.itemLayout)
        var txtApprove = findViewById<TextView>(R.id.ctaApprove)

        PinManager.init(this)

        itemLayout.setOnClickListener {
            if(txtApprove.text.equals("Approve"))
            {
                PinManager.verifyPin(this,startForResult)
            }
        }


        //initUI()
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
            var txtApprove = findViewById<TextView>(R.id.ctaApprove)
            txtApprove.text = "Approved"
        } else {

        }
    }

}