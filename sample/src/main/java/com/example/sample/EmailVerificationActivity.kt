package com.example.sample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.example.sample.databinding.ActivityEmailVerificationBinding
import java.util.regex.Pattern

class EmailVerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_verification)
        val binding = ActivityEmailVerificationBinding.inflate(layoutInflater)

        binding.emailBtn.setOnClickListener{
            val email = binding.email.text
            binding.emailWarning.text = email
//            if(EmailSender(email).emailValidator()) {
//                sendEmail(email)
//            } else {
//                toastWarning("이메일 입력 오류")
//            }
//             and convert btn to '인증코드 재발송'
        }
    }
    private fun sendEmail(email: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("mailito:")
            putExtra(Intent.EXTRA_EMAIL, email)
            putExtra(Intent.EXTRA_SUBJECT, "코드 인증")
            putExtra(Intent.EXTRA_TEXT, "1234")
        }
        if(intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    private fun toastWarning(text: String) {
        val toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
        toast.show()
    }
}
class EmailSender(val email: String) {
    private val title = "인증 메일입니다."

    fun emailValidator(): Boolean {
//        val emailRegex = compile(
//            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
//                    "\\@" +
//                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
//                    "(" +
//                    "\\." +
//                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
//                    ")+"
//        )
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}