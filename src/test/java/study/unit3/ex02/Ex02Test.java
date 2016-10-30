package study.unit3.ex02;

import org.junit.Test;

import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Ex02Test {

    @Test
    public void test(){
        Answerer ansRU=new Answerer("ru");
        Answerer ansEN=new Answerer("en");

        ansRU.showAllQuestions();
     /* Список вопросов:
        1. Почему трава зеленая?
        2. Почему небо голубое?
        3. Сколько звезд на небе?
        4. Почему пингвины не летают? */

        ansRU.showAnswer(1);
        ansRU.showAnswer(3);

     /* Вопрос: Почему трава зеленая?
        Ответ: Растительные клетки содержат хлорофилл.
        Вопрос: Сколько звезд на небе?
        Ответ: Около 10²² звезд. */

        ansEN.showAllQuestions();

   /*   List of questions:
        1. Why is the grass green?
        2. Why is the sky bly?
        3. How many stars in the sky?
        4. Why penguins can't fly? */

        ansEN.showAnswer(2);
        ansEN.showAnswer(4);

     /* Question: Why is the sky bly?
        Answer: Because the air scatters ligth with short wavelength.
        Question: Why penguins can't fly?
        Answer: Because they have fear of flying. */
    }
}
