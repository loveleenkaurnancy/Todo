package com.kitkat.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.kitkat.todo.model.AuthModel

class CustomPagerAdapter(private val mContext: Context) : PagerAdapter() {

    private val TAG = this::class.java.simpleName


    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val modelObject = AuthModel.values()[position]
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(modelObject.layoutResId, collection, false) as ViewGroup


        if (position == 0)
        {


//            edt_password = layout.findViewById(R.id.edt_password)
//
//            layout.txt_login.setOnClickListener{
//
//                linearLayout_login = layout.findViewById(R.id.linearLayout_login)
//                val input_email_name = layout.emailorusername.text
//                val input_password_login = layout.edt_password.text
//
//                if (Validations.validateForLogin(input_email_name.toString(), input_password_login.toString(),
//                        linearLayout_login))
//                {
//                    //DialogBox.showLoader(mContext)
//                    DialogBox.showLoginLoader2()
//                    requestForLogin(input_email_name.toString(), input_password_login.toString(),token)
//                }
//
//            }
//
//            layout.eye.setOnClickListener{
//                manageVisibilityOfPassword()
//            }
//
//            forget = layout.findViewById(R.id.forget)
//            forget.setOnClickListener(){
//
//                val intent = Intent(mContext, ForgotActivity::class.java)
//                mContext.startActivity(intent)
//            }

        } else if (position == 1) {

//            edt_password1 = layout.findViewById(R.id.edt_password1)
//            edt_repassword = layout.findViewById(R.id.edt_repassword)
//
//            ccp = layout.findViewById(R.id.ccp)
//            if(!(countryCode.equals("")))
//            {
//                ccp.setCountryForNameCode(countryCode)
//            }
//
//            layout.txt_signup.setOnClickListener() {
//
//                val input_name = layout.edt_name.text
//                val input_email = layout.edt_email.text
//                val input_mobile = layout.edt_mobile.text
//                val input_password = layout.edt_password1.text
//                val input_re_password = layout.edt_repassword.text
//                val input_ccp = ccp.selectedCountryCode
//                linearLayout = layout.findViewById(R.id.linearLayout)
//
//                if (Validations.validateForSignUp(input_name.toString(), input_email.toString(),
//                        input_password.toString(), input_re_password.toString(), input_mobile.toString(), linearLayout))
//                {
//                    DialogBox.showLoginLoader2()
//                    attemptToSignup(input_name.toString(), input_email.toString(), input_mobile.toString(),
//                        input_password.toString(), input_ccp.toString())
//                }
//            }
//
//            layout.eye1.setOnClickListener{
//                manageVisibilityOfPassword1()
//            }
//
//            layout.eye2.setOnClickListener{
//                manageVisibilityOfPassword2()
//            }

        }

        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return AuthModel.values().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence {
        val customPagerEnum = AuthModel.values()[position]
        return mContext.getString(customPagerEnum.titleResId)
    }

}