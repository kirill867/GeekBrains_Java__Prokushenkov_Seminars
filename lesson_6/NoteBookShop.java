package lesson_6;

import java.util.*;

public class NoteBookShop {
    HashMap<Integer, NoteBook> noteBooks = new HashMap<>();
    TreeMap<Integer, String> filtersList = new TreeMap<>();
    LinkedHashMap<String, TreeMap<Integer, String>> filtersValues = new LinkedHashMap<>();
    HashMap<String, String> userFilters = new HashMap<>();

    public void addNoteBook(NoteBook nbook) {
        noteBooks.put(noteBooks.size(), nbook); //Добавляем ноутбук в коллекцию
        for (String specKey : nbook.spec.keySet()) { //Цикл добавления характеристик ноутбука в спискок фильтров
            if (!this.filtersList.containsValue(specKey))
                this.filtersList.put(filtersList.size() + 1, specKey); //Добавление фильтра
            if (!this.filtersValues.containsKey(specKey)) { //Добавление значения фильтра
                TreeMap<Integer, String> values = new TreeMap<>();
                values.put(1, nbook.spec.get(specKey));
                this.filtersValues.put(specKey, values);
            } else {
                TreeMap<Integer, String> values = this.filtersValues.get(specKey);
                if (!values.containsValue(nbook.spec.get(specKey))) {
                    values.put(values.size() + 1, nbook.spec.get(specKey));
                }

                this.filtersValues.put(specKey, values);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("All goods: \n");
        for (Integer nbook : noteBooks.keySet()) {
            result.append(this.noteBooks.get(nbook).toString());
        }

        return result.toString();
    }

    public void userMenu() {
        System.out.printf("Ноутбуковый магазин!\n1) Добавить/удалить фильтры\n2) Применить фильтры(выбрано: %d%s)\n->", this.userFilters.size(), this.userFiltersToString());
        Scanner scan = new Scanner(System.in);
        while (true) {
            int selection = scan.nextInt();
            switch (selection) {
                case 1:
                    userFiltersMenu();
                    break;
                case 2:
                    applyUserFilters();
                    this.userMenu();
                    break;
                default:
                    System.out.println("Введите 1 или 2.\n->");
                    break;
            }

        }
    }

    private void applyUserFilters() {
        for (Integer nbookID : this.noteBooks.keySet()) {
            if (this.noteBooks.get(nbookID).filterEquality(this.userFilters)) {
                System.out.print(noteBooks.get(nbookID).toString() + "\n");
            }
        }
    }

    private void userFiltersMenu() {
        System.out.printf("Выбрано фильтров: %d%s.\n", this.userFilters.size(), this.userFiltersToString());
        System.out.println("Выберите фильтр(0 для возврата):");
        StringBuilder result = new StringBuilder();
        for (Integer fKey : filtersList.keySet()) {
            result.append(fKey).append(": ").append(this.filtersList.get(fKey)).append("\n");
        }
        System.out.print(result.append("->"));
        Scanner scan = new Scanner(System.in);
        while (true) {
            int selection = scan.nextInt();
            if (selection != 0 && filtersList.containsKey(selection)) {
                userFilterValueMenu(selection);
            } else if (selection == 0) {
                userMenu();
            } else {
                System.out.println("Выберите доступные фильтры или введите 0 для возрата.");
            }
        }

    }

    private void userFilterValueMenu(Integer filterID) {
        System.out.printf("Выберите значение фильтра %s(0 для удаления фильтра):\n", this.filtersList.get(filterID));

        StringBuilder result = new StringBuilder();
        TreeMap<Integer, String> filterValues = filtersValues.get(filtersList.get(filterID));
        for (Integer fKey : filterValues.keySet()) {
            result.append(fKey).append(": ").append(filterValues.get(fKey)).append("\n");
        }
        System.out.print(result.append("->"));
        Scanner scan = new Scanner(System.in);
        while (true) {
            int selection = scan.nextInt();
            if (selection != 0 && this.filtersList.containsKey(selection)) {
                this.userFilters.put(this.filtersList.get(filterID), filterValues.get(selection));
                this.userFiltersMenu();
            } else if (selection == 0) {
                this.userFilters.remove(this.filtersList.get(filterID));
                this.userFiltersMenu();
            } else {
                System.out.println("Выберите доступные фильтры или введите 0 для возрата.");
            }
        }
    }

    private String userFiltersToString() {
        StringBuilder result = new StringBuilder();
        for (String fKey : this.userFilters.keySet()) {
            result.append(fKey).append(": ").append(this.userFilters.get(fKey)).append("; ");
        }
        if (result.length() > 0) {
            return "(" + result.delete(result.length() - 2, result.length()) + ")";
        } else return "";

    }
}