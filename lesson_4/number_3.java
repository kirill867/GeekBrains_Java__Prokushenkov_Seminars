package lesson_4;

public class number_3{
    private int[] column; // Есть ли ферзь в том же столбце, 1 означает, что есть
    private int[] rup; // Есть ли ферзь сверху справа налево снизу
    private int[] lup; // Есть ферзь сверху слева направо снизу
    private int[] queen; //ответ
    private int num; // Номер решения
 
    public number_3() {
        column = new int[8+1];
        rup = new int[(2*8)+1];
        lup = new int[(2*8)+1];
        for (int i = 1; i <= 8; i++)
            column[i] = 0;
        for (int i = 1; i <= (2*8); i++)
            rup[i] = lup[i] = 0;  // Исходное определение - все без ферзя
        queen = new int[8+1];
    }
 
    public void backtrack(int i) {
        if (i > 8) {
            showAnswer();
        } else {
            for (int j = 1; j <= 8; j++) {
                if ((column[j] == 0) && (rup[i+j] == 0) && (lup[i-j+8] == 0)) {
                    // Если ферзя нет
                    queen[i] = j; // Установить как занятый
                    column[j] = rup[i+j] = lup[i-j+8] = 1;
                    backtrack(i+1);  // Вызов рекурсии
                    column[j] = rup[i+j] = lup[i-j+8] = 0;
                }
            }
        }
    }
 
    protected void showAnswer() {
        num++;
        System.out.println("\n Ответ" + num);
        for (int y = 1; y <= 8; y++) {
            for (int x = 1; x <= 8; x++) {
                if(queen[y]==x) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" x ");
                }
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        number_3 queen = new number_3();
        queen.backtrack(1);
    }
}