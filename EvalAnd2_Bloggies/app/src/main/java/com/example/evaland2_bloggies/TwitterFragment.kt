package com.example.evaland2_bloggies

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.evaland2_bloggies.databinding.FragmentTwitterBinding


class TwitterFragment : Fragment() {

    private lateinit var binding: FragmentTwitterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTwitterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnConfirmation = binding.btnConnexion
        val pwd = binding.editTextPassword.text
        val mail = binding.editTextMail.text

        btnConfirmation.setOnClickListener {
            if (pwd.isNotBlank() && mail.isNotBlank() && mail.contains('@')) {
                findNavController().navigate(TwitterFragmentDirections.actionTwitterFragmentToConnectedTwitterFragment())
            } else {
                AlertDialog.Builder(context)
                    .setTitle("Erreur")
                    .setMessage("Veuillez remplir tout les champs et veiller à entrer un email valide")
                    .show()

            }
        }
    }
}
