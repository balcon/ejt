package study.unit1.ex06;

import java.util.Arrays;

/**
 * Класс описывает "Блокнот".
 * Записи представляют из себя экземпляры класса {@link Note}
 */

public class NoteBook {

    private int size = 0;
    private Note[] note;

    /**
     * Конструктор без параметров создает "Блокнот" с начальной вместимостью 10.
     */
    NoteBook() {
        note = new Note[10];
    }

    /**
     * Создание блокнота.
     *
     * @param size начальная вместимость блокнота
     */
    NoteBook(int size) {
        note = new Note[size];
    }

    /**
     * Создает новую запись в блокноте.
     * При переполнени массива создается новый вместимостью 2n+1
     *
     * @param text текст записи
     */
    public void createNote(String text) {

        size++;
        if (size == note.length + 1) {
            int newCapacity = note.length * 2 + 1;
            note = Arrays.copyOf(note, newCapacity);
            // note=tempArray;
        }
        note[size - 1] = new Note(text);

    }

    /**
     * Уменьшает вместимость блоктнота, по кол-ву текущих записей.
     */
    public void trimToSize() {

        note = Arrays.copyOf(note, size);
    }

    /**
     * Удаляет запись по номеру.
     *
     * @param number номер удаляемой запси
     */
    public void removeNote(int number) {
        for (int i = number; i < size - 1; i++) note[i] = note[i + 1];
        size--;
    }

    /**
     * Редактирует запись.
     *
     * @param number номер записи
     * @param text   новый текст записи
     */
    public void editNote(int number, String text) {
        note[number].setText(text);
    }

    /**
     * Выводит содержимое блокнота в консоль
     */
    public void showAllNotes() {
        System.out.println();
        System.out.println("- NoteBook -");
        for (int i = 0; i < size; i++) System.out.println(i + ". " + note[i].getText());
        System.out.println();
    }
}