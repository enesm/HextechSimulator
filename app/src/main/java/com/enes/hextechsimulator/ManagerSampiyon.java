package com.enes.hextechsimulator;

import android.renderscript.Sampler;

import java.util.ArrayList;
import java.util.Random;

class ManagerSampiyon {
    private ArrayList<SampiyonKristali> samplerN1 = new ArrayList<SampiyonKristali>();
    private ArrayList<SampiyonKristali> samplerN2 = new ArrayList<SampiyonKristali>();
    private ArrayList<SampiyonKristali> samplerN3 = new ArrayList<SampiyonKristali>();
    private ArrayList<SampiyonKristali> samplerN4 = new ArrayList<SampiyonKristali>();
    private ArrayList<SampiyonKristali> samplerN5 = new ArrayList<SampiyonKristali>();
    private ArrayList<SampiyonKristali> samplerN6 = new ArrayList<SampiyonKristali>();
    private ArrayList<SampiyonKristali> samplerHepsi = new ArrayList<SampiyonKristali>();

    ManagerSampiyon() {
        // nadirlikId --> 1: 450IP - 2: 1350IP - 3: 3150IP - 4: 4800IP - 5: 6300IP - 6: 7800IP
        samplerHepsi.add(new SampiyonKristali(0, "Aatrox", 5));
        samplerHepsi.add(new SampiyonKristali(1, "Ahri", 4));
        samplerHepsi.add(new SampiyonKristali(2, "Akali", 3));
        samplerHepsi.add(new SampiyonKristali(3, "Alistar", 2));
        samplerHepsi.add(new SampiyonKristali(4, "Amumu", 1));
        samplerHepsi.add(new SampiyonKristali(5, "Anivia", 3));
        samplerHepsi.add(new SampiyonKristali(6, "Annie", 1));
        samplerHepsi.add(new SampiyonKristali(7, "Ashe", 1));
        samplerHepsi.add(new SampiyonKristali(8, "Aurelion Sol", 5));
        samplerHepsi.add(new SampiyonKristali(9, "Azir", 5));
        samplerHepsi.add(new SampiyonKristali(10, "Bard", 5));
        samplerHepsi.add(new SampiyonKristali(11, "Blitzcrank", 3));
        samplerHepsi.add(new SampiyonKristali(12, "Brand", 4));
        samplerHepsi.add(new SampiyonKristali(13, "Braum", 5));
        samplerHepsi.add(new SampiyonKristali(14, "Caitlyn", 4));
        samplerHepsi.add(new SampiyonKristali(15, "Camille", 5));
        samplerHepsi.add(new SampiyonKristali(16, "Cassiopeia", 4));
        samplerHepsi.add(new SampiyonKristali(17, "Cho'Gath", 2));
        samplerHepsi.add(new SampiyonKristali(18, "Corki", 2));
        samplerHepsi.add(new SampiyonKristali(19, "Darius", 4));
        samplerHepsi.add(new SampiyonKristali(20, "Diana", 4));
        samplerHepsi.add(new SampiyonKristali(21, "Dr.Mundo", 1));
        samplerHepsi.add(new SampiyonKristali(22, "Draven", 4));
        samplerHepsi.add(new SampiyonKristali(23, "Ekko", 5));
        samplerHepsi.add(new SampiyonKristali(24, "Elise", 4));
        samplerHepsi.add(new SampiyonKristali(25, "Evelynn", 2));
        samplerHepsi.add(new SampiyonKristali(26, "Ezreal", 4));
        samplerHepsi.add(new SampiyonKristali(27, "Fiddlesticks", 2));
        samplerHepsi.add(new SampiyonKristali(28, "Fiora", 4));
        samplerHepsi.add(new SampiyonKristali(29, "Fizz", 4));
        samplerHepsi.add(new SampiyonKristali(30, "Galio", 3));
        samplerHepsi.add(new SampiyonKristali(31, "Gangplank", 3));
        samplerHepsi.add(new SampiyonKristali(32, "Garen", 1));
        samplerHepsi.add(new SampiyonKristali(33, "Gnar", 5));
        samplerHepsi.add(new SampiyonKristali(34, "Gragas", 3));
        samplerHepsi.add(new SampiyonKristali(35, "Graves", 4));
        samplerHepsi.add(new SampiyonKristali(36, "Hecarim", 4));
        samplerHepsi.add(new SampiyonKristali(37, "Heimerdinger", 3));
        samplerHepsi.add(new SampiyonKristali(38, "Illaoi", 5));
        samplerHepsi.add(new SampiyonKristali(39, "Irelia", 4));
        samplerHepsi.add(new SampiyonKristali(40, "Ivern", 5));
        samplerHepsi.add(new SampiyonKristali(41, "Janna", 2));
        samplerHepsi.add(new SampiyonKristali(42, "Jarvan IV", 4));
        samplerHepsi.add(new SampiyonKristali(43, "Jax", 2));
        samplerHepsi.add(new SampiyonKristali(44, "Jayce", 4));
        samplerHepsi.add(new SampiyonKristali(45, "Jhin", 5));
        samplerHepsi.add(new SampiyonKristali(46, "Jinx", 5));
        samplerHepsi.add(new SampiyonKristali(47, "Kai'Sa", 5));
        samplerHepsi.add(new SampiyonKristali(48, "Kalista", 5));
        samplerHepsi.add(new SampiyonKristali(49, "Karma", 3));
        samplerHepsi.add(new SampiyonKristali(50, "Karthus", 3));
        samplerHepsi.add(new SampiyonKristali(51, "Kassadin", 3));
        samplerHepsi.add(new SampiyonKristali(52, "Katarina", 3));
        samplerHepsi.add(new SampiyonKristali(53, "Kayle", 1));
        samplerHepsi.add(new SampiyonKristali(54, "Kayn", 5));
        samplerHepsi.add(new SampiyonKristali(55, "Kennen", 4));
        samplerHepsi.add(new SampiyonKristali(56, "Kha'Zix", 4));
        samplerHepsi.add(new SampiyonKristali(57, "Kindred", 5));
        samplerHepsi.add(new SampiyonKristali(58, "Kled", 5));
        samplerHepsi.add(new SampiyonKristali(59, "Kog'Maw", 4));
        samplerHepsi.add(new SampiyonKristali(60, "Le'Blanc", 3));
        samplerHepsi.add(new SampiyonKristali(61, "Lee Sin", 4));
        samplerHepsi.add(new SampiyonKristali(62, "Leona", 4));
        samplerHepsi.add(new SampiyonKristali(63, "Lissandra", 5));
        samplerHepsi.add(new SampiyonKristali(64, "Lucian", 5));
        samplerHepsi.add(new SampiyonKristali(65, "Lulu", 4));
        samplerHepsi.add(new SampiyonKristali(66, "Lux", 3));
        samplerHepsi.add(new SampiyonKristali(67, "Malphite", 2));
        samplerHepsi.add(new SampiyonKristali(68, "Malzahar", 4));
        samplerHepsi.add(new SampiyonKristali(69, "Maokai", 4));
        samplerHepsi.add(new SampiyonKristali(70, "Master Yi", 1));
        samplerHepsi.add(new SampiyonKristali(71, "Miss Fortune", 3));
        samplerHepsi.add(new SampiyonKristali(72, "Mordekaiser", 2));
        samplerHepsi.add(new SampiyonKristali(73, "Morgana", 2));
        samplerHepsi.add(new SampiyonKristali(74, "Nami", 4));
        samplerHepsi.add(new SampiyonKristali(75, "Nasus", 2));
        samplerHepsi.add(new SampiyonKristali(76, "Nautilus", 4));
        samplerHepsi.add(new SampiyonKristali(77, "Neeko", 5));
        samplerHepsi.add(new SampiyonKristali(78, "Nidalee", 3));
        samplerHepsi.add(new SampiyonKristali(79, "Nocturne", 4));
        samplerHepsi.add(new SampiyonKristali(80, "Nunu & Willump", 1));
        samplerHepsi.add(new SampiyonKristali(81, "Olaf", 3));
        samplerHepsi.add(new SampiyonKristali(82, "Orianna", 4));
        samplerHepsi.add(new SampiyonKristali(83, "Ornn", 5));
        samplerHepsi.add(new SampiyonKristali(84, "Pantheon", 3));
        samplerHepsi.add(new SampiyonKristali(85, "Poppy", 1));
        samplerHepsi.add(new SampiyonKristali(86, "Pyke", 5));
        samplerHepsi.add(new SampiyonKristali(87, "Quinn", 4));
        samplerHepsi.add(new SampiyonKristali(88, "Rakan", 5));
        samplerHepsi.add(new SampiyonKristali(89, "Rammus", 2));
        samplerHepsi.add(new SampiyonKristali(90, "Rek'Sai", 5));
        samplerHepsi.add(new SampiyonKristali(91, "Renekton", 4));
        samplerHepsi.add(new SampiyonKristali(92, "Rengar", 4));
        samplerHepsi.add(new SampiyonKristali(93, "Riven", 4));
        samplerHepsi.add(new SampiyonKristali(94, "Rumble", 4));
        samplerHepsi.add(new SampiyonKristali(95, "Ryze", 1));
        samplerHepsi.add(new SampiyonKristali(96, "Sejuani", 4));
        samplerHepsi.add(new SampiyonKristali(97, "Shaco", 3));
        samplerHepsi.add(new SampiyonKristali(98, "Shen", 3));
        samplerHepsi.add(new SampiyonKristali(99, "Shyvana", 3));
        samplerHepsi.add(new SampiyonKristali(100, "Singed", 1));
        samplerHepsi.add(new SampiyonKristali(101, "Sion", 2));
        samplerHepsi.add(new SampiyonKristali(102, "Sivir", 1));
        samplerHepsi.add(new SampiyonKristali(103, "Skarner", 4));
        samplerHepsi.add(new SampiyonKristali(104, "Sona", 3));
        samplerHepsi.add(new SampiyonKristali(105, "Soraka", 1));
        samplerHepsi.add(new SampiyonKristali(106, "Swain", 4));
        samplerHepsi.add(new SampiyonKristali(107, "Sylas", 6));
        samplerHepsi.add(new SampiyonKristali(108, "Syndra", 4));
        samplerHepsi.add(new SampiyonKristali(109, "Tahm Kench", 5));
        samplerHepsi.add(new SampiyonKristali(110, "Taliyah", 5));
        samplerHepsi.add(new SampiyonKristali(111, "Talon", 4));
        samplerHepsi.add(new SampiyonKristali(112, "Taric", 2));
        samplerHepsi.add(new SampiyonKristali(113, "Teemo", 2));
        samplerHepsi.add(new SampiyonKristali(114, "Thresh", 4));
        samplerHepsi.add(new SampiyonKristali(115, "Tristana", 2));
        samplerHepsi.add(new SampiyonKristali(116, "Trundle", 4));
        samplerHepsi.add(new SampiyonKristali(117, "Tryndamare", 2));
        samplerHepsi.add(new SampiyonKristali(118, "Twisted Fate", 2));
        samplerHepsi.add(new SampiyonKristali(119, "Twitch", 3));
        samplerHepsi.add(new SampiyonKristali(120, "Udyr", 2));
        samplerHepsi.add(new SampiyonKristali(121, "Urgot", 3));
        samplerHepsi.add(new SampiyonKristali(122, "Varus", 4));
        samplerHepsi.add(new SampiyonKristali(123, "Vayne", 4));
        samplerHepsi.add(new SampiyonKristali(124, "Veigar", 2));
        samplerHepsi.add(new SampiyonKristali(125, "Vel'Koz", 5));
        samplerHepsi.add(new SampiyonKristali(126, "Vi", 4));
        samplerHepsi.add(new SampiyonKristali(127, "Viktor", 4));
        samplerHepsi.add(new SampiyonKristali(128, "Vladimir", 3));
        samplerHepsi.add(new SampiyonKristali(129, "Volibear", 4));
        samplerHepsi.add(new SampiyonKristali(130, "Warwick", 1));
        samplerHepsi.add(new SampiyonKristali(131, "Wukong", 4));
        samplerHepsi.add(new SampiyonKristali(132, "Xayah", 5));
        samplerHepsi.add(new SampiyonKristali(133, "Xerath", 4));
        samplerHepsi.add(new SampiyonKristali(134, "Xin Zhao", 2));
        samplerHepsi.add(new SampiyonKristali(135, "Yasuo", 5));
        samplerHepsi.add(new SampiyonKristali(136, "Yorick", 5));
        samplerHepsi.add(new SampiyonKristali(137, "Zac", 5)); // Fiyatı düsecek yakinda.
        samplerHepsi.add(new SampiyonKristali(138, "Zed", 4));
        samplerHepsi.add(new SampiyonKristali(139, "Ziggs", 4));
        samplerHepsi.add(new SampiyonKristali(140, "Zilean", 2));
        samplerHepsi.add(new SampiyonKristali(141, "Zoe", 5));
        samplerHepsi.add(new SampiyonKristali(142, "Zyra", 4));

        nadirlikDagit();
    }

    private void nadirlikDagit() {
        for (int i = 1; i < samplerHepsi.size(); i++) {
            SampiyonKristali sampiyonKristali = samplerHepsi.get(i);
            if (sampiyonKristali.getNadirlikId() == 1) {
                samplerN1.add(sampiyonKristali);
            } else if (sampiyonKristali.getNadirlikId() == 2) {
                samplerN2.add(sampiyonKristali);
            } else if (sampiyonKristali.getNadirlikId() == 3) {
                samplerN3.add(sampiyonKristali);
            } else if (sampiyonKristali.getNadirlikId() == 4) {
                samplerN4.add(sampiyonKristali);
            } else if (sampiyonKristali.getNadirlikId() == 5) {
                samplerN5.add(sampiyonKristali);
            } else if (sampiyonKristali.getNadirlikId() == 6) {
                samplerN6.add(sampiyonKristali);
            }
        }
    }

    SampiyonKristali getSampById(int id) {
        return samplerHepsi.get(id);
    }

    SampiyonKristali getSamp(int nadirlik) {
        ArrayList<SampiyonKristali> liste;
        if (nadirlik == 1) {
            liste = samplerN1;
        } else if (nadirlik == 2) {
            liste = samplerN2;
        } else if (nadirlik == 3) {
            liste = samplerN3;
        } else if (nadirlik == 4) {
            liste = samplerN4;
        } else if (nadirlik == 5) {
            liste = samplerN5;
        } else {
            liste = samplerN6;
        }
        Random r = new Random();
        return liste.get(r.nextInt(liste.size()));
    }
}
