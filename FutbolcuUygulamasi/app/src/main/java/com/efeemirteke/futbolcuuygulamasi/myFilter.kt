package com.efeemirteke.futbolcuuygulamasi

import android.widget.Filter

class myFilter(var arrayList: ArrayList<futbolcu>,val adapter:recyclerView):Filter(){
    override fun performFiltering(p0: CharSequence?): FilterResults {
        val veri=p0.toString().lowercase()
        val sonuc=FilterResults()
        val myArrayList=ArrayList<futbolcu>()
        if(veri.length>0){
            for(i in arrayList){
                val isim=i.isim.lowercase()
                if(isim.contains(veri)){
                    myArrayList.add(i)
                }
            }
            sonuc.count=myArrayList.size
            sonuc.values=myArrayList
        }
        else{
            sonuc.values=arrayList
            sonuc.count=arrayList.size
        }
        return sonuc
    }

    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
        val sonuc=p1?.values
        adapter.bilgiSorgula(sonuc as ArrayList<futbolcu>)
    }
}