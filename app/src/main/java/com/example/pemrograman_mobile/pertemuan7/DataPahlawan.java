package com.example.pemrograman_mobile.pertemuan7;

import java.util.ArrayList;

public class DataPahlawan {
    private static String[] dataNama = {
            "Ahmad Dahlan",
            "Ahmad Yani",
            "Mohammad Hatta",
            "Soekarno",
            "Tan Malaka"
    };

    private static String[] dataDesk = {
            "Salah seorang ulama dan khatib terkemuka di Masjid Besar Kasultanan Yogyakarta pada masa itu, dan ibu dari K.H. Ahmad Dahlan adalah puteri dari H. Ibrahim yang juga menjabat penghulu Kesultanan Ngayogyakarta Hadiningrat pada masa itu. KH. Ahmad Dahlan telah mempelopori kebangkitan ummat Islam untuk menyadari nasibnya sebagai bangsa terjajah yang masih harus belajar dan berbuat.",
            "Jenderal TNI Anumerta Ahmad Yani (juga dieja Achmad Yani; lahir di Purworejo, Jawa Tengah, 19 Juni 1922 – meninggal di Lubang Buaya, Jakarta, 1 Oktober 1965 pada umur 43 tahun) adalah komandan Tentara Nasional Indonesia Angkatan Darat, dan dibunuh oleh anggota Gerakan 30 September saat mencoba untuk menculik dia dari rumahnya.",
            "Dr.(HC) Drs. H. Mohammad Hatta (lahir dengan nama Mohammad Athar, dikenal sebagai Bung Hatta; lahir di Fort de Kock (sekarang Bukittinggi, Sumatera Barat), Hindia Belanda, 12 Agustus 1902 – meninggal di Jakarta, 14 Maret 1980 pada umur 77 tahun) adalah tokoh pejuang, negarawan, ekonom, dan juga Wakil Presiden Indonesia yang pertama. Ia bersama Soekarno memainkan peranan penting untuk memerdekakan bangsa Indonesia dari penjajahan Belanda sekaligus memproklamirkannya pada 17 Agustus 1945. Ia juga pernah menjabat sebagai Perdana Menteri dalam Kabinet Hatta I, Hatta II, dan RIS. Ia mundur dari jabatan wakil presiden pada tahun 1956, karena berselisih dengan Presiden Soekarno. Hatta juga dikenal sebagai Bapak Koperasi Indonesia.",
            "Dr.(H.C.) Ir. H. Soekarno (ER, EYD: Sukarno, nama lahir: Koesno Sosrodihardjo) (lahir di Surabaya, Jawa Timur, 6 Juni 1901 – meninggal di Jakarta, 21 Juni 1970 pada umur 69 tahun) adalah Presiden pertama Republik Indonesia yang menjabat pada periode 1945–1967. Ia memainkan peranan penting dalam memerdekakan bangsa Indonesia dari penjajahan Belanda. Ia adalah Proklamator Kemerdekaan Indonesia (bersama dengan Mohammad Hatta) yang terjadi pada tanggal 17 Agustus 1945. Soekarno adalah yang pertama kali mencetuskan konsep mengenai Pancasila sebagai dasar negara Indonesia dan ia sendiri yang menamainya.",
            "Tan Malaka atau Ibrahim gelar Datuk Sutan Malaka (lahir di Nagari Pandam Gadang, Suliki, Lima Puluh Kota, Sumatera Barat, 2 Juni 1897 – meninggal di Desa Selopanggung, Kediri, Jawa Timur, 21 Februari 1949 pada umur 51 tahun) adalah seorang pembela kemerdekaan Indonesia, tokoh Partai Komunis Indonesia, juga pendiri Partai Murba, dan merupakan salah satu Pahlawan Nasional Indonesia."
    };

    private static String[] dataFoto = {
            "https://moondoggiesmusic.com/wp-content/uploads/2019/02/KH-Ahmad-Dahlan.jpg",
            "https://moondoggiesmusic.com/wp-content/uploads/2019/02/Ahmad-Yani.jpg",
            "https://moondoggiesmusic.com/wp-content/uploads/2019/02/Mohammad-Hatta.jpg",
            "https://moondoggiesmusic.com/wp-content/uploads/2019/02/Ir.-Soekarno.jpg",
            "https://moondoggiesmusic.com/wp-content/uploads/2019/02/Tan-Malaka.jpg"

    };


    public static ArrayList<PojoClass> getListData() {
        ArrayList<PojoClass> listPahlawan = new ArrayList<>();
        for (int i = 0; i < dataNama.length; i++) {
            PojoClass p = new PojoClass();
            //isi setter dengan data array
            p.setNama(dataNama[i]);
            p.setDeskripsi(dataDesk[i]);
            p.setFoto(dataFoto[i]);
            //memasukkan data yg sudah di set ke dlm arraylist
            listPahlawan.add(p);
        }

        return listPahlawan;
    }
}