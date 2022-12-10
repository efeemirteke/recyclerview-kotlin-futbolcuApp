package com.efeemirteke.futbolcuuygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapterview.view.*

class recyclerView(var arrayList:ArrayList<futbolcu>,val context:Context):RecyclerView.Adapter<recyclerView.myViewHolder>(){
    override fun getItemCount(): Int {
       return arrayList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val inflater=LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.adapterview,parent,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val oankiFutbolcu=arrayList[position]
        holder.bilgileriYerlestir(oankiFutbolcu,position)
    }
    inner class myViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val futbolcuIsim:TextView
        val futbolcuMevki:TextView
        val futbolcuUlke:ImageView
        val futbolcuImg:ImageView
        init {
            this.futbolcuIsim=itemView.tvFutbolcuIsim
            this.futbolcuMevki=itemView.futbolcuMevki
            this.futbolcuImg=itemView.imgFutbolcu
            this.futbolcuUlke=itemView.imgFutbolcuUlke
        }
        fun bilgileriYerlestir(arrayList:futbolcu,position: Int){
            futbolcuIsim.text=arrayList.isim
            futbolcuMevki.text=arrayList.mevki
            futbolcuImg.setImageResource(arrayList.futbolcuImg)
            Glide.with(context).load(arrayList.futbolcuImg).into(futbolcuImg)
            Glide.with(context).load(arrayList.ulke).into(futbolcuUlke)
            itemView.setOnClickListener {
                val intent= Intent(context,DetailActivity::class.java)
                intent.putExtra("futbolcuImg",arrayList.futbolcuImg)
                intent.putExtra("futbolcuIsim",arrayList.isim)
                intent.putExtra("uzunYazi",arrayList.uzunYazi)
                context.startActivity(intent)
            }
        }
    }
    fun futbolcuIsimleri(){
        for(i in arrayList){
            println(i.isim)
        }
    }
    fun bilgiSorgula(arrayListGet:ArrayList<futbolcu>){
        arrayList=arrayListGet
        notifyDataSetChanged()
}
}