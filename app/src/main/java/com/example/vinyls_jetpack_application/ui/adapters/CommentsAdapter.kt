package com.example.vinyls_jetpack_application.ui.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.vinyls_jetpack_application.R
import com.example.vinyls_jetpack_application.databinding.AlbumItemBinding
import com.example.vinyls_jetpack_application.models.Album
import com.example.vinyls_jetpack_application.models.Comment

class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>() {

    var comments: Album? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val withDataBinding: AlbumItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CommentViewHolder.LAYOUT,
            parent,
            false
        )
        return CommentViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.album = comments
        }
    }

    override fun getItemCount(): Int {
        return 1
    }

        class CommentViewHolder(val viewDataBinding: AlbumItemBinding) :
            RecyclerView.ViewHolder(viewDataBinding.root) {
            companion object {
                @LayoutRes
                val LAYOUT = R.layout.album_item
            }
        }
}
