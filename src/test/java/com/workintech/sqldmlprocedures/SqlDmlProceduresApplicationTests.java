package com.workintech.sqldmlprocedures;

import com.workintech.sqldmlprocedures.entity.Kitap;
import com.workintech.sqldmlprocedures.entity.Ogrenci;
import com.workintech.sqldmlprocedures.entity.Tur;
import com.workintech.sqldmlprocedures.entity.Yazar;
import com.workintech.sqldmlprocedures.repository.KitapRepository;
import com.workintech.sqldmlprocedures.repository.OgrenciRepository;
import com.workintech.sqldmlprocedures.repository.TurRepository;
import com.workintech.sqldmlprocedures.repository.YazarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ExtendWith(ResultAnalyzer.class)
class SqlDmlProceduresApplicationTests {
    private final KitapRepository kitapRepository;
    private final OgrenciRepository ogrenciRepository;
    private final TurRepository turRepository;
    private final YazarRepository yazarRepository;

    @Autowired
    public SqlDmlProceduresApplicationTests(KitapRepository kitapRepository, OgrenciRepository ogrenciRepository,
                                            TurRepository turRepository, YazarRepository yazarRepository) {
        this.kitapRepository = kitapRepository;
        this.ogrenciRepository = ogrenciRepository;
        this.turRepository = turRepository;
        this.yazarRepository = yazarRepository;
    }

    @DisplayName("Biyografi turunu tur tablosuna ekleyiniz.")
    @Test
    void findTurTest() {
        Tur tur = turRepository.findByAd("Biyografi");
        assertNotNull(tur);
        assertEquals("Biyografi", tur.getAd());
    }

    @DisplayName("Nurettin Belek isimli yazari yazar tablosuna ekleyiniz.")
    @Test
    void findYazarTest() {
        Yazar yazar = yazarRepository.findByAd("Nurettin");
        assertNotNull(yazar);
        assertEquals("Nurettin", yazar.getAd());
        assertEquals("Belek", yazar.getSoyad());
    }

    @DisplayName("10B sinifindaki ogrencileri 10C sinifina gecirin.")
    @Test
    void findOgrenciBySinifTest() {
        List<Ogrenci> ogrenciList = ogrenciRepository.findBySinif("10C");
        assertNotNull(ogrenciList);
        assertEquals(2, ogrenciList.size());
    }

    @DisplayName("Tum kitaplarin puanini 5 puan arttiriniz.")
    @Test
    void findBookPointTest() {
        List<Kitap> kitapList = kitapRepository.findAll();
        assertEquals(27, kitapList.get(0).getPuan());
    }

    @DisplayName("Adi Mehmet olan tum yazarlari silin.")
    @Test
    void findNullYazarTest() {
        Yazar yazar = yazarRepository.findByAd("Mehmet");
        assertNull(yazar);
    }

    @DisplayName("Kisisel Gelisim isimli bir tur olusturun.")
    @Test
    void findNewTurTest() {
        Tur tur = turRepository.findByAd("Kisisel Gelisim");
        assertNotNull(tur);
        assertEquals(7L, tur.getTurno());
    }

    @DisplayName("'Benim Universitelerim' isimli kitabin turunu 'Kisisel Gelisim' yapin.")
    @Test
    void checkBookTurTest() {
        Tur tur = turRepository.findByAd("Kisisel Gelisim");
        Kitap kitap = kitapRepository.findByAd("Benim Universitelerim");
        assertEquals(tur.getTurno(), kitap.getTurno());
    }

    @DisplayName("Ogrenci tablosunu kontrol etmek amacli tum ogrencileri goruntuleyen 'ogrencilistesi' adinda bir fonksiyon olusturun.")
    @Test
    void callOgrenciListesiTest() {
        List<Ogrenci> ogrenciList = ogrenciRepository.findAllOgrenci();
        assertNotNull(ogrenciList);
        assertEquals(10, ogrenciList.size());
    }

    @DisplayName("kitap tablosuna yeni kitap eklemek icin 'ekle' adinda bir prosedur olusturun.")
    @Test
    void callEkleTest() {
        kitapRepository.addNewKitap("Alice in the Wonderland", 100, 1, 1);
        Kitap kitap = kitapRepository.findByAd("Alice in the Wonderland");
        assertNotNull(kitap);
        kitapRepository.delete(kitap);
    }

    @DisplayName("Ogrenci noya gore ogrenci silebilmeyi saglayan 'sil' adinda bir prosedur olusturun.")
    @Test
    void removeOgrenciTest() {
        Ogrenci ogrenci = new Ogrenci();
        ogrenci.setAd("Test");
        ogrenci.setSoyad("Test");
        ogrenci.setCinsiyet("E");
        ogrenci.setPuan(50);
        ogrenci.setSinif("10A");
        ogrenciRepository.save(ogrenci);

        List<Ogrenci> ogrenciList = ogrenciRepository.findAllOgrenci();
        Ogrenci ogrenci1 = ogrenciList.stream()
                .filter(ogr -> ogr.getAd().equals("Test"))
                .collect(Collectors.toList())
                .get(0);

        ogrenciRepository.removeOgrenci(ogrenci1.getOgrno());

        ogrenciList = ogrenciRepository.findAllOgrenci();
        List<Ogrenci> testResult = ogrenciList.stream()
                .filter(ogr -> ogr.getAd().equals("Test"))
                .collect(Collectors.toList());

        assertEquals(0, testResult.size());
    }
}
