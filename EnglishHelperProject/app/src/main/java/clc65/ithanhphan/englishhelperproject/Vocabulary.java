package clc65.ithanhphan.englishhelperproject;

public class Vocabulary {
    private int vocabularyID;
    private String word, note;

    public Vocabulary(int vocabularyID, String word, String note) {
        this.vocabularyID = vocabularyID;
        this.word = word;
        this.note = note;
    }

    public Vocabulary(String word, String note) {
        this.word = word;
        this.note = note;
    }

    public Vocabulary() {}

    public int getVocabularyID() {
        return vocabularyID;
    }

    public void setVocabularyID(int vocabularyID) {
        this.vocabularyID = vocabularyID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
