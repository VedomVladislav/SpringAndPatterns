package adapter.adapter;

import adapter.objects.Printer;

import java.util.List;

//адаптер совмещает желание клиента отправлять на печать лист и возможности принтера
public class PrinterAdapter implements PrintListPrinter {

    private Printer printer = new Printer();

    public void print(List<String> list) {
        for (String s: list) {
            printer.print(s);
        }
    }

}
