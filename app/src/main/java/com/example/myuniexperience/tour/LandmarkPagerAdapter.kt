package com.example.myuniexperience.tour

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myuniexperience.R
import com.example.myuniexperience.model.Landmark

class LandmarkPagerAdapter(
    private val landmarks: List<Landmark>
) : RecyclerView.Adapter<LandmarkPagerAdapter.LandmarkViewHolder>() {

    inner class LandmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val ivLandmark: ImageView = itemView.findViewById(R.id.ivLandmark)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_landmark, parent, false)
        return LandmarkViewHolder(view)
    }

    override fun onBindViewHolder(holder: LandmarkViewHolder, position: Int) {
        val landmark = landmarks[position]
        holder.tvTitle.text = landmark.title
        holder.ivLandmark.setImageResource(landmark.imageRes)
        holder.tvDescription.text = landmark.description
    }

    override fun getItemCount(): Int = landmarks.size
}