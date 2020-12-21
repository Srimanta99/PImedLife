package com.pimedlife.pimedlife.screen.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.pimedlife.pimedlife.R
import com.pimedlife.pimedlife.screen.home.HomeActivity
import com.wecompli.utils.sheardpreference.AppSheardPreference
import com.wecompli.utils.sheardpreference.PreferenceConstent


class LoginActivity : AppCompatActivity() {
    var mGoogleSignInClient: GoogleSignInClient? = null
    var view:View?=null
    var logInViewBind:LogInViewBind?=null
    var logInOnClick:LogInOnClick?=null
    private val RC_SIGN_IN = 234
    private val TAG = "google login"
    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view=LayoutInflater.from(this).inflate(R.layout.activity_login, null)
        setContentView(view)
        logInViewBind= LogInViewBind(this, view!!);
        logInOnClick= LogInOnClick(this, logInViewBind!!)
        mAuth = FirebaseAuth.getInstance();
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    public fun signIn() {
        //getting the google signin intent
        val signInIntent = mGoogleSignInClient!!.signInIntent
        //starting the activity for result
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //if the requestCode is the Google Sign In code that we defined at starting
        if (requestCode == RC_SIGN_IN) {

            //Getting the GoogleSignIn Task
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                //Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)

                //authenticating with firebase
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.id)
        //getting the auth credential
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        //Now using firebase we are signing in the user here
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(this,
                OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithCredential:success")
                        val user: FirebaseUser = mAuth!!.getCurrentUser()!!
                        AppSheardPreference(this).setvalue_in_preference(PreferenceConstent.username_key,user.displayName.toString())
                        AppSheardPreference(this).setvalue_in_preference(PreferenceConstent.useremail_key,user.email.toString())
                        AppSheardPreference(this).setvalue_in_preference(PreferenceConstent.user_phone,user.phoneNumber.toString())
                       // Toast.makeText(this, "User Signed In", Toast.LENGTH_SHORT).show()
                        AppSheardPreference(this).setvalue_in_preference(PreferenceConstent.iS_LOGIN,"true")

                        val homeintent=Intent(this,HomeActivity::class.java)
                        homeintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(homeintent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.exception)
                        Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }

                    // ...
                })
    }
    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
        //Toast.makeText(this, "User Signed In", Toast.LENGTH_SHORT).show()
    }

}