package ru.yesipov.springsource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ClassicalMusic classicalMusic = context.getBean("musicBean",ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());

        //Music music = context.getBean("musicBean",Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(music);
//        MusicPlayer musicPlayer1 = context.getBean("musicPlayer",MusicPlayer.class);
//        MusicPlayer musicPlayer2 = context.getBean("musicPlayer",MusicPlayer.class);
//
//        boolean comparison = musicPlayer1 == musicPlayer2;
//
//        System.out.println(comparison);
//        System.out.println(musicPlayer1);
//        System.out.println(musicPlayer2);
//
//        musicPlayer1.setVolume(10);
//        System.out.println(musicPlayer1.getVolume());
//        System.out.println(musicPlayer2.getVolume());
        context.close();
    }
}
