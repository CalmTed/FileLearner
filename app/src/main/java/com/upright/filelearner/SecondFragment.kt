package com.upright.filelearner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.allViews
import androidx.core.view.get
import androidx.fragment.app.createViewModelLazy
import androidx.navigation.fragment.findNavController
import com.upright.filelearner.databinding.FragmentSecondBinding
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Paths

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fun drawScore(num: String){
            if (container != null) {
                println(container.id )
//                println(container.getChildAt(0).id)
//                val textField: TextView? = container.removeAllViews()
//                if(textField != null) {
//                    textField.text = num
//                }

            }
                println( "asd" )
        }
//        println(getAllFilesInResources())

        drawScore("Just text")

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getAllFilesInResources()
    {
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val resourcesPath = Paths.get(projectDirAbsolutePath, "")
        val paths = Files.walk(resourcesPath)
            .filter { item -> Files.isRegularFile(item) }
            .filter { item -> item.toString().endsWith(".txt") }
            .forEach { item -> println("filename: $item") }
    }

}