package com.example.multiscreenapp.Adapter;

public class Words {
    private String engWord;
    private String miworkWord;
    private int Imageid;
    private boolean isPhraseActivity = false;
    private int AudioResourceId;

    public Words(String engWord, String miworkWord, int AudioResourceId) {
        this.engWord = engWord;
        this.miworkWord = miworkWord;
        this.isPhraseActivity = true;
        this.AudioResourceId = AudioResourceId;
    }

    public Words(String engWord, String miworkWord, int imageid, int AudioResourceId) {
        this.engWord = engWord;
        this.miworkWord = miworkWord;
        Imageid = imageid;
        this.AudioResourceId = AudioResourceId;
    }

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }

    public String getMiworkWord() {
        return miworkWord;
    }

    public void setMiworkWord(String miworkWord) {
        this.miworkWord = miworkWord;
    }

    public int getImageid() {
        return Imageid;
    }

    public void setImageid(int imageid) {
        Imageid = imageid;
    }

    public boolean isPhraseActivity() {
        return isPhraseActivity;
    }

    public int getAudioResourceId() {
        return AudioResourceId;
    }
}
