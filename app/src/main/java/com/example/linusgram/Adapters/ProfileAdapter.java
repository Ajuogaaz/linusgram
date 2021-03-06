package com.example.linusgram.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.linusgram.Models.Post;
import com.example.linusgram.R;
import com.parse.ParseFile;

import org.w3c.dom.Text;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private final int CLASS_CODE;
    private Context context;
    private List<Post> posts;
    onClickListener clickListener;

    public static final int PROFILE_FRAGMENT_CODE = 22;

    public interface onClickListener{
        void onItemClicked(int position, int replyCode);
    }

    public ProfileAdapter(Context context, List<Post> posts, onClickListener clickListener, int CLASS_CODE) {
        this.context = context;
        this.posts = posts;
        this.clickListener = clickListener;
        this.CLASS_CODE = CLASS_CODE;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;

      if (CLASS_CODE == PROFILE_FRAGMENT_CODE){
            view = LayoutInflater.from(context).inflate(R.layout.item_user_post, parent, false);
        }

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);

    }

    public void clear(){
        posts.clear();
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder{

        ImageView ivImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);

        }

        public void bind(final Post post) {

            String postPic = post.getImage().getUrl();

            Glide.with(context)
                    .load(postPic)
                    .into(ivImage);



        }


    }
}
