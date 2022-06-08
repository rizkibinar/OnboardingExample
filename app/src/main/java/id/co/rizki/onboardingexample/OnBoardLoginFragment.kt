package id.co.rizki.onboardingexample

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class OnBoardLoginFragment : Fragment() {

    lateinit var etName : EditText
    lateinit var btnSend : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_on_board_login, container, false)

        etName = view.findViewById(R.id.et_name)
        btnSend = view.findViewById(R.id.btn_send)

        btnSend.setOnClickListener {
            val namaUser = etName.text.toString()

            val intentToHome = Intent(requireActivity(), HomeActivity::class.java)
            intentToHome.putExtra("DATA_USER_NAME", namaUser)
            startActivity(intentToHome)
        }


        // Inflate the layout for this fragment
        return view
    }

}