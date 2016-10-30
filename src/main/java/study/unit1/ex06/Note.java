package study.unit1.ex06;

/**
 * Класс описыват запись в блокноте.
 */

class Note {

    private String text;

    Note(String text){
        this.text=text;
    }

    void setText(String text){
        this.text=text;
    }

    String getText(){

        return text;
    }
}
