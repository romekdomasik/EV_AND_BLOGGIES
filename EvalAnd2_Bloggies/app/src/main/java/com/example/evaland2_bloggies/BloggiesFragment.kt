package com.example.evaland2_bloggies

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.evaland2_bloggies.databinding.FragmentBloggiesBinding

class BloggiesFragment : Fragment() {

    private lateinit var binding: FragmentBloggiesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentBloggiesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnInscription = binding.btnInscriptionBloggies
        val email = binding.editTextEmailBloggies.text
        val login = binding.editTextLoginBloggies.text
        val motDePasse = binding.editTextPasswordBloggies.text
        val conf = binding.editTextConfirmationBloggies.text


        btnInscription.setOnClickListener {
            if (motDePasse.isBlank()) {
                showAlertDialog("le mot de passe ne doit pas être vide")
            } else if (login.isBlank()) {
                showAlertDialog("le login ne doit pas être vide")
            } else if (motDePasse.toString() != conf.toString()) {
                showAlertDialog("les mots de passe doivent correspondre")
            } else if (!email.contains('@')){
                showAlertDialog("verifier votre mail")
            } else {
                findNavController().navigate(BloggiesFragmentDirections.actionBloggiesFragmentToBloCoFragment(" bienvenue ${login.toString()}"))
            }


        }
    }

    private fun showAlertDialog(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle("ERREUR")
        alertDialogBuilder.setMessage("$message").show()
    }
}
