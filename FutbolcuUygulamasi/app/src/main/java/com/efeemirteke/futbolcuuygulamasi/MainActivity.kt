package com.efeemirteke.futbolcuuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adapterview.view.*

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener{
     val futbolcuInfo=ArrayList<futbolcu>()
     val arraylist= arrayListOf<String>()
     lateinit var adapter:recyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bilgileriYerlestir()
        searchView.background=getDrawable(R.color.black)
        val layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager=layoutManager
        adapter=com.efeemirteke.futbolcuuygulamasi.recyclerView(futbolcuInfo,this)
        recyclerView.adapter=adapter
        searchView.setOnQueryTextListener(this)
    }
    fun bilgileriYerlestir(){
        val ulke= arrayOf(R.drawable.uruguay,R.drawable.fransa,R.drawable.danimarka,R.drawable.turkiye,
            R.drawable.fransa,R.drawable.uruguay,R.drawable.portekiz,R.drawable.turkiye,R.drawable.belcika,
            R.drawable.kosova,R.drawable.fransa
        )
        val uzunYazi= arrayOf("2011 yılında Lazio'dan ayrılarak Galatasaray'ın kapısından girdi. Zoran Simoviç, Faryd Mondragon, Claudio Taffarel gibi onun da Galatasaray'da efsane olacağını düşünenlerin sayısı hiç de az değildi. Beklentileri boşa çıkarmadı. Muslera teker teker kupaları kaldırmakla kalmadı; yabancı oyuncular kategorisinde rekora çoktan koşmaya başladı... Toplamda kazandığı 14 kupa ile Galatasaray formasıyla en çok kupa sevinci yaşayan yabancı oyuncu olarak zirvede bulunuyor. \n" +
                "\n" +
                "Fernando Muslera 2011-12, 2012-13,2014-15, 2017-18, 2018-19 sezonlarında lig şampiyonluğu yaşayan kadronun kalesindeydi. 2012, 2013, 2015, 2016 ve 2019 Süper Kupa finallerinde; 2013-14, 2014-15, 2015-16, 2018-19 sezonlarında Türkiye Kupası kaldırılırken kaledeki isim Uruguaylı yıldız isimden başkası değildi... 2013 ve 2014 Süper Kupa, 2013-14 Türkiye Kupası ve 2015-16 Türkiye Kupası finallerinde gol yemeden maçları tamamlayan Muslera; toplamda 14 kupaya ulaştı.\n" +
                "\n" +
                "Muslera, 6 Şubat 2017’de 3-2 kazanılan Antalyaspor maçıyla birlikte Galatasaray tarihinin \"En çok forma giyen yabancı futbolcusu\" oldu. Beşiktaş maçıyla birlikte Zoran Simoviç'in 188 maçlık rekorunu egale eden Nando, derbi öncesi efsane kalecinin elinden onur ödülü almıştı.\n" +
                "\n" +
                "14 Haziran 2020'de deplasmanda oynadığımız Çaykur Rizespor müsabakasında kaval kemiği kırılğı sakatlığıyla uzun süre kalesinden uzak kalan Fernando Muslera, 220 gün aradan sonra Süper Lig 2020-2021 Sezonu'ndaki Denizlispor maçında sahaya çıktı. Fernando Muslera, bu maçta üst üste 10 sezon aynı takım formasıyla Süper Lig maçına çıkan ilk yabancı oyuncu olarak Türk futbol tarihine adını bir kez daha yazdırdı.\n" +
                "\n" +
                "Uruguay Milli Takımı formasıyla dalyaya ulaşan ve yıllarca başarıyla milli takımının kalesinde yer alan file bekçimiz, 2010 yılında Copa America şampiyonu olan takımın kalesini koruyordu.","14 Eylül 1994 yılında Fransa’nın Segré bölgesinde dünyaya gelen Dubois, 2000 yılında başladığı futbol yaşamında 2009’da Nantes’a geçiş yaparak önemli bir adım attı. Nantes akademisinde yetişen ve 2014 yılında A takıma yükselen Fransız sağ bek, dört sezon Nantes ile Ligue 1 forması giydi. 106 maçta 4 gol ve 13 asistle Nantes kariyerini noktaladı. \n" +
                "\n" +
                "2018 yaz transfer sezonunda sözleşmesinin bitimiyle Olympique Lyon’a transferi kariyerinde dönüm noktası oldu. Burada performansını artıran 27 yaşındaki futbolcu, Didier Deschamps tarafından Fransa A Milli Takımı’na davet edildi. 2021’de Uluslar Ligi şampiyonu olan Fransa’nın İspanya ile oynadığı finalin son 10 dakikasında forma şansı buldu. Milli formayı 13 kez sırtına geçirdi. \n" +
                "\n" +
                "Lyon’da dört sezonda 129 maça çıkan oyuncu, 5 gol ve 15 asistlik performans ortaya koydu.","4 Ekim 1998 yılında Danimarka’nın Hornbæk şehrinde dünyaya gelen Nelsson, ülkesinin Nordsjælland takımının altyapısında futbol yaşamına başladı. Stoper mevkisinde oynayan ve 1.85 metre boyundaki Nelsson, Nordsjælland’da A takıma yükselerek burada 98 resmi maç oynadı ve 2 gole imza attı.\n" +
                "\n" +
                "Buradaki başarılı performansının ardından 2019-2020 yaz transfer sezonunda Danimarka’nın en gözde kulüplerinden Kopenhag’a 3,6 milyon Euro bonservis bedeli karşılığında transfer oldu.\n" +
                "\n" +
                "Kopenhag’da 87 müsabakada boy gösteren Nelsson, Şampiyonlar Ligi’nde 5, UEFA Avrupa Ligi’nde 15 maçta forma giydi.\n" +
                "\n" +
                "Danimarka Milli Takımı’nın alt yaş kategorilerinde forma giyen 22 yaşındaki futbolcu, 35 maç oynadığı U21 takımının kaptanıydı. 11 Kasım 2020 tarihinde Danimarka’nın İsveç ile oynadığı hazırlık maçında A Milli Takım’da ilk defa yer almanın gururunu yaşadı.\n" +
                "\n" +
                "Nelsson 2021-2022 sezonundan bu yana Galatasaray forması giymektedir.","Kariyerine Zonguldakspor altyapısında başlayan oyuncumuz, Konyaspor altyapısına transfer oldu. Selçukluspor, Adana Demirspor, Samsunspor, Giresunspor, Denizlispor ve Altay gibi kulüplerde kiralık olarak forma giyen Bardakcı, 2020-2021 Süper Lig sezonunda kulübü Konyaspor’a dönerek sezonu burada geçirdi. \n" +
                "\n" +
                "Stoper mevkisinde forma giyen 27 yaşındaki futbolcu, Türkiye Milli Takımı’nın alt yaş klasmanlarında 26 kez forma giydi. \n" +
                "\n" +
                "Geride bıraktığımız sezonda Konyaspor formasıyla Süper Lig’de 33 maça çıkan başarılı savunmacı, 5 gol ve 3 asistle takımına katkıda bulundu. Ziraat Türkiye Kupası’nda da bir maçta forma giyen futbolcu, bu tek maçta bir asist yaptı.  \n" +
                "\n" +
                "Abdülkerim Bardakcı, 2022-2023 yaz transfer sezonunda Galatasaray'a katıldı.","2000 yılında Fransa’nın Montreuil şehrinde doğan Boey, futbolculuk kariyerine Rennes altyapısında başladı. Kamerun asıllı Fransız futbolcu Rennes B Takımı’nda forma giydikten sonra yükselişini sürdürerek A takımda şans buldu.\n" +
                "\n" +
                "2019-2020 sezonunda 5 lig, 2 Avrupa Ligi ve bir Fransa Lig Kupası maçında şans bulan Boey bir gol ve bir asistlik performans ortaya koydu. Sağ bek bölgesinde forma giyen Boey, geçtiğimiz sezon ise Fransa Ligue 1’de 26 maçta forma giydi ve bir asist yaptı.\n" +
                "\n" +
                "Sacha Boey, Fransa Milli Takımı alt yaş kategorilerinde U17, U18 ve U20 takımlarında da forma giydi.\n" +
                "\n" +
                "Boey,  2021-2022 sezonundan bu yana Galatasaray forması giymektedir.","1 Şubat 1996’da Uruguay’da Fray Bentos kentinde doğan oyuncu, 18 de Julio ve Montevideo Wanderers gibi ülke kulüplerinde yetişirken 2013-14 sezonunda Pescara altyapısına giderek İtalya kariyerine adım attı. \n" +
                "\n" +
                "Serie B’de yer alan ekipte ilk maçına 16 Mayıs 2015’te Varese karşısında ilk 11’de çıktı. Buradaki performansıyla dikkat çeken oyuncu Sampdoria tarafından 1,5 milyon Euro transfer bedeliyle alındı; ancak Pescara’ya A takım tecrübesi kazanması için kiralık gönderildi. Pescara’da totalde 63 müsabakada yer aldı ve 8 gol kaydetti.\n" +
                "\n" +
                "2016-17 sezonunda Sampdoria’ya döndü ve Serie A’ya adım attı ve kısa sürede kendisini kabul ettirerek takımın kilit oyuncularından biri oldu.  Sampdoria’da gösterdiği üstün performansla asıl sıçrayışını yaptı. 74 maçta 4 gol, 2 asistlik performansla İtalya serüvenine bir virgül koydu ve İngiltere Premier Lig devi Arsenal’a yaklaşık 29 milyon Euro bonservis bedeliyle transfer oldu.\n" +
                "\n" +
                "Arsenal’da bir sezon geçirdikten sonra ertesi sezon Atletico Madrid’e, ardından da Fiorentina ile anlaşarak İtalya’ya geri döndü. Fiorentina’da 35 maçta 5 gol ve 2 asistlik performans ortaya koyan başarılı ön libero, Arsenal’a sezon sonu dönüşünün ardından Galatasarayımıza katıldı. \n" +
                "\n" +
                "Uruguay’da ilk A Milli maçına 23 Mart 2018 yılında Çek Cumhuriyeti ile oynanan hazırlık maçında çıktı ve 39 kez milli formayı terletti.\n" +
                "\n" +
                "Lucas Torreira, 8 Ağustos 2022 tarihinde kendisini Galatasaray'a bağlayan sözleşmeye imza attı.","Sergio Oliveira, 2 Haziran 1992 tarihinde Portekiz'in Santa Maria da Feira'ya bağlı Paços de Brandão beldesinde dünyaya geldi.\n" +
                "\n" +
                "Futbol kariyerine, doğduğu yerin amatör takımlarından Clube Desportivo Paços de Brandão'da başlayan Sergio Oliveira; 2002 yılında ise Portekiz'in en köklü kulüplerinden olan Porto'nun altyapısına transfer edildi.\n" +
                "\n" +
                "İlk profesyonel imzasını da 2010 yılında Porto'ya atan başarılı orta saha, deneyim kazanması amacıyla kiralık olarak gönderildi. Portekiz'de Beira-Mar, Penafiel, Paços Ferreira, Belçika'da KV Mechelen, Fransa'da FC Nantes, Yunanistan'da PAOK ve İtalya'da Roma formalarını giyen Oliveira, Serie A ekibi ile UEFA Konferans Ligi'nde şampiyonluğa ulaştı\n" +
                "\n" +
                "8 ve 6 numara olarak görev yapabilen 30 yaşındaki oyuncu kariyeri boyunca çıktığı 350 resmi müsabakada; 63 gol ve 31 asiste imza attı.\n" +
                "\n" +
                "Geçtiğimiz sezonu Serie A ekiplerinden Roma'da tamamlayan Oliveira, İtalyan ekibinde 22 resmi maçta forma giyerken; 3 gol attı ve 1 gol pası verdi.\n" +
                "\n" +
                "Portekiz milli takımının da formasını giyen deneyimli orta saha, ulusal takımıyla bugüne dek 13 müsabakaya çıkarken; 1 asistlik skor katkısı yaptı.\n" +
                "\n" +
                "Sergio Oliveira, 2022-2023 yaz transfer sezonunda Galatasaray'a katıldı.","21 Ekim 1998 yılında Kocaeli'nde doğan Muhammed Kerem Aktürkoğlu, kariyerine Gölcükspor'da başladı. 2014 yılında Hisareyn'e, 2015 yılınd Medipol Başakşehir'in altyapısına transfer olan futbolcu, 2016 yılında BB Bodrumspor'da bir sezon kiralık forma giydi. Başakşehir Kulübü'ndeki macerası 2018 senesinde biten oyuncu ardından Karacabey Belediyespor'da, geride bıraktığımız 2019-2020 sezonunda ise 24 Erzincanspor'da top koşturdu.\n" +
                "\n" +
                "Burada yakaladığı muhteşem çıkışla adından söz ettiren Kerem Aktürkoğlu, 3. Lig 1. Grup'ta çıktığı 28 maçta 17 kez fileleri sarstı. Kerem Aktürkoğlu, 2019-2020 sezonunda çıktığı toplam 34 resmi maçta 20 kez fileleri havalandırma başarısını gösterdi.\n" +
                "\n" +
                "21 yaşındaki futbolcu Türkiye Milli Takımı'nın U18 ve U19 kategorilerinde de forma giydi. Galatasaray'da ilk sezonunda gösterdiği başarılı performansın ardından Türkiye A Milli Takımı'nın Euro 2020 kafilesine davet edildi; ancak bu turnuvada forma giymedi. 27 Mayıs 2020 tarihinde Azerbaycan ile oynanan dostluk maçında ilk defa A Milli formayı giyme onurunu yaşadı. \n" +
                "\n" +
                "Muhammed Kerem Aktürkoğlu 2020-2021 sezonundan bu yana Galatasaray forması giymektedir.","6 Mayıs 1987’de Belçika’nın Leuven şehrinde doğan Mertens, futbol hayatına doğduğu kentin yerel kulüplerinden Stade Leuven’de başladı. Gent altyapısında futbolculuk yeteneklerini geliştiren oyuncu, Hollanda yolunu tutarak ikinci lig ekiplerinden Eendrach Aalst ve AGOVV’daki performanslarıyla rüştünü kanıtladı. Kiralık olarak gittiği AGOVV’da 2008 yılında ligin en iyi oyuncusu seçildi.\n" +
                "\n" +
                "Hollanda’da kariyerine devam eden Belçikalı hücum oyuncusu, Utrecht’te performansını artırarak büyük sıçramasını 2011-2012 sezonunda PSV Eindhoven’a transfer olarak yaptı. Burada golcü özelliğini konuşturmaya başlayan Mertens, PSV formasıyla 62 maçta 37 kez fileleri sarstı. PSV kariyerini çıktığı 88 müsabakada 45 gol ve 43 asist gibi dikkat çekici bir performansla noktaladı ve Çizme’nin yolunu tuttu. \n" +
                "\n" +
                "Kariyer basamaklarını bir bir tırmanmaya devam eden Belçikalı yıldız, 2013-14 yaz transfer sezonunda kariyerinin büyük bölümünü geçireceği Napoli’ye 10 milyon Euro bonservisle transfer oldu. \n" +
                "\n" +
                "Dokuz yıl boyunca Serie A’da Napoli forması giyen Mertens, 397 maçta kaydettiği 148 gol ve 47 asistlik performansıyla Napoli efsanesi Diego Armando Maradona’yı geçerek İtalyan kulübünde en çok gol atan isim olarak adını tarihe yazdı. \n" +
                "\n" +
                "İlk kez 2010 yılında Belçika A Milli Takımı’nda şans bulan yıldız oyuncu, 100 maçta 20 kez fileleri sarstı. 2018 Dünya Kupası’nda elemelerle birlikte kaydettiği 5 golle adından çokça söz ettirdi.","28 Haziran 1996’da Kosova’nın Vushtrri kentinde doğan oyuncu, Kosova Vushtrri’de futbol hayatına adım attı. \n" +
                "\n" +
                "2015 yılında Hollanda’nın Vitesse ekibine giderek vitrin yapan Rashica, 100 maçta 15 gol ve 24 asistlik performansıyla dikkat çekti ve ilk büyük transferini Bundesliga ekiplerinden Werder Bremen’e giderek yaptı. \n" +
                "\n" +
                "Almanlar onu 8.1 milyon Euro bonservis bedeliyle kadrosuna kattı. Bremen ekibinde 2,5 sezon geçiren Kosova asıllı Arnavut futbolcu Bundesliga’da 87 maçta 21 gol ve 17 asistle dikkat çekti. Werder Bremen kariyerini İngiltere Premier Lig hayaliyle sona erdiren Rashica, 30 maça çıktığı Norwich City’de bir kez golle buluşabildi. \n" +
                "\n" +
                "Kanatlarda ve forvet arkasında forma giyebilen 26 yaşındaki hücum oyuncusu, Kosova A Milli Takımı’nın formasını 43 kez sırtına geçirdi ve 8 gol kaydetti.","6 Ağustos 1985 doğumlu olan Bafetimbi Gomis, Fransa’nın güneydoğusunda bulunan sahil kasabası La Seyne’de dünyaya geldi. \n" +
                "\n" +
                "Futbola 1994 yılında Sporting Toulon’da başlayan Gomis, 2000 yılında transfer olduğu Saint Etienne altyapısında gelişimine devam etti ve yakaladığı çıkışla ilk A takımı tecrübesini burada yaşadı.   \n" +
                "\n" +
                "Fransa’da St. Etienne, Lyon, Marsilya gibi önemli kulüplerde başarılı performanslar ortaya koyan Gomis, ilk yurt dışı tecrübesini Swansea City’de yaşasa da kariyerinin ilklerini Galatasaray’da deneyimledi. \n" +
                "\n" +
                "Şampiyonluk ipini göğüslediğimiz 2017-2018 sezonunda 29 kez fileleri sarsarak gol kralı olan Bafetimbi Gomis, aynı zamanda kariyerindeki ilk şampiyonluk ve ilk gol krallığını Galatasaray’da yaşadı. Gösterdiği bu performansla Süper Lig’de bir sezonda bir takımla en fazla gol atan yabancı oyuncu unvanını Fenerbahçeli Alex de Souza’nın (28) elinden alan Fransız santrfor, bu istatistiğiyle kulüp tarihine geçti.   \n" +
                "\n" +
                "Galatasaray’da yaşadığı muhteşem bir yılın ardından taraftarın da sevgilisi olan Bafe, ardında unutulmaz hatıralar bırakarak Suudi Arabistan’ın Al Hilal takımına transfer oldu. \n" +
                "\n" +
                "Al Hilal formasıyla 3,5 yıl boyunca üstün bir performans ortaya koyan yıldız oyuncu, çıktığı 147 maçta 107 gol ve 16 asistlik performans sergiledi. 3,5 yılda Suudi Profesyonel Ligi tarihinin en golcü dördüncü futbolcusu oldu. Bu sezon ise 17 maçta 9 kez fileleri sarsarak formda olduğunu bir kez daha gösterdi. Gomis, 2021-2022 ara transfer döneminde Galatasaray formasına yeniden kavuştu.\n" +
                "\n" +
                "Gomis 2021-2022 yarım sezonda 14 maçta 9 kez fileleri sarstı.")
        val oyuncular= arrayOf(R.drawable.muslera1,R.drawable.dubois2,R.drawable.nellson3,R.drawable.abdulkerim4,
            R.drawable.boey5,R.drawable.torreira6,R.drawable.oliveira7,R.drawable.kerem8,R.drawable.mertens9,R.drawable.rashica10,R.drawable.gomis11)
        val futbolcuBilgi=resources.getStringArray(R.array.futbolcuIsim)
        val futbolcuMevki=resources.getStringArray(R.array.mevki)
        for(i in 0..futbolcuBilgi.size-1){
            val futbolcu=futbolcu(futbolcuBilgi.get(i),uzunYazi[i],futbolcuMevki.get(i),oyuncular[i],ulke[i])
            futbolcuInfo.add(futbolcu)
        }
    }
    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }
    override fun onQueryTextChange(p0: String?): Boolean {
        val myArrayList=ArrayList<futbolcu>()
        for(i in futbolcuInfo){
            val isim=i.isim.lowercase()
            if(isim.contains(p0.toString().lowercase())){
                myArrayList.add(i)
            }
            adapter.bilgiSorgula(myArrayList)
        }
        return true
    }

}