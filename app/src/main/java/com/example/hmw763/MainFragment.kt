package com.example.hmw763

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hmw763.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentMainBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lesson = Lessons(
            color = R.color.orange, textColor = R.color.green_two,
            lessonImage = "https://upload.wikimedia.org/wikipedia/commons/c/c3/Deus_mathematics.png"
        )
        binding.add.setOnClickListener {
            if (binding.lessonTitle.text.isEmpty()) {
                requireContext().showToast("Title can't be empty")
            } else {
                lesson.lessonName = binding.lessonTitle.text.toString()
                val fragment = LessonFragment()
                val bundle = Bundle()
                bundle.putSerializable("lesson", lesson)
                fragment.arguments = bundle
                requireActivity().replaceFragment(fragment)

            }
        }

        binding.backColor.setOnClickListener {
            showAlert("Change color",R.array.colors){
                val item = resources.getStringArray(R.array.colors)[it]
                binding.backColor.setText(item)
                when (it) {
                    0 -> {
                        lesson.color = R.color.red_two
                        binding.backColor.setText("Red")
                    }
                    1 -> {
                        lesson.color = R.color.green_two
                        binding.backColor.setText("Green")
                    }
                    2 -> {
                        lesson.color = R.color.orange_two
                        binding.backColor.setText("Orange")
                    }
                }
            }
        }

        binding.textColor.setOnClickListener {
            showAlert("Change color", R.array.colors){
                val item = resources.getStringArray(R.array.colors)[it]
                binding.textColor.setText(item)
                when (it) {
                    0 -> {
                        lesson.textColor = R.color.red_two
                        binding.textColor.setText("Red")
                    }
                    1 -> {
                        lesson.textColor = R.color.green_two
                        binding.textColor.setText("Green")
                    }
                    2 -> {
                        lesson.textColor = R.color.orange_two
                        binding.textColor.setText("Orange")
                    }
                }
            }

        }



    }

}
