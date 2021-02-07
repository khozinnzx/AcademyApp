package com.example.academy.ui.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.academy.R
import com.example.academy.data.CourseEntity
import com.example.academy.databinding.FragmentBookmarkBinding
import com.example.academy.utils.DataDummy

class BookmarkFragment : Fragment(), BookmarkFragmentCallback {

    lateinit var binding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[BookmarkViewModel::class.java]
            val course = viewModel.getBookmarks()
            val adapter = BookmarkAdapter(this)
            adapter.setCourse(course)

            with(binding.rvBookmark){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(course: CourseEntity) {
       if (activity != null){
           val mimeType = "text/plain"
           ShareCompat.IntentBuilder
               .from(requireActivity())
               .setType(mimeType)
               .setChooserTitle("Bagikan aplikasi ini sekarang.")
               .setText(resources.getString(R.string.share_text, course.title))
               .startChooser()
       }
    }
}