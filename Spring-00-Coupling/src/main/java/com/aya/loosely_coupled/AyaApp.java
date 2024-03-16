package com.aya.loosely_coupled;

public class AyaApp {
    public static void main(String[] args) {

        FullTimeMentor fullTime=new FullTimeMentor();
        PartTimeMentor partTime=new PartTimeMentor();


        MentorAccount mentor=new MentorAccount(fullTime);
        mentor.manageAccount();


    }
}
