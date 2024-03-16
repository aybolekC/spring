package com.aya.tightly_coupled;

public class AyaApp {
    public static void main(String[] args) {

        FullTimeMentor fullTime=new FullTimeMentor();
        PartTimeMentor partTime=new PartTimeMentor();

        Mentor mentor=new Mentor(fullTime, partTime);
        mentor.manageAccount();
    }
}
